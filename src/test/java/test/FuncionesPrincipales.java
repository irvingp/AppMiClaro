package test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNG;
import org.testng.xml.Parser;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import test.FuncionesProperties;

/*
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.claro.resource.crm.FuncionesProperties;
import com.claro.resource.test.Test_credential_entry;
*/
//Libreria para la creacion de reporte pdf
import java.io.FileOutputStream;
import java.io.IOException;

public class FuncionesPrincipales {
	private static final TakesScreenshot TakesScreenshot = null;
	DesiredCapabilities cap = new DesiredCapabilities();
	public static String texto;
	private WebDriver driver;
	private static WebDriver driverMovil;
	public Properties propertiesData;
	public Properties propertiesLocalizador;
	private WebDriverWait wait;
	private Actions action;
	private JavascriptExecutor js;
	private static Thread hilo;
	static int ordenPanama = 14;
	static int ordenCostaRica = 15;

	//AP movil
	int aplicacionLocalizador=23;
	int aplicacionData=24;
	
	//AP movil WhatsApp
	int bootWAPPLocalizador=25;
	int bootWAPPData=26;

//Variable para ir creando las capturas
	protected static int screen = 1;

	public static int validacion;
	public static JTextArea textArea;
	public static int validacionOpcion;
	public static JTextPane textPane;
	public final int prioridad_del_test = 1;
	public static String Nombre_de_reporte;
	public static String[] almacenar_nombre_de_plan;
	public static String[] almacenar_nombre_de_plan1 = new String[9];

	Random ran = new Random();

	//ExtentHtmlReporter reporter = new ExtentHtmlReporter(
		//	System.getProperty("user.dir") + "\\Reporte de tests Ejecutados\\reporte.html");
	static // variable para almacenar archivo pdf
	String ruta;
	private static JFileChooser select = new JFileChooser(System.getProperty("user.dir") + "\\screenshootpdf");

//	static ExtentReports extend = new ExtentReports();

	public static int getValidacionOpcion() {
		return validacionOpcion;
	}

	public static void setValidacionOpcion(int validacionOpcion) {
		FuncionesPrincipales.validacionOpcion = validacionOpcion;
	}

	public int getOrdenPanama() {
		return ordenPanama;
	}

	public void setOrdenPanama(int ordenPanama) {
		this.ordenPanama = ordenPanama;
	}

	public int getOrdenCostaRica() {
		return ordenCostaRica;
	}

	public void setOrdenCostaRica(int ordenCostaRica) {
		this.ordenCostaRica = ordenCostaRica;
	}

	public static JTextPane getTextPane() {
		return textPane;
	}

	public static void setTextPane(JTextPane textPane) {
		FuncionesPrincipales.textPane = textPane;
	}

	public static JTextArea getTextArea() {
		return textArea;
	}

	public static void setTextArea(JTextArea textAreaa) {
		FuncionesPrincipales.textArea = textAreaa;
	}

	// variable para el almacenamiento de texto y para despues mandarlo en el
	// AreaText
	public static String getTexto() {
		return texto;
	}

	public static void setTexto(String texto1) {
		texto = texto1;

	}

	public static Thread getHilo() {
		return hilo;
	}

	public static void setHilo(Thread hilo) {
		FuncionesPrincipales.hilo = hilo;
	}

	public static int getValidacion() {
		return validacion;
	}

	public static void setValidacion(int validacion) {
		FuncionesPrincipales.validacion = validacion;
	}

	public static String nombreTest;
	static String[] parts; // variable para almacenar las cadenas desintegradas

	public static String dato;
	public static String inicio, fin;// estos son variables desde donde se leen los datos a modificar y desde donde
										// termina
	public static int pais;

	public static int getPais() {
		return pais;
	}

	public static void setPais(int pais) {
		FuncionesPrincipales.pais = pais;
	}

	public static String getDato() {
		return dato;
	}

	public static void setDato(String dato) {
		FuncionesPrincipales.dato = dato;
	}

	
	
	public int getBootWAPPLocalizador() {
		return bootWAPPLocalizador;
	}

	public void setBootWAPPLocalizador(int bootWAPPLocalizador) {
		this.bootWAPPLocalizador = bootWAPPLocalizador;
	}

	public int getBootWAPPData() {
		return bootWAPPData;
	}

	public void setBootWAPPData(int bootWAPPData) {
		this.bootWAPPData = bootWAPPData;
	}

	public int getAplicacionLocalizador() {
		return aplicacionLocalizador;
	}

	public void setAplicacionLocalizador(int aplicacionLocalizador) {
		this.aplicacionLocalizador = aplicacionLocalizador;
	}

	public int getAplicacionData() {
		return aplicacionData;
	}

	public void setAplicacionData(int aplicacionData) {
		this.aplicacionData = aplicacionData;
	}

	// contador para llevar el numero de las pruebas
	static boolean activacionDePruebas = true;

	public static boolean isAcrivacionDePruebas() {
		return activacionDePruebas;
	}

	public static void setAcrivacionDePruebas(boolean acrivacionDePruebas) {
		FuncionesPrincipales.activacionDePruebas = acrivacionDePruebas;
	}

	// variable en donde se ejecuta el nombre del test a Ejecutar
	public static String getNombreTest() {
		return nombreTest;
	}

	public static void setNombreTest(String nombreTest) {
		FuncionesPrincipales.nombreTest = nombreTest;
	}

