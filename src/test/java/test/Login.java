package test;

import java.io.IOException;


import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import providers.LoginProvider;

/*
 *  
 *  HN - pruebasvahn@gmail.com    Claro12345
 *  
 * NI - scarmelendez@gmail.com    Eloyscar4
 */
public class Login extends BaseClass{
	
	

	@Test(priority=1, groups = "Login", dataProvider = "DataLogin", dataProviderClass = LoginProvider.class, alwaysRun = true)
	public void LoginMiClaro(String Email, String Password, String XpathInicioSesion, String XpathEmail, String XpathPassword, String XpathBtnAccep) throws InterruptedException, IOException
	{
		 test = report.startTest("Login","Inicio de sesión");
		 WaitToClik(Android,XpathInicioSesion, 10);
		  test.log(LogStatus.INFO, "Insertar datos de acceso.");
		  Android.findElementByXPath(XpathEmail).sendKeys(Email);
		  Android.findElementByXPath(XpathPassword).sendKeys(Password);		
		  time.sleep(2);
		  TakeScreenShot("Login_1");
		  Android.findElementByXPath(XpathBtnAccep).click();
		 
		
	}
}
