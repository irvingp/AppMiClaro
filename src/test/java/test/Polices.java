package test;

import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import providers.PolicesProviders;

public class Polices extends BaseClass {

	@BeforeClass(groups = "Onboarding")
	public void Init() {
		test = report.startTest("Politicas de acceso", "Muestra politicas de acceso");
	}

	@Test(priority = 1, groups = "Onboarding", dataProvider = "ExistePoliticadeAccesoProvider", dataProviderClass = PolicesProviders.class)
	public void ExistePoliticadeAcceso(String XpathPoliticasdeUso) throws IOException {
		WebDriverWait wait = new WebDriverWait(Android, 5);
		Assert.assertEquals(
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathPoliticasdeUso))).isDisplayed(),
				true, 
				"Se muestra pantalla de Políticas de Acceso");
		test.log(LogStatus.INFO, "Se muestra correctamente las politicas de acceso");
		TakeScreenShot("OnBording_1");
	}

	@Test(priority = 2, groups = "Onboarding", dataProvider = "PermisoUbicacionTitleProvider", dataProviderClass = PolicesProviders.class)
	public void PermisoUbicacionTitle(String xpathTitle, String Title) throws IOException {

		WebDriverWait wait = new WebDriverWait(Android, 1);
		Assert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathTitle))).isDisplayed(),
				true, "Texto esperado: " + Title);
		TakeScreenShot("OnBording_2");
	}

	@Test(priority = 3, groups = "Onboarding", dataProvider = "PermisoUbicacionDescriptionProvider", dataProviderClass = PolicesProviders.class)
	public void PermisoUbicacionDescription(String xpathUbicacionDescription, String Description) throws IOException {
		WebDriverWait wait = new WebDriverWait(Android, 1);
		Assert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathUbicacionDescription)))
				.isDisplayed(), true, "Texto esperado: " + Description);
		TakeScreenShot("OnBording_3");

	}

	@Test(priority = 4, groups = "Onboarding", dataProvider = "PermisoUsuarioTitleProvider", dataProviderClass = PolicesProviders.class)
	public void PermisoUsuarioTitle(String xpathTitle, String Title) throws IOException {
		WebDriverWait wait = new WebDriverWait(Android, 1);
		Assert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathTitle))).isDisplayed(),
				true, "Texto esperado: " + Title);
		TakeScreenShot("OnBording_4");
	}

	@Test(priority = 5, groups = "Onboarding", dataProvider = "PermisoUsuarioDescriptionProvider", dataProviderClass = PolicesProviders.class)
	public void PermisoUsuarioDescription(String xpathUsuarioDescription, String Description) throws IOException {
		Android.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""
						+ Description + "\"))");
		WebDriverWait wait = new WebDriverWait(Android, 2);
		Assert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathUsuarioDescription)))
				.isDisplayed(), true, "Texto esperado: " + Description);
		TakeScreenShot("OnBording_5");

	}

	@Test(priority = 6, groups = "Onboarding", dataProvider = "PermisoNumTeleTitleProvider", dataProviderClass = PolicesProviders.class)
	public void PermisoNumTeleTitle(String xpathNumTele, String Description, String DescNum) throws IOException {

		Android.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + DescNum
						+ "\"))");
		WebDriverWait wait = new WebDriverWait(Android, 2);
		Assert.assertEquals(
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathNumTele))).isDisplayed(), true,
				"Texto esperado: " + Description);
		TakeScreenShot("OnBording_6");
	}

	@Test(priority = 7, groups = "Onboarding", dataProvider = "PermisoNumTeleDescriptionProvider", dataProviderClass = PolicesProviders.class)
	public void permisoNumTeleDescription(String XpathNumTeleDescriotion, String Description) throws IOException {

		WebDriverWait wait = new WebDriverWait(Android, 2);
		Android.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""
						+ Description + "\"))");
		Assert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathNumTeleDescriotion)))
				.isDisplayed(), true, "Texto esperado: " + Description);
		TakeScreenShot("OnBording_7");
	}

	@Test(priority = 8, groups = "Onboarding", dataProvider = "PermisoSisOpTitleProvider", dataProviderClass = PolicesProviders.class)
	public void permisoSisOpTitle(String XpathSistemaOperativo, String Description) throws IOException {
		WebDriverWait wait = new WebDriverWait(Android, 2);
		Android.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""
						+ Description + "\"))");
		Assert.assertEquals(
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathSistemaOperativo))).isDisplayed(),
				true, "Texto esperado: " + Description);
		TakeScreenShot("OnBording_8");
	}

	@Test(priority = 9, groups = "Onboarding", dataProvider = "PermisoSisOpDescriptionProvider", dataProviderClass = PolicesProviders.class)
	public void permisoSisOpDescription(String XpathSistemaOperativo, String Description) throws IOException {
		WebDriverWait wait = new WebDriverWait(Android, 2);
		Android.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""
						+ Description + "\"))");

		Assert.assertEquals(
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathSistemaOperativo))).isDisplayed(),
				true, "Texto esperado: " + Description);
		TakeScreenShot("OnBording_9");
	}

	@Test(priority = 11, groups = "Onboarding", dataProvider = "PermisoDatosdeUsoTitleProvider", dataProviderClass = PolicesProviders.class)
	public void PermisoDatosdeUsoTitle(String XpathDatosdeUso, String Description) throws IOException {
		WebDriverWait wait = new WebDriverWait(Android, 2);
		Android.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textMatches(\""
						+ Description + "\"))");
		Assert.assertEquals(
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathDatosdeUso))).isDisplayed(), true,
				"Texto esperado: " + Description);
		TakeScreenShot("OnBording_10");
	}

	@Test(priority = 10, groups = "Onboarding", dataProvider = "PermisoDatosdeUsoDescriptionProvider", dataProviderClass = PolicesProviders.class)
	public void PermisoDatosdeUsoDescription(String XpathDatosdeUso, String Description) throws IOException {
		WebDriverWait wait = new WebDriverWait(Android, 2);
		Android.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textMatches(\""
						+ Description + "\"))");
		Assert.assertEquals(
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathDatosdeUso))).isDisplayed(), true,
				"Texto esperado: " + Description);
		TakeScreenShot("OnBording_11");

	}

}