	// variable que permance durante la ejecucion
	private static String Iteraccion;

	public static String getIteraccion() {
		return Iteraccion;
	}

	public static void setIteraccion(String iteraccion) {
		Iteraccion = iteraccion;
	}

	public static String getInicio() {
		return inicio;
	}

	public static void setInicio(String inicio) {
		FuncionesPrincipales.inicio = inicio;
	}

	public static String getFin() {
		return fin;
	}

	public static void setFin(String fin) {
		FuncionesPrincipales.fin = fin;
	}

	private FuncionesProperties properties = new FuncionesProperties();

	public FuncionesPrincipales(AppiumDriver driverMovil) {
		//this.driver = driver;
		this.driverMovil = driverMovil;
	}


	

	public FuncionesPrincipales(WebDriver driver, Properties propertiesData, Properties propertiesLocalizador) {
		this.driver = driver;
		this.propertiesData = propertiesData;
		this.propertiesLocalizador = propertiesLocalizador;
	}
/*
	public FuncionesPrincipales(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}*/

	public WebElement findElement(By locator) {
		return driverMovil.findElement(locator);
	}

	public List<WebElement> findElements(By locator) {
		return driverMovil.findElements(locator);
	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public String getText(By locator) {
		return driverMovil.findElement(locator).getText();
	}

	public String getTextInput(By locator) {
		return driverMovil.findElement(locator).getAttribute("value");
	}

	public void sendKeys(String inputText, By locator) {
		try {
			driverMovil.findElement(locator).sendKeys(inputText);
		//driverMovil.findElementByAccessibilityId("SomeAccessibilityID");
	//	element.sendKeys("Hello world!");


		} catch (Exception e) {
         System.out.println("Input No encontrado");
		}
	}
	
	public void sendKeysAccess(String inputText, String SomeAccessibilityID) {
		//driverMovil.findElementByAccessibilityId(SomeAccessibilityID).sendKeys(inputText);
		//element.sendKeys("Hello world!");

	}
	
	public void sendValue(String inputText, By locator) {
		//driverMovil.findElementByAccessibilityId("SomeAccessibilityID");
		//driverMovil.findElement(locator).setValue(inputText);
	}

	public void sendKeys1(String inputText, By locator) throws InterruptedException {
		try {
			driver.findElement(locator).sendKeys(inputText);

		} catch (Exception e) {
			sendKeys1(inputText, locator);
			Thread.sleep(100);
		}
	}

	public void sendKeysEnter(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText, Keys.ENTER);
	}

