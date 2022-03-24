package providers;


import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.DataProvider;
import org.xml.sax.SAXException;


public class OnBoardingProviders extends Provider {

	public OnBoardingProviders() throws JAXBException {
		super();
		// TODO Auto-generated constructor stub
	}
	@DataProvider(name = "PoliticasAccesoProvider")
	public static  Object[][] BeforeTestPoliticasProvider() throws JAXBException, FileNotFoundException, SAXException, ParserConfigurationException
	{
		 return new Object[][] {
			 {
			GetParamByName("XpathPoliticasUsoDatos").getValue(),
			GetParamByName("XpathPoliticasBAccepta").getValue(),
			GetParamByName("XpathPoliticaBtnPermitir").getValue()
					 
			 } 
		 }; 
	}

}
