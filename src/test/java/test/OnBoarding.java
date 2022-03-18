package test;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;


public class OnBoarding extends BaseClass{

	
	@BeforeGroups(groups = "Boarding-1")
	public void beforeTestPoliticas()
	{
		System.out.println("Before test 1");
		//WaitToClik("//android.widget.TextView[@text='Política de uso de Datos']", 10);
	}
	
	@Test(priority = 1 , groups = {"Boarding-1"})
	public void PoliticasAcceso()
	{
		System.out.println("Test 1");
		//driver.findElement(By.xpath("//android.widget.Button[@text='Aceptar']")).click();
		
	}
	
	@AfterGroups(groups = "Boarding-1")
	public void AfterTestPoliticas()
	{
		System.out.println("After Test 1");
		//driver.findElement(By.xpath("//android.widget.Button[@text='PERMITIR']")).click();
	}
	
	
	@BeforeGroups(groups = "Boarding-2")
	public void BeforeUbicacion()
	{
		System.out.println("Before Test 2");
		WaitToClik("//android.widget.TextView[@text='Ubicación']", 5);
		
	}
	@Test(priority = 2, groups = {"Boarding-2"})
	public void Ubicacion()
	{
		System.out.println("Test 2");
		//driver.findElement(By.xpath("//android.widget.Button[@text='Confirmar']")).click();
		
	}
	
	
}