	public void click(By locator) {
		driver.findElement(locator).click();
		/*try {
			takeScreen(screen);
			screen++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	public void clickRefreshNoInteractuable(String text, int pais) {
		try {
			driver.findElement(ByXpathFull(text, pais)).click();

		} catch (Exception e) {
		}
	}

	public void clickSubmit(By locator) {
		driver.findElement(locator).submit();
		;

		try {
			takeScreen(screen);
			screen++;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void click(WebElement element) {
		element.click();
		/*try {
			takeScreen(screen);
			screen++;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	public void dobleClick(By locator) {
		action = new Actions(driver);
		action.doubleClick(driver.findElement(locator)).perform();
		try {
			takeScreen(screen);
			screen++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public String visit(String url) {
		driver.get(url);
		return "";
	}

	public void waitPresenceOfElementLocated(int seconds, By element) throws InterruptedException {
		wait = new WebDriverWait(driverMovil, seconds);
		wait.until(presenceOfElementLocated(element));
		//driverMovil.wait();
		//return (WebDriverWait) wait.until(presenceOfElementLocated(element));
	}

	public void waitPresenceOfElementLocatedClick(int seconds, By element) {
		wait = new WebDriverWait(driver, seconds);
		wait.until(presenceOfElementLocated(element)).click();
		// return (wait);

		try {
			takeScreen(screen);
			screen++;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Actions moveToElement(By localizador) {
		action.moveToElement(driver.findElement(localizador)).click().perform();
		return action;
	}

	public Actions moveToElementContextClick(By localizador) {
		action.moveToElement(driver.findElement(localizador)).contextClick();
		return action;
	}

	public Actions contextClick(By localizador) {
		action.contextClick(driver.findElement(localizador)).perform();
		return action;
	}

	public void sendKeysTab(String inputText, By locator, Keys k) {
		driver.findElement(locator).sendKeys(inputText, k);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void clearKeys(By locator) {
		driver.findElement(locator).clear();
		;
	}

	public By ByXpath(String localizador) {
		return By.xpath(localizador);
	}

	public String concatXpath(String text1, String text2, String dato) {
		String texto = text1 + dato + text2;
		return texto;
	}

	// se le manda los datos para concatenar el xpath y crearla
	public By ByXpathConcat(String text1, String dato, String text2, int properti) {
		String texto = properties.leerProperties(text1, properti) + dato + properties.leerProperties(text2, properti);
		return By.xpath(texto);
	}

	// se le manda los datos para concatenar el xpath y crearla, la primera parte se
	// puede mandar en texo
	public By ByXpathConcat2(String text1, String dato, String text2, int properti) {
		String texto = text1 + dato + properties.leerProperties(text2, properti);
		return By.xpath(texto);
	}

	// se le manda los datos para concatenar el xpath y crearla
	public By ByXpathFull(String text1, int properti) {
		String texto = properties.leerProperties(text1, properti);
		return By.xpath(texto);
	}

	public By ByLinkText(String localizador) {
		return By.linkText(localizador);
	}

	public void ByLinkList(String localizador, int i) {
		List<WebElement> list = driver.findElements(By.linkText(localizador));
		list.get(i).click();
	}

	// Calcular tamaño de lista
	public int LengList(String localizador) {
		List<WebElement> list = driver.findElements(By.xpath(localizador));
		return list.size();
	}

	public boolean emptyList(String localizador) {
		List<WebElement> list = driver.findElements(By.xpath(localizador));
		if (list == null || list.size() == 0) {
			return true;

		} else {
			return false;
		}
	}

	public String cambioCaracter(String cadena, int i) {
		char[] aCaracteres = cadena.toCharArray();
		int tamanio = ultimoCaracterString(cadena);
		aCaracteres[tamanio] = (char) i;
		System.out.println(String.valueOf(aCaracteres));
		return String.valueOf(aCaracteres);
	}

	public int ultimoCaracterString(String texto) {
		return texto.length() - 1;
	}

	public void ByPartialLinkText(String localizador) {
		driver.findElement(By.partialLinkText(localizador)).click();
	}

	public void ByPartialLinkText(String localizador, int i) {
		List<WebElement> list = driver.findElements(By.partialLinkText(localizador));
		// driver.findElement(By.partialLinkText(localizador)).click();
		System.out.print(list.get(i));
		list.get(i).click();
	}

	// agregado
	public By ByName(String localizador) {
		return By.name(localizador);
	}

	public By ClassName(String localizador) {
		return By.className(localizador);
	}

	public void clickDerecho(By localizador) {
		WebElement element = driver.findElement(localizador);

		Actions oAction = new Actions(driver);
		oAction.moveToElement(element);
		oAction.contextClick(element).build().perform(); /* this will perform right click */
		try {
			takeScreen(screen);
			screen++;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Validacion Si existe contenido de dato
	public void VerificacionDato(String SendData, By localizador) {
		if (!SendData.equals("")) {
			ClearAndSetText(SendData, localizador);
		}

	}

	public void setAttribute(String expath, String Simcard) {

		/*
		 * 1 WebElement element=driver.findElement(locator); js = (JavascriptExecutor)
		 * driver;
		 * 
		 * String scriptSetAttrValue =
		 * "arguments[0].setAttribute(arguments[1],arguments[2])";
		 * 
		 * js.executeScript(scriptSetAttrValue, element, "value", attValue); 2
		 * JavascriptExecutor js = (JavascriptExecutor) driver; js.executeScript(
		 * "document.evaluate('" + locator +
		 * "', document, null, 9, null).singleNodeValue.innerHTML="
		 * 
		 * JavascriptExecutor jse = (JavascriptExecutor) driver; jse.
		 * executeScript("document.getElementsByName('body')[0].setAttribute('type', 'text');"
		 * ); driver.findElement(By.
		 * xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-5 x-unselectable'])[6]\")"
		 * )).clear(); driver.findElement(By.
		 * xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-5 x-unselectable'])[6]\")"
		 * )) .sendKeys("Hola"); + attValue);
		 */
		WebElement element = driver

//				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-5 x-unselectable'])[6]"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML='89507030809000447983';", element);

				.findElement(By.xpath(expath));
		((JavascriptExecutor) driver).executeScript("arguments[0].innerText = " + Simcard + "", element);

	}

	public void ClearAndSetText(String text, By locator) {
		WebElement element = driver.findElement(locator);

		Actions navigator = new Actions(driver);
		navigator.click(element).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT)
				.sendKeys(Keys.BACK_SPACE).sendKeys(text).sendKeys(Keys.ENTER).perform();

	}

	public void ClearText(By locator) {
		WebElement element = driver.findElement(locator);

		Actions navigator = new Actions(driver);
		navigator.click(element).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT)
				.sendKeys(Keys.BACK_SPACE).sendKeys("").perform();

	}

	public void sendKeysResource(By input, String Text) {
		ClearText(input);
		ClearAndSetText(Text, input);

	}

	public boolean exist(String element) {
		boolean condicion;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		try {
			condicion = driver.findElements(By.xpath(element)).size() != 0;
		} catch (NoSuchElementException e) {
			condicion = false;
		}
		return condicion;
	}

