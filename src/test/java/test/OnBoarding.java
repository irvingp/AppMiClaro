package test;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

import providers.OnBoardingProviders;

import org.testng.annotations.BeforeGroups;



public class OnBoarding extends BaseClass{

	@Test(priority = 1, groups = {"Boarding-1"}, dataProvider = "PoliticasAccesoProvider",dataProviderClass = OnBoardingProviders.class)
	public void PoliticasAcceso(String XpathPoliticasdeUso,String XpathBtnAcepta, String XpathBtnPermitir)
	{
		System.out.println("Test 1");
		System.out.println(XpathPoliticasdeUso);
		System.out.println(XpathBtnAcepta);
		
		WaitToClik(Android,XpathPoliticasdeUso, 10);
		Android.findElement(By.xpath(XpathBtnAcepta)).click();
		  
		WaitToClik(Android,XpathBtnPermitir, 10);
		Android.findElement(By.xpath(XpathBtnPermitir)).click();
		 
		
	}

	
	
	  @BeforeGroups(groups = "Boarding-2") public void BeforeUbicacion() {
	  System.out.println("Before Test 2");
	  WaitToClik(Android,"//android.widget.TextView[@text='Ubicación']",10);
	  
	  }
	  
	  @Test(priority = 2, groups = {"Boarding-2"}) public void Ubicacion() {
	  System.out.println("Test 2");
	  Android.findElement(By.id("com.claro.miclaro:id/txv_country_name")).click();
	  Android.findElement(
	  By.xpath("//android.widget.Button[@text='Confirmar']")).click();
	  
	  }
	 
	
	
}
