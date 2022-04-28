package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import providers.WelcomeProvider;

public class WelComeIntro extends BaseClass{

	@BeforeClass
	public void init()
	{
		test = report.startTest("WelComeIntro");
	}
	
	@Test(priority=1, dataProvider = "OnBoardingTextOneProvider", dataProviderClass = WelcomeProvider.class)
	public void OnBoardingTextOne(String TextOnBoarding, String IdContinue, String XpathText) throws IOException, InterruptedException
	{
		WaitToClik(Android, XpathText,10);	
		test.log(LogStatus.INFO, "Verifica texto: \""+ TextOnBoarding+"\"");
		TakeScreenShot("Welcome_intro_1");
		time.sleep(1);
		Assert.assertEquals(Android.findElement(By.xpath(XpathText)).getText().trim(), TextOnBoarding);
		Android.findElement(By.id(IdContinue)).click();
	}
	
	@Test(priority=2, dataProvider = "OnBoardingTextTwoProvider", dataProviderClass = WelcomeProvider.class)
	public void OnBoardingTextTwo(String TextOnBoarding, String IdContinue, String XpathText) throws IOException, InterruptedException
	{
		WaitToClik(Android, XpathText,10);	
		test.log(LogStatus.INFO, "Verifica texto: \""+ TextOnBoarding+"\"");
		TakeScreenShot("Welcome_intro_2");
		time.sleep(1);
		Assert.assertEquals(Android.findElement(By.xpath(XpathText)).getText().trim(), TextOnBoarding);
		Android.findElement(By.id(IdContinue)).click();	
	}
	
	@Test(priority=3, dataProvider = "OnboardingTextThreeProvider", dataProviderClass = WelcomeProvider.class)
	public void OnBoardingTextThree(String TextOnBoarding, String IdContinue, String XpathText) throws IOException, InterruptedException
	{
		WaitToClik(Android, XpathText,10);	
		test.log(LogStatus.INFO, "Verifica texto: \""+ TextOnBoarding+"\"");
		TakeScreenShot("Welcome_intro_3");
		time.sleep(1);
		Assert.assertEquals(Android.findElement(By.xpath(XpathText)).getText().trim(), TextOnBoarding);
		Android.findElement(By.id(IdContinue)).click();	
	}
	
	@Test(priority=4, dataProvider = "OnboardingTextFourProvider", dataProviderClass = WelcomeProvider.class)
	public void OnBoardingTextFour(String TextOnBoarding, String IdContinue, String XpathText) throws IOException, InterruptedException
	{
		WaitToClik(Android, XpathText,10);	
		test.log(LogStatus.INFO, "Verifica texto: \""+ TextOnBoarding+"\"");
		TakeScreenShot("Welcome_intro_4");
		time.sleep(1);
		Assert.assertEquals(Android.findElement(By.xpath(XpathText)).getText().trim(), TextOnBoarding);
		Android.findElement(By.id(IdContinue)).click();
		
	}
	
	@Test(priority=5, dataProvider = "OnboardingTextFiveProvider", dataProviderClass = WelcomeProvider.class)
	public void OnBoardingTextFive(String TextOnBoarding, String IdContinue, String XpathText) throws IOException, InterruptedException
	{
		WaitToClik(Android, XpathText,10);	
		test.log(LogStatus.INFO, "Verifica texto: \""+ TextOnBoarding+"\"");
		TakeScreenShot("Welcome_intro_5");
		time.sleep(1);
		Assert.assertEquals(Android.findElement(By.xpath(XpathText)).getText().trim(), TextOnBoarding);
		Android.findElement(By.id(IdContinue)).click();
		
	}
}