	public boolean existWhitParameter(String element, int a) throws InterruptedException {
		boolean condicion;
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.MILLISECONDS);
		Thread.sleep(0);
		try {
			condicion = driver.findElements(By.xpath(element)).size() != 0;

		} catch (NoSuchElementException e) {
			condicion = false;
		}
		return condicion;

	}

	public boolean existWhitParameterMili(String element, int a) throws InterruptedException {
		boolean condicion;
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.MILLISECONDS);
		Thread.sleep(0);
		try {
			condicion = driver.findElements(By.xpath(element)).size() != 0;

		} catch (NoSuchElementException e) {
			condicion = false;
		}
		return condicion;

	}

	public boolean existTime(String element, int a) throws InterruptedException {
		boolean condicion;
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.MILLISECONDS);
		Thread.sleep(0);
		try {
			condicion = driver.findElements(By.xpath(element)).size() != 0;

		} catch (NoSuchElementException e) {
			condicion = false;
		}
		return condicion;

	}

	public boolean existTime(By element, int a) throws InterruptedException {
		boolean condicion;
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.MILLISECONDS);
		//Thread.sleep(0);
		try {
			condicion = driver.findElements(element).size() != 0;

		} catch (NoSuchElementException e) {
			condicion = false;
		}
		return condicion;

	}

	public boolean existValidacion(String element, int a) throws InterruptedException {
		boolean condicion;
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.MILLISECONDS);
		Thread.sleep(0);
		try {
			condicion = driver.findElements(By.xpath(element)).size() != 0;

		} catch (NoSuchElementException e) {
			condicion = false;
		}
		return condicion;

	}

	// funcion para detectar si se esta procesando en alguna ventana, si es asi
	// entonces se queda en el bucle sino sale
	public void procesando(String entrada) throws InterruptedException {
		do {
			Thread.sleep(500);
			System.out.print("\n Procesando \n");
			Thread.sleep(500);
		} while (exist(properties.leerProperties(entrada, 1)) == true);

	}

	public void procesando2(String entrada, int localizador) throws InterruptedException {
		do {
			Thread.sleep(100);
			System.out.print("\n Procesando \n");
			Thread.sleep(100);
		} while (existTime(leerProperties(entrada, localizador), 1) == true);

	}

	public void procesando2(String entrada, int localizador, int time) throws InterruptedException {
		do {
			Thread.sleep(100);
			System.out.print("\n Procesando \n");
			Thread.sleep(100);
		} while (existTime(ByXpathFull(entrada, localizador), time) == true);

	}

	public void procesando(String entrada, int i) throws InterruptedException {
		do {
			Thread.sleep(i);
			System.out.print("\n Procesando \n");
			Thread.sleep(i);
		} while (existWhitParameterMili(properties.leerProperties(entrada, 1), 1) == true);

	}

	public void validacion(String xpath1, String dato, String xpath2, int pais) throws InterruptedException {
		do {
			Thread.sleep(500);
			System.out.print("\n esperando a la siguente ventana \n");
			Thread.sleep(500);
		} while (exist(leerProperties(xpath1, pais) + dato + leerProperties(xpath2, pais)) == true);

	}

	public void validacion(String entrada, int pais) throws InterruptedException {
		do {
			Thread.sleep(500);
			System.out.print("\n esperando a la siguente ventana \n");
			Thread.sleep(500);
		} while (exist(leerProperties(entrada, pais)) == true);

	}

	// cambiar ventana
	public void NuevaPestaña(String link) {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(link);
	}

	public void cambioPestaña(int ventana) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(ventana)); // switch back to main screen

	}

	public void Refrescar() {
		driver.navigate().refresh();
	}

	// funcion para sumar dias de una fecha
	public String sumarDiasFecha(String fecha, int dias) throws ParseException {
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
		Calendar date = Calendar.getInstance();
		date.setTime(formatoDeFecha.parse(fecha)); // Configuramos la fecha que se recibe
		date.add(Calendar.DAY_OF_YEAR, 2);
		String mesTemp, diaTemp;
		int año = date.get(Calendar.YEAR);
		int mes = date.get(Calendar.MONTH) + 1;
		int dia = date.get(Calendar.DAY_OF_MONTH);
		if (mes > 0 && mes < 10) {
			System.out.print("Entre ");
			mesTemp = "0" + Integer.toString(mes);
		} else {
			mesTemp = Integer.toString(mes);
		}
		if (dia > 0 && dia < 10) {
			System.out.print("Entre ");

			diaTemp = "0" + Integer.toString(dia);
		} else {
			diaTemp = Integer.toString(dia);

		}
		return diaTemp + "/" + mesTemp + "/" + año;

	}

	public String botonEntradaText(String textDePregunta, String tituloJInput) {
		JFrame frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setVisible(false);
		String variable = JOptionPane.showInputDialog(frame, textDePregunta, tituloJInput, JOptionPane.ERROR_MESSAGE);
		// si le dan cancelar al boton no entra en el if y retorna un cadena vacia
		if ((variable != null) && (variable.length() > 0)) {
			return variable;
		} else {
			return "";
		}

	}

	public String leerProperties(String propertie, int localizador) {
		FuncionesProperties propierties = new FuncionesProperties();
		return properties.leerProperties(propertie, localizador);
	}

	public void Testsuit(String test) throws IOException {
		String cuerpo = "<!DOCTYPE suite SYSTEM \"https://testng.org/testng-1.0.dtd\" >\r\n"
				+ "<suite name=\"Test-Suite\" >\r\n" + "   <test name=\"ToolsQA\" >\r\n" + "       <classes> \r\n"
				+ "          <class name=\"" + test + "\" />\r\n" + "       </classes>\r\n" + "   </test>\r\n"
				+ " </suite>";

		TestNG tng = new TestNG();
		ByteArrayInputStream is = new ByteArrayInputStream(cuerpo.getBytes());
		tng.setXmlSuites(new Parser(is).parseToList());
		tng.run();
	}

	public void CerrarNavegador() {

		driver.close();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

	public void recursos(String inicio, String fin, String dato, String nombreTest, int pais) {
		this.inicio = inicio;
		this.fin = fin;
		this.dato = dato;
		this.nombreTest = nombreTest;
		this.pais = pais;
		// aca se manda el nombre del test a ejecutar
	}

//funcion para desintegrar texto
	public static String[] SeparaTexto(String texto) {
		parts = texto.split(",");
		return parts;
	}

	// funcion para desintegrar texto
	public static String[] corte(String texto) {
		parts = texto.split("/");
		return parts;
	}

	public void seleccionDeOpcion(String[] entrada, String xpathP1, String xpathP2, int paisLoc)
			throws InterruptedException {
		for (int i = 0; i <= entrada.length - 1; i++) {
			Thread.sleep(100);
			if (!entrada[i].equals("")) {
				click(ByXpathConcat(xpathP1, entrada[i], xpathP2, paisLoc));

			}
		}
		// click(ByXpathConcat(xpathP1,entrada[i],xpathP2,paisLoc));
		// clickConcatNotInteractable(xpathP1,entrada[i], xpathP2, paisLoc);

	}

	public void seleccionDeOpcion2(String[] entrada, String xpathP1, String xpathP2, int paisLoc)
			throws InterruptedException {
		for (int i = 0; i <= entrada.length - 1; i++) {
			Thread.sleep(500);
			if (!entrada[i].equals("")) {
				click(ByXpathConcat2(xpathP1, entrada[i], xpathP2, paisLoc));
			}
		}
	}

	public String stringArray(String[] entrada, int i) throws InterruptedException {
		return entrada[i];
	}

	public By xpathSelect(String locator, String xpathP1, String xpathP2, int paisLoc) {

		return ByXpathConcat(xpathP1, locator, xpathP2, paisLoc);
	}

//	public void /*String*/ selectDropdownList(String dropdown,String name) {
//		Select fruits = new Select (driver.findElement(By.xpath(dropdown)));	 
//		fruits.selectByVisibleText(name);
//	}

	public void /* String */ selectDropdownList(String dropdown, String name) throws InterruptedException {
		try {
			Select fruits = new Select(driver.findElement(By.xpath(dropdown)));
			fruits.selectByVisibleText(name);
		} catch (Exception e) {
			selectDropdownList(dropdown, name);
			Thread.sleep(100);
		}
	}

	public void /* String */ selectDropdownList1(String dropdown, String name) throws InterruptedException {

		Select fruits = new Select(driver.findElement(By.xpath(dropdown)));
		fruits.selectByVisibleText(name);

	}

	public void clickJS(String locator) {
		WebElement element = findElement(By.xpath(locator));
		// JavascriptExecutor javaScriptExecutor = (JavascriptExecutor)driver;

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		// element.sendKeys("");
		// element.click();
		((JavascriptExecutor) this.driver).executeScript("return arguments[0].click();", element);
	}

	public void clickJS1(String locator) throws InterruptedException {
		WebElement element = findElement(By.xpath(locator));
		try {

			((JavascriptExecutor) this.driver).executeScript("return arguments[0].click();", element);

		} catch (Exception e) {
			clickJS1(locator);
			Thread.sleep(100);
		}
	}

	public void clickJSConcat(String texto1, String data, String texto2, int localizador) {

		String auxiliar = leerProperties(texto1, localizador) + data + leerProperties(texto2, localizador);
		WebElement element = findElement(By.xpath(auxiliar));

		((JavascriptExecutor) this.driver).executeScript("return arguments[0].click();", element);
	}

	public void clickJSConcat1(String texto1, String data, String texto2, int localizador) throws InterruptedException {
		try {
			String auxiliar = leerProperties(texto1, localizador) + data + leerProperties(texto2, localizador);
			WebElement element = findElement(By.xpath(auxiliar));

			((JavascriptExecutor) this.driver).executeScript("return arguments[0].click();", element);
		} catch (Exception e) {
			clickJSConcat1(texto1, data, texto2, localizador);
			Thread.sleep(100);
		}
	}

	public void clickJS(By locator) {
		WebElement element = findElement(locator);
		((JavascriptExecutor) this.driver).executeScript("return arguments[0].click();", element);
	}

	public void clickJS(WebElement element) {
		((JavascriptExecutor) this.driver).executeScript("return arguments[0].click();", element);
	}

	public WebElement findElementCSS(String texto, int properti) {
		String css = properties.leerProperties(texto, properti);
		return driver.findElement(By.cssSelector(css));
	}

	public void Ingresar_a_Iframe(String frame) throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.xpath(frame)));
	}

	public void regresar_a_Marco_Principal() {
		driver.switchTo().defaultContent();
	}

	public void quit() {
		driver.quit();
	}

	// funcion que almacena el hilo
	public void Detener(Thread hilo) {
		this.hilo = hilo;
	}

	// Metodo para la creacion de reporte
