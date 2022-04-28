package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import providers.PassWelcomeIntroProvider;

public class PassWelcomeIntro extends BaseClass{

	@Test(priority = 1, groups = "PassIntro", dataProvider = "SkipeIntroProvider",dataProviderClass = PassWelcomeIntroProvider.class, alwaysRun = true) 
	  public void Ubicacion(String IdSkipeIntro) throws IOException, InterruptedException 
	  {
	  test = report.startTest("Pass Intro");
	  
	  WaitToClikById(Android, IdSkipeIntro, 10);
	  TakeScreenShot("PassWelcome_Intro_1");
	  Android.findElement(By.id(IdSkipeIntro)).click();
	  test.log(LogStatus.PASS, "Skipe Intro");
	  
	  }
}
