package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import providers.ChatBotPolicesHelpProvider;

public class ChatBotPolicesHelp extends BaseClass {

	@Test(priority=1, groups = "ChatBotHelp",dataProvider="FindChatBotProvider", dataProviderClass = ChatBotPolicesHelpProvider.class)
	public void FindChatBot(String XpathButtonHelp, String IdChatBot, String XpathPoliticasdeUso) throws InterruptedException, IOException
	{
		test = report.startTest("ChatBotHelp", "Al hacer click en el Banner del chat bot debería volver a mostrar la ventana de aceptación de permisos.");
		WaitToClik(Android, XpathButtonHelp, 10);
		test.log(LogStatus.INFO, "Hacer clic en el boton Ayuda");
		time.sleep(1);
		Android.findElement(By.xpath(XpathButtonHelp)).click();
		TakeScreenShot("ChatBot_1");
		test.log(LogStatus.PASS, "Pass");
		scrollToUp();		
		test.log(LogStatus.INFO, "Buscar Banner del ChatBot");
		//Android.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"ChatBot\"))");
		WaitToClikById(Android, IdChatBot, 10);
		TakeScreenShot("ChatBot_2");
		
		Android.findElement(By.id(IdChatBot)).click();
		test.log(LogStatus.INFO, "Click en Banner Chatbot");
		WaitToClik(Android, XpathPoliticasdeUso, 10);
		if(Android.findElement(By.xpath(XpathPoliticasdeUso)).isEnabled())
		{
			test.log(LogStatus.PASS, "Se muestran las políticas de uso");
			TakeScreenShot("ChatBot_2");
		}else
		{
			test.log(LogStatus.FAIL, "No se muestran las políticas de uso");
		}
		
	}
}
