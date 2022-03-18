package providers;

import org.testng.annotations.DataProvider;

public class LoginProvider {

	
	@DataProvider(name = "DataLogin")
	public Object[][] DataLogin() {
	 return new Object[][] {
	   { "scarmelendez@gmail.com", "Eloyscar4"}
	  
	 };
	}

}
