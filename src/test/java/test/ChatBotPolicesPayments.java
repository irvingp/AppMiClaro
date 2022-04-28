package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import providers.ChatBotPolicesPaymentsProvier;

public class ChatBotPolicesPayments extends BaseClass {

	@Test(priority=1, groups = "ChatBotPayments",dataProvider="FindChatBotPaymentsProvider", dataProviderClass = ChatBotPolicesPaymentsProvier.class)
	public void FindChatBotPayments(String XpathPagos, String XpathScrollView, String XpathCompraPaquetes, String XpathPoliticasdeUso, String XpathButtonCancel) throws InterruptedException, IOException
	{
		test = report.startTest("ChatBotPolicesPayments","Al hacer click en el Banner del chat bot deber�a volver a mostrar la ventana de aceptaci�n de permisos.");
		WaitToClik(Android, XpathButtonCancel, 10);
		Android.findElement(By.xpath(XpathButtonCancel)).click();
		
		WaitToClik(Android, XpathPagos, 10);
		test.log(LogStatus.INFO, "Clic en Boton de navegaci�n \"Pagos\"");
		Android.findElement(By.xpath(XpathPagos)).click();
		TakeScreenShot("ChatBotPayments_1");
		Android.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Comprar Paquetes\"))");
		test.log(LogStatus.INFO, "Busca el Bot�n Arma tu Prepago");
		TakeScreenShot("ChatBotPayments_2");
		/*
		 * Android.
		 * findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)."
		 * + "classNameMatches(\"android.widget.HorizontalScrollView\"))" +
		 * ".setAsHorizontalList().scrollIntoView(new UiSelector().textContains(\"Arma tu Prepago\"))"
		 * ).click();
		 */
		WaitToClik(Android, XpathPoliticasdeUso, 10);
		if(Android.findElement(By.xpath(XpathPoliticasdeUso)).isEnabled())
		{
			test.log(LogStatus.PASS, "Se muestran las pol�ticas de uso");
		}else
		{
			test.log(LogStatus.FAIL, "No se muestran las pol�ticas de uso");
		}
	}
}
