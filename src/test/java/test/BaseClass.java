package test;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;




import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class BaseClass {

	
	AndroidDriver<MobileElement> Android;
		
	@BeforeSuite
	public void SetUp()
	{
		System.out.println("Before Suit");
		try {
		DesiredCapabilities caps = new DesiredCapabilities(); 
		
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, 	"UiAutomator2");
		
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, 		"Redmi Note 9");
		caps.setCapability(MobileCapabilityType.UDID, 		 		"059297700405");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,		"Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, 	"11 RP1A.200720.011");
		
		//caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		caps.setCapability("appPackage", "com.claro.miclaro");
		caps.setCapability("appActivity", "com.claro.miclaro.view.SplashKTVC");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		Android = new AndroidDriver<MobileElement>(url, caps);
		
		}catch(Exception ex)
		{
			
			
			  System.out.println("Message is: " + ex.getMessage());
			  System.out.println("Cause is: " + ex.getCause());
			  System.out.println(ex.getStackTrace());
			 
			
		}
		
	}
	
	
	public void WaitToClik(AndroidDriver<MobileElement> Android, String targetResourceXpath , long timeLimitInSeconds)
	{
		try {
			
			WebDriverWait wait = new WebDriverWait(Android, timeLimitInSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(targetResourceXpath)));
			
		} catch (Exception ex) {	
			  System.out.println("Message is: " + ex.getMessage());
			  System.out.println("Cause is: " + ex.getCause());
			  System.out.println(ex.getStackTrace());			
		}
	}
	
	@AfterSuite
	public void TearDown()
	{
		System.out.println("After Suit");
		Android.close();
		Android.quit();
		
	}
	
	
}