/*	public void pruevas_exitosas() {
		setAcrivacionDePruebas(true);
		extend.attachReporter(reporter);
		ExtentTest logger = extend
				.createTest(getClass().getName().substring(getClass().getName().lastIndexOf('.') + 1));
		logger.log(Status.INFO, getClass().getName());
		logger.log(Status.PASS, "Passed");
		extend.flush();
	}*/

	// Tomar screenshoot
	public void takeScreen() throws IOException {

		String file = System.getProperty("user.dir") + "\\Reporte de tests Ejecutados\\captura.jpg";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(file));

	}

	// Tomar screenshoot
	public void takeScreen(int numeroDeCaptura) throws IOException {
		String file = System.getProperty("user.dir") + "\\screenshootpdf\\Capturas\\captura" + numeroDeCaptura + ".jpg";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(file));

	}

	// Funcion que se llama en el try Catch
	/*public void excepcion(String exception) {

		// Creacion del reporte
		try {
			takeScreen();
			takeScreen(screen);
			screen++;
			FuncionesPrincipales.createPdf("documento.pdf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extend.attachReporter(reporter);
		ExtentTest logger = extend
				.createTest("ERROR! " + getClass().getName().substring(getClass().getName().lastIndexOf('.') + 1));
		logger.log(Status.INFO, getClass().getName());
		logger.log(Status.FAIL, exception);

		try {
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "\\Reporte de tests Ejecutados\\captura.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extend.flush();
		setTexto(exception);
		setAcrivacionDePruebas(false);
		System.out.println("\n" + exception + "\n");
		killCromDriver();
		getHilo().stop();

	}*/

	// Funcion para mandar error en JTextField en la interface
	public void log(JTextArea display) {

		display.setText(getTexto());

	}

	public void entro_en_otra_ventana(String xpath1, int pais) throws InterruptedException {
		while (existWhitParameter(leerProperties(xpath1, pais), 1)) {
			System.out.print("\nEsperando Opcion de refrescar\n");
			Thread.sleep(1000);

		}
	}

	public void entro_en_otra_ventana(String xpath1, String xpath2, int pais) throws InterruptedException {
		while (existWhitParameter(leerProperties(xpath1, pais), 1)
				|| existWhitParameter(leerProperties(xpath2, pais), 1)) {
			System.out.print("\nEsperando Opcion de refrescar\n");
			Thread.sleep(1000);

		}
	}

	public void clickNotInteractable(String element, int propertie) {
		try {
			click(ByXpathFull(element, propertie));
			validacion = 1;

			takeScreen(screen);
			screen++;

		} catch (Exception e) {
			System.out.println("Elemento No Interactuable: " + leerProperties(element, propertie));
			validacion = 0;

		}
	}

	public void clickNotInteractable(By element) {
		try {
			click(element);
			validacion = 1;

			takeScreen(screen);
			screen++;

		} catch (Exception e) {
			System.out.println("Elemento No Interactuable: ");
			validacion = 0;

		}
	}

	public void clickNotInteractableWait(String xpath1, String dato, String xpath2, int pais, int tiempo) {

		try {

			waitPresenceOfElementLocatedClick(tiempo, ByXpathConcat(xpath1, dato, xpath2, pais));
			takeScreen(screen);
			screen++;

		} catch (Exception e) {
			System.out.println(
					"Elemento No Interactuable: " + ByXpathConcat(xpath1, dato, xpath2, pais) + "\n" + e.getMessage());
		}

	}

	public void clickConcatNotInteractable(String text1, String dato, String text2, int properti) {
		try {
			click(ByXpathConcat(text1, dato, text2, properti));

			takeScreen(screen);
			screen++;

		} catch (Exception e) {
			System.out.println("Elemento No Interactuable: " + ByXpathConcat(text1, dato, text2, properti));
		}
	}

	public void sendKeysNotInteractable(String inputText, By locator) {
		try {
			sendKeys(inputText, locator);
		} catch (Exception e) {
			System.out.println("Elemento No Interactuable: " + locator);
		}
	}

	public int LengArrayList(String[] localizador) {
		return localizador.length;
	}

	public boolean textoVacio(String texto) {
		if (texto.equals("")) {
			return true;
		}
		return false;
	}

	public String[] plan(String servicio, int data) {
		String[] plans;
		if (!leerProperties(servicio, data).equals("") || !leerProperties(servicio, data).isEmpty()) {
			return plans = SeparaTexto(leerProperties(servicio, data));
		} else {
			return plans = null;
		}
	}
