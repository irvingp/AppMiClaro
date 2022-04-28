package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import providers.PrepaymentInvoiceProvider;

public class PrepaymentInvoice extends BaseClass {

	@Test(priority =1, dataProvider = "CheckPrepaymentsInvoiceProvider", dataProviderClass = PrepaymentInvoiceProvider.class)	
	public void CheckPrepaymentsInvoice(String ArrowButton, String MenuButton, String XpathMiFactura, String IdBalancesTitle) throws IOException, InterruptedException
	{
		test=report.startTest("Verificar que no existen facturas para Prepago.");
		WaitToClikById(Android, IdBalancesTitle, 20);
		Android.findElement(By.xpath(ArrowButton)).click();
		int index = 1;
		String xpath ="//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+String.valueOf(index)+"]/android.widget.TextView[2]";
		WaitToClik(Android, xpath, index+5);
		while(!Android.findElement(By.xpath(xpath)).getText().trim().equals("Móvil Prepago"))
		{
			
			xpath ="//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+String.valueOf(index)+"]/android.widget.TextView[2]";
			index++;
			if(index == 20)
			{
				Assert.assertTrue(false);
				return;
				
			}
		}
		Android.findElement(By.xpath(xpath)).click();
		test.log(LogStatus.INFO, "Selecciona servicio prepago.");
		TakeScreenShot("PrepaymentInvoice_1");
		WaitToClik(Android, MenuButton, 10);
		test.log(LogStatus.INFO, "Selecciona el boton pagos del menú");
		Android.findElement(By.xpath(MenuButton)).click();
		time.sleep(2);
		TakeScreenShot("PrepaymentInvoice_2");	
		test.log(LogStatus.INFO, "Verifica que no se presenta el apartado \"Facturas\".");
		TakeScreenShot("PrepaymentInvoice_3");
		Assert.assertEquals(Android.findElements(By.xpath(XpathMiFactura)).isEmpty(), true);		
	}
}
