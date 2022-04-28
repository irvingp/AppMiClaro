package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import providers.ActivateDigitalInvoiceProvider;


public class ActivateDigitalInvoice extends BaseClass {
	
	@BeforeClass(groups = "Onboarding")
	public void init()
	{
		test = report.startTest("Activacion de factura digital.");
	}

	@Test(priority =1, dataProvider = "NavigateToInvoiceSubscriptionProvider", dataProviderClass = ActivateDigitalInvoiceProvider.class)	
	public void NavigateToInvoiceSubscription(String ArrowButton, String MenuButton, String XpathMiFactura, String IdTitleDigitalInvoice) throws IOException, InterruptedException
	{
		test.log(LogStatus.INFO, "Navegar hacia la subscripción de factura digital");
		Android.findElement(By.xpath(ArrowButton)).click();
		int index = 1;
		String xpath ="//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+String.valueOf(index)+"]/android.widget.TextView[2]";
		WaitToClik(Android, xpath, index+5);
		
		while(!Android.findElement(By.xpath(xpath)).getText().equals("Móvil Postpago"))
		{
			index++;
			xpath ="//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+String.valueOf(index)+"]/android.widget.TextView[2]";
			
			if(index == 20)
			{
				Assert.assertTrue(false);
				return;
				
			}
		}
		test.log(LogStatus.INFO, "Seleccionar servicio PostPago");
		Android.findElement(By.xpath(xpath)).click();
		TakeScreenShot("ActivateDigitalInvoice_1");
		WaitToClik(Android, MenuButton, 10);
		Android.findElement(By.xpath(MenuButton)).click();
		TakeScreenShot("ActivateDigitalInvoice_2");
		scrollToUp();
		Assert.assertEquals(Android.findElements(By.id(IdTitleDigitalInvoice)).isEmpty(), false);	 
		
	}
	@Test(priority=2, dataProvider = "CheckDigitalInvoiceActivationProvider",dataProviderClass = ActivateDigitalInvoiceProvider.class)
	public void CheckDigitalInvoiceActivation(String IdTitleDigitalInvoice, String IdSubtitleDigitalInvoice, String IdButtonSubscribe, String TextTitle, String TextSubTitle, String TextButton) throws IOException
	{
		//Titulo
		test.log(LogStatus.INFO, "Verifica el titulo de la activación de factura digital.");
		WaitToClikById(Android, IdTitleDigitalInvoice, 5);
		String text = Android.findElement(By.id(IdTitleDigitalInvoice)).getText().replace("\n","").trim();
		if(text.equals(TextTitle))
		{
			test.log(LogStatus.PASS, "El texto coindice correctamente");
			TakeScreenShot("ActivateDigitalInvoice_3");
		}else
		{
			test.log(LogStatus.FAIL, "Los textos no coinciden.\nTexto esperado: "+"\""+ TextTitle +"\"\nTexto presentado: " + "\""+text+"\"");
			TakeScreenShot("ActivateDigitalInvoice_3");
		}
		// Sub titulo 
		test.log(LogStatus.INFO, "Verifica el SubTitulo de la activación de factura digital.");
		WaitToClikById(Android, IdSubtitleDigitalInvoice, 5);
		text = Android.findElement(By.id(IdSubtitleDigitalInvoice)).getText().replace("\n","").trim();
		if(text.equals(TextSubTitle))
		{
			test.log(LogStatus.PASS, "El texto coindice correctamente");
			TakeScreenShot("ActivateDigitalInvoice_3");
		}else
		{
			test.log(LogStatus.FAIL, "Los textos no coinciden.\nTexto esperado: "+"\""+ TextSubTitle +"\"\nTexto presentado: " + "\""+text+"\"");
			TakeScreenShot("ActivateDigitalInvoice_3");
		}
		
		// Texto del Boton  
		test.log(LogStatus.INFO, "Verifica el SubTitulo de la activación de factura digital.");
		WaitToClikById(Android, IdButtonSubscribe, 5);
		text = Android.findElement(By.id(IdButtonSubscribe)).getText().replace("\n","").trim();
		if(text.equals(TextButton))
		{
			test.log(LogStatus.PASS, "El texto coindice correctamente");
			TakeScreenShot("ActivateDigitalInvoice_3");
			Android.findElement(By.id(IdButtonSubscribe)).click();
			
		}else
		{
			test.log(LogStatus.FAIL, "Los textos no coinciden.\nTexto esperado: "+"\""+ TextButton +"\"\nTexto presentado: " + "\""+text+"\"");
			TakeScreenShot("ActivateDigitalInvoice_3");
		}
		
	}
	
}