/*
	public String[] plan2(String servicio, int data) {
		String[] plans;
		if (!leerProperties(servicio, data).equals("") || !leerProperties(servicio, getDataNicaragua()).isEmpty()) {
			return plans = SeparaTexto(leerProperties(servicio, data));
		} else {
			return plans = null;
		}
	}

	
	public String[] plan3(String servicio, int data) {
		String[] select;
		if (!leerProperties(servicio, data).equals("") || !leerProperties(servicio, getDataNicaragua()).isEmpty()) {
			return select = SeparaTexto(leerProperties(servicio, data));
		} else {
			return select = null;
		}
	}
*/
	public void killCromDriver() {
		try {
			System.out.print(leerProperties("webDriver", 5).substring(34, 52));

			Runtime.getRuntime().exec("taskkill /F /IM " + leerProperties("webDriver", 5).substring(34, 52));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * public void clickExplore(String texto, int properti) { String css=
	 * properties.leerProperties(texto, properti); //lee el xpath
	 * driver.findElement(By.cssSelector(css)).click(); //le da click para el
	 * elemento seleccionado //For para definir la cantidad de veces que tiene se
	 * tiene que bajar para seleccionar el elemento }
	 */
	public void clickExplorer1(String texto, int properti) throws InterruptedException {

		try {
			String css = properties.leerProperties(texto, properti); // lee el xpath
			driver.findElement(By.cssSelector(css)).click(); // le da click para el elemento seleccionado
		} catch (Exception e) {
			clickExplorer1(texto, properti);
			Thread.sleep(100);
		}
	}

	// Termina clickGuate
	public void downOpciones(String texto, int properti, int down) throws InterruptedException {
		try {
			String css = properties.leerProperties(texto, properti); // lee el xpath
			while (down != 0) {
				driver.findElement(By.cssSelector(css)).sendKeys(Keys.DOWN);
				down--;
			}
			driver.findElement(By.cssSelector(css)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			downOpciones(texto, properti, down);
			Thread.sleep(100);

		}
		// ALTERNATIVA driver.findElement(By.cssSelector(css)).sendKeys(Keys.TAB);
	}

	// Termina clickGuate
	public void downOpciones2(String texto, int properti, int down) throws InterruptedException {
		try {

			String css = properties.leerProperties(texto, properti); // lee el xpath
			// while(down!=0)
			for (int i = 1; i <= down; i++) {
				driver.findElement(By.cssSelector(css)).sendKeys(Keys.DOWN);
				// down--;
			}
			driver.findElement(By.cssSelector(css)).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			downOpciones(texto, properti, down);
			Thread.sleep(100);

		}
		// ALTERNATIVA driver.findElement(By.cssSelector(css)).sendKeys(Keys.TAB);
	}

	public void scrollPageDown(int pixeles) {
		((JavascriptExecutor) driver).executeScript("scroll(0," + pixeles + ")");
	}

	public void clickVinculo(String texto, int properti) throws InterruptedException {
		try {
			String informacion = properties.leerProperties(texto, properti);
			driver.findElement(By.xpath(informacion)).click();
		} catch (Exception e) {
			clickVinculo(texto, properti);
			Thread.sleep(100);
		}
	}

//validar si un elemento es visible
	public boolean isElementPresent(String xpath) {
		return driver.findElement(By.xpath(xpath)).isDisplayed();
	}

	// Abrir pagina web
/*	public void abrirHTML(String ruta) {
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		File f = new File(ruta);
		URI uri = f.toURI();
		OpenPageWeb.openWebpage(uri);
	}// Validacion de link
*/
	/*public void linkText(String exist_expath, String link, int pais) throws InterruptedException {
		for (int i = 1; i <= LengList(leerProperties(link, getLocalizadorPanama())); i++) {
			click(ByXpath(leerProperties(link, pais) + "[" + i + "]"));
			procesando("procesando", 10);
			if (existWhitParameter(leerProperties(exist_expath, getLocalizadorPanama()), 1)) {
				break;
			}
		}

	}*/

	public void cambioPagina() {

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1)); // Tab number

		// Can change it for next tab like that or previous:

		driver.switchTo().window(tabs2.get(0));
		// driver.close();
		driver.switchTo().window(tabs2.get(1));
	}

	public void downTeclado(String text, By locator) {
		WebElement element = driver.findElement(locator);

		Actions navigator = new Actions(driver);
		navigator.click(element).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT)
				.sendKeys(Keys.BACK_SPACE).sendKeys(text).sendKeys(Keys.ENTER).perform();

	}

