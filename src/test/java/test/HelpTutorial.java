package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import providers.HelpTutorialProvider;



public class HelpTutorial extends BaseClass{

	@BeforeClass
	public void init()
	{
		test = report.startTest("Tutorial de Ayuda.");
	}
	
	@Test(priority=1, dataProvider="TestNavigateToTutorialProvider", dataProviderClass = HelpTutorialProvider.class)
	public void TestNavigateToTutorial(String ButtonHelp, String ButtonTutorial) throws IOException
	{
		
		test.log(LogStatus.INFO, "Hacer click en el boton Ayuda");
		WaitToClik(Android, ButtonHelp, 10);
		Android.findElement(By.xpath(ButtonHelp)).click();
		TakeScreenShot("HelpTurorial_1");
		
		test.log(LogStatus.INFO,"Hacer click en el boton Tutorial");
		WaitToClik(Android,ButtonTutorial, 10);
		Android.findElement(By.xpath(ButtonTutorial)).click();
		TakeScreenShot("TestNavigateToShowTutorial_1");
	}
	
	@Test(priority=2, dataProvider="TestShowTutorialProvider", dataProviderClass = HelpTutorialProvider.class)
	public void TestShowTutorial( String TextOnBoarding, String XpathText, String XpathButtonTutorial) throws IOException, InterruptedException
	{	
		
		test.log(LogStatus.INFO, "Verifica nuevamente la existencia del tutorial");
		WaitToClik(Android, XpathText,10);	
		test.log(LogStatus.INFO, "Verifica texto: \""+ TextOnBoarding+"\"");
		TakeScreenShot("HelpTurorial_4");
		time.sleep(1);
		Assert.assertEquals(Android.findElement(By.xpath(XpathText)).getText().trim(), TextOnBoarding);
		
	}
	
	@Test(priority=3, dataProvider="ReturnProvider", dataProviderClass = HelpTutorialProvider.class)
	public void Return( String IdSkipeIntro) throws IOException
	{
		test.log(LogStatus.INFO, "Hacer click en omitir para regresar a la pantalla anterior");
		WaitToClik(Android, IdSkipeIntro, 10);
		Android.findElement(By.id(IdSkipeIntro)).click();
		TakeScreenShot("HelpTurorial_3");
		
		
		
		
	}
	
	@Test(priority=4, dataProvider="TestShowTutorialProvider", dataProviderClass = HelpTutorialProvider.class)
	public void TestShowTutorialAgain( String TextOnBoarding, String XpathText, String XpathBtnTutorial) throws IOException, InterruptedException
	{
		Android.findElement(By.xpath(XpathBtnTutorial)).click();
		
		test.log(LogStatus.INFO, "Verifica nuevamente la existencia del tutorial");
		WaitToClik(Android, XpathText,10);	
		test.log(LogStatus.INFO, "Verifica texto: \""+ TextOnBoarding+"\"");
		TakeScreenShot("HelpTurorial_4");
		time.sleep(1);
		Assert.assertEquals(Android.findElement(By.xpath(XpathText)).getText().trim(), TextOnBoarding);
		
		
	}
	
	
}
