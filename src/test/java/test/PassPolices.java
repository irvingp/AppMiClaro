package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import providers.PassPolicesProviders;

public class PassPolices extends BaseClass{


	@BeforeClass(groups = "PassPolices")
	public void Init()
	{
		test = report.startTest("Acepta Politicas");
	}
	
	
	@Test(priority=1, groups = "PassPolices", dataProvider="AccepButttonProvider", dataProviderClass=PassPolicesProviders.class, alwaysRun=true)
	public void AceptaPoliticasdeUso(String XpathAccepButon)
	{
		
		Android.findElement(By.xpath(XpathAccepButon)).click();
		
	}
	
	@Test(priority=2, groups = "PassPolices", dataProvider="SkipePolicesProvider", dataProviderClass=PassPolicesProviders.class, alwaysRun=true)
	public void SkipePolices(String XpathSkipePolices)
	{
		WaitToClik(Android, XpathSkipePolices, 10);
		Android.findElement(By.xpath(XpathSkipePolices)).click();
	
	}
	@Test(priority = 3, groups="PassPolices", dataProvider="AcceptPermissions", dataProviderClass=PassPolicesProviders.class, alwaysRun=true)
	public void AcceptaPermiso(String XpatPermiso) throws IOException
	{
		
		WaitToClik(Android, XpatPermiso, 5);
		TakeScreenShot("PassPolice_1");
		Android.findElement(By.xpath(XpatPermiso)).click();
		
	}
	
	
}