//metodo para crear archivo pdf-------------------------------------------------------------------------------------------------------------
/*	public static void createPdf(String filename) throws IOException, DocumentException {
		// CONTAR LOS ELEMENTOS DE LA CARPTETA
		File carpeta = new File(System.getProperty("user.dir") + "\\screenshootpdf\\Capturas");
		File[] lista = carpeta.listFiles();

		System.out.println("\n Hay " + lista.length + " elementos");

		Document document = new Document(PageSize.LETTER, 36, 36, 54, 36);
		Paragraph parrafo, parrafo1 = null;
//Se Abre la interfaz para preguntar donde almacenar el archivo pdf
		JFrame frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setVisible(false);

		// Crea un selector de consulta que abre la carpeta de usuario por defecto
		int opcion = select.showSaveDialog(frame);
		if (opcion == JFileChooser.APPROVE_OPTION) {
			ruta = select.getSelectedFile().getAbsolutePath();
			System.out.println(ruta + ".pdf");
			crearPDF(document, parrafo1, lista);
			eliminar_screenshot(lista);
			screen = 1;
		} else {
			int seleccion = JOptionPane.showConfirmDialog(null,
					"Presiona 'No' para salir/ 'Sí' para reintentar guardar", "Confirmación",
					JOptionPane.YES_NO_OPTION);

			System.out.println("Selecció" + seleccion);
			if (seleccion == 0) {
				int opcion1 = select.showSaveDialog(frame);
				if (opcion1 == JFileChooser.APPROVE_OPTION) {
					ruta = select.getSelectedFile().getAbsolutePath();
					crearPDF(document, parrafo1, lista);
					eliminar_screenshot(lista);
					screen = 1;
					System.out.println(ruta + ".pdf");
				} else {
					eliminar_screenshot(lista);

				}
			} else {
				eliminar_screenshot(lista);
				screen = 1;

			}
		}

		System.out.println("Eliminacion");

	}
*/
	/*
	// Construccion de pdf
	public static void crearPDF(Document document, Paragraph parrafo1, File[] lista) {
		try {

			screen = 1;
			// linea de codigo para almacenar pdf
			if (!ruta.equals("")) {
				PdfWriter.getInstance(document, new FileOutputStream(ruta + ".pdf"));
			} else {
				PdfWriter.getInstance(document, new FileOutputStream("EmptiFile.pdf"));
			}
			document.open();

			// Creamos una cantidad significativa de paginas para probar el encabezado

			// crear variable para crear pagina
			int pag = 0;
			System.out.println("Creacion de pdf");

			for (int i = 1; i <= lista.length; i++) {
				if (i == 1) {
					parrafo1 = new Paragraph(Nombre_de_reporte);
				} else {
					parrafo1 = new Paragraph(i + ").");

				}
				Image imagen = Image.getInstance(
						System.getProperty("user.dir") + "\\screenshootpdf\\Capturas\\captura" + i + ".jpg");
				imagen.setAlignment(Element.ALIGN_CENTER);
				imagen.scaleAbsolute(580, 325);
				document.add(parrafo1);
				document.add(imagen);

			}

			document.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
*/
	public static void eliminar_screenshot(File[] lista) {

		// eliminacion de las capturas creadas en la ruta System.getProperty("user.dir")
		// + "\\reportes\\PDF\\Capturas\\captura" + i + ".jpg"
		try {

			for (int i = 1; i <= lista.length; i++) {
				File archivo = new File(
						System.getProperty("user.dir") + "\\screenshootpdf\\Capturas\\captura" + i + ".jpg");
				boolean estatus = archivo.delete();

			}
		} catch (

		Exception e) {

			System.out.println(e);

		}
	}

