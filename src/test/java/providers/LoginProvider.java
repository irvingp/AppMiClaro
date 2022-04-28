package providers;


import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.DataProvider;
import org.xml.sax.SAXException;





public class LoginProvider extends Provider {
	
	public LoginProvider() throws JAXBException {
		super();
	}

	@DataProvider(name = "DataLogin")
	public static Object[][] DataLogin() throws JAXBException, FileNotFoundException, SAXException, ParserConfigurationException  {				
	 return new Object[][] {
	   {
		   GetParamDataByName("email").getValue() ,
		   GetParamDataByName("password").getValue(),
		   GetParamLocatorsByName("t3XpathIniciaSesion").getValue(),
		   GetParamLocatorsByName("t3XpathCorreo").getValue(),
		   GetParamLocatorsByName("t3XpathPassword").getValue(),
		   GetParamLocatorsByName("t3XpathButtonAccep").getValue()
		   
	   }
	  
	 };
	}

}
