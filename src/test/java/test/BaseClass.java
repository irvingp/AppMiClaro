package test;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


public class BaseClass {
	
	public static ExtentReports report;
	public static ExtentTest test;
	public static AndroidDriver<MobileElement> Android;
	public static TimeUnit time;
	private static String SuiteName;
		
	@BeforeSuite
	public void SetUp(ITestContext context)
	{
		System.out.println("Before Suit");
		try {
		SuiteName=context.getSuite().getName();
		DesiredCapabilities caps = new DesiredCapabilities(); 
		
		//caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, 	"UiAutomator2");
		
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, 		"Redmi Note 9");
		caps.setCapability(MobileCapabilityType.UDID, 		 		"059297700405");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,		"Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, 	"11 RP1A.200720.011");
		
		//caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		caps.setCapability("appPackage", "com.claro.miclaro");
		caps.setCapability("appActivity", "com.claro.miclaro.view.SplashKTVC");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		report = ExtentManager.getReporter(SuiteName+"-ExtendsReport.html");
		time = TimeUnit.SECONDS;
		
		Android = new AndroidDriver<MobileElement>(url, caps);
		
		}catch(Exception ex)
		{
			
			
			  System.out.println("Message is: " + ex.getMessage());
			  System.out.println("Cause is: " + ex.getCause());
			  System.out.println(ex.getStackTrace());
			 
			
		}
		
	}
	
	@AfterMethod
    protected void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(LogStatus.FAIL, result.getThrowable().getMessage());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable().getMessage());
        } else {
            test.log(LogStatus.PASS, "Test passed");
        }
        
        report.endTest(test);        
        report.flush();
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

	/*
	 * public boolean WaitToClick(AndroidDriver<MobileElement> Android, String
	 * xpath, long timeLimitInSeconds) { try {
	 * 
	 * 
	 * WebDriverWait wait = new WebDriverWait(Android, timeLimitInSeconds);
	 * if(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).
	 * isDisplayed()) { return true; } else { return false; }
	 * 
	 * 
	 * } catch (Exception ex) { System.out.println("Message is: " +
	 * ex.getMessage()); System.out.println("Cause is: " + ex.getCause());
	 * System.out.println(ex.getStackTrace()); return false; } }
	 */
	public void WaitToClikById(AndroidDriver<MobileElement> Android, String Id , long timeLimitInSeconds)
	{
		try {
			
			WebDriverWait wait = new WebDriverWait(Android, timeLimitInSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Id)));
			
		} catch (Exception ex) {	
			  System.out.println("Message is: " + ex.getMessage());
			  System.out.println("Cause is: " + ex.getCause());
			  System.out.println(ex.getStackTrace());			
		}
	}

	

	
	public void TakeScreenShot(String FileName) throws IOException
	{
		
		File scrFile = ((TakesScreenshot)Android).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("ScreenShot/"+SuiteName+"_"+FileName+".png"));
		test.log(LogStatus.INFO, "Captura de Pantalla: " + test.addScreenCapture("ScreenShot/"+SuiteName+"_"+FileName+".png"));
	}
	
	public String TakeScreenShotReturnTextOnBoarding(String FileName) throws IOException, TesseractException
	{
		File scrFile = ((TakesScreenshot)Android).getScreenshotAs(OutputType.FILE);
		String RelativePath = "ScreenShot/"+SuiteName+"_"+FileName+".png";
		FileUtils.copyFile(scrFile, new File(RelativePath));
		
		test.log(LogStatus.INFO, "Captura de Pantalla: " + test.addScreenCapture(RelativePath));
		
		Tesseract tesseract = getTesseract();
		File file = new File(RelativePath.replace("/", "\\"));
		String result = tesseract.doOCR(file,new Rectangle(48,1424,1000,260));
		
		return result.replaceAll("\n", " ").trim();
		
		
	}
	private static Tesseract getTesseract() {
		Tesseract instance = new Tesseract();
		instance.setDatapath(System.getProperty("user.dir")+"\\Tess4J\\tessdata");
		instance.setLanguage("spa");
		//instance.setHocr(true);
		return instance;
		}
	
	public void scrollToUp() {

	      int  x = Android.manage().window().getSize().width / 2;
	      int start_y = (int) (Android.manage().window().getSize().height * 0.8);
	      int end_y = (int) (Android.manage().window().getSize().height * 0.2);
	        TouchAction dragNDrop = new TouchAction(Android)
	                        .press(PointOption.point(x,start_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
	                        .moveTo(PointOption.point(x, end_y))
	                        .release();
	        dragNDrop.perform();
	    }
	
	public void scrollToDown() {

	      int  x = Android.manage().window().getSize().width / 2;
	      int start_y = (int) (Android.manage().window().getSize().height * 0.2);
	      int end_y = (int) (Android.manage().window().getSize().height * 0.8);
	        TouchAction dragNDrop = new TouchAction(Android)
	                        .press(PointOption.point(x,start_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
	                        .moveTo(PointOption.point(x, end_y))
	                        .release();
	        dragNDrop.perform();
	    }
	@AfterSuite
	public void TearDown()
	{
		System.out.println("After Suit");
		report.close();
		Android.quit();
		
		
	}
	
	
}
