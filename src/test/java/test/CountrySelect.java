package test;

import java.io.IOException;

import org.openqa.selenium.By;

import org.testng.annotations.Test;


import com.relevantcodes.extentreports.LogStatus;

import providers.CountrySelectProvider;

public class CountrySelect extends BaseClass {


	@Test(priority = 1, groups = "Country", dataProvider = "ActionsCountrySelectProvider",dataProviderClass = CountrySelectProvider.class, alwaysRun = true) 
	  public void Ubicacion(String XpathUbicacion, String idComboPais, String XpathBtnConfirmar, String Country) throws IOException, InterruptedException 
	  {
	  test = report.startTest("Ubicaci�n", "Selecciona el pa�s a probar");
	  
	  test.log(LogStatus.INFO, "Espera aparezca el formulario de Ubicaci�n");
	  WaitToClik(Android,XpathUbicacion,10);
	  test.log(LogStatus.INFO,"Hacer click en el combobox que selecciona el pa�s en el que se encuentra");
	  Android.findElement(By.id(idComboPais)).click();
	  test.log(LogStatus.PASS, "Click");
	  time.sleep(1);
	  TakeScreenShot("Country_1");
	  test.log(LogStatus.INFO, "Seleccionar el pa�s");
	  Android.findElement(By.xpath(Country)).click();
	  test.log(LogStatus.PASS, "Pa�s Seleccionado");
	  TakeScreenShot("Country_2");
	  
	  
	  test.log(LogStatus.INFO, "Hacer click en confirmar la informaci�n");
	  Android.findElement(By.xpath(XpathBtnConfirmar)).click();
	  
	  test.log(LogStatus.PASS, "Confirmado.");
	  TakeScreenShot("Country_3");

	 
	  
	  }
}
