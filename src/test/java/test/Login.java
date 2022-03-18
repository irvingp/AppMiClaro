package test;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
 *  
 *  HN - pruebasvahn@gmail.com    Claro12345
 *  
 * NI - scarmelendez@gmail.com    Eloyscar4
 */
public class Login extends BaseClass{
	
	@BeforeGroups(groups ="Login-1")
	public void ExistForm()
	{
		System.out.println("Before test 3");
		//WaitToClik("//android.widget.Button[1]", 5);
	}

	@Parameters({"email","password"})
	@Test(priority=3, groups = {"Login-1"})
	public void LoginMiClaro(String Email, String Password)
	{
		System.out.println("Test 3");
		/*
		 * driver.findElementByXPath("//android.widget.Button[1]").click(); driver.
		 * findElementByXPath("//android.widget.EditText[@text='Correo Electrónico']").
		 * sendKeys(Email);
		 * driver.findElementByXPath("//android.widget.EditText[@text='Contraseña']").
		 * sendKeys(Password);
		 * 
		 * driver.findElementByXPath("//android.widget.Button[@text='Ingresar']").click(
		 * );
		 */
		
	}
}