//-------------------------------------------------------------------------------------------------------------
	public String getTextXpath(String xpath, int localizador) {
		return getText(ByXpathFull(xpath, localizador));
	}

	public void ClearAndSetTextNotInterac(String text, By locator) {
		try {
			WebElement element = driver.findElement(locator);

			Actions navigator = new Actions(driver);
			navigator.click(element).sendKeys(Keys.END).keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT)
					.sendKeys(Keys.BACK_SPACE).sendKeys(text).sendKeys(Keys.ENTER).perform();

		} catch (Exception e) {
			System.out.println("Elemento No Interactuable: " + locator);
		}
	}
/*
	// public void imagen
	public void ventana_de_alerta(String informacion, String button) {
		ventana_emergente v = new ventana_emergente(informacion, button);
		v.main();
	}
*/
	
	public void MobileElement(String localizador, int i) {
		//List<MobileElement> list =(MobileElement) driver.findElements(By.linkText(localizador));
		//list.get(i).click();
		List<MobileElement> list = (List<MobileElement>)driverMovil.findElements(By.className(localizador));
		list.get(i).click();
	}
	
	public void clickMobile(String xpath) {
		//MobileElement element = driverMovil.findElementByXPath(xpath);
		WebElement element = driverMovil.findElement(By.xpath(xpath));
		element.click();
	}
	
	public void moveToAbajo(int x,int y) {
		
		TouchAction touch = new TouchAction(driverMovil);
		touch.press(PointOption.point(x,y))
			//.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
			.moveTo(PointOption.point(x,y-500)).release().perform();
		
		/*(new TouchAction(driver))
		  .press({x: 578, y: 575})
		  .moveTo({x: 581: y: 411})
		  .release()
		  .perform()*/
		  
	}
	
	public void touch(int x,int y) {
		TouchAction touch = new TouchAction(driverMovil);
		touch.tap(PointOption.point(x, y)).perform();
	}
	
	public void keysDown(int down) throws InterruptedException {
		Actions ingresarTexto = new Actions(driverMovil);
		while (down != 0) {
			Thread.sleep(501);
			ingresarTexto.sendKeys(Keys.DOWN).perform();
			down--;
		}
		ingresarTexto.sendKeys(Keys.ENTER).perform();
	}
	
	public int altoPantalla() {
		return driverMovil.manage().window().getSize().getHeight() ;
	}
	
	public int anchoPantalla() {
		return driverMovil.manage().window().getSize().getWidth() ;
	}
	
	public void AppiumDriver(String ur) throws MalformedURLException {
		URL url = new URL(ur);
		driverMovil = new AppiumDriver<MobileElement>(url, cap);
	}
	
	public void setCapabilities(DesiredCapabilities cap) {
		this.cap=cap;
	}
	
	public void capacitibilityPhone(String deviceName, String udid,String platormName,String platformVesion) {
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("udid", udid);
		cap.setCapability("platformName", platormName);
		cap.setCapability("platformVersion", platformVesion);
	}
	
	public void capacitibilityApp(String appPackage, String appActivity) {
		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity", appActivity);
	}
	
	public static void clickCoordenada(double x, double y)
	{
		Dimension dimension = driverMovil.manage().window().getSize();
		TouchAction touch = new TouchAction(driverMovil);
		Actions ingresarTexto = new Actions(driverMovil);

		int inicioX = (int)(dimension.width * x);
		int inicioY = (int)(dimension.height * y);
		System.out.println(inicioX + " PARA X");
		System.out.println(inicioY + " PARA Y");
		touch.tap(PointOption.point(inicioX, inicioY)).perform();
		inicioX=0;
		inicioY=0;
	}
	
	public void touchDriver() {
		TouchAction touch;
		touch= new TouchAction(driverMovil);
	}
	
	public void scrollCoordenada(double x_inicio,double y_inicio,double x_fin,double y_fin) {
		Dimension dimension = driverMovil.manage().window().getSize();
		TouchAction touch = new TouchAction(driverMovil);

		int inicioX = (int)(dimension.width * x_inicio);
		int inicioY = (int)(dimension.height * y_inicio);
		
		int finX = (int)(dimension.width * x_fin);
		int finY = (int)(dimension.height * y_fin);
		touch.press(PointOption.point(inicioX,inicioY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(finX,finY)).release().perform();
	}
}
