package providers;

import javax.xml.bind.JAXBException;

import org.testng.annotations.DataProvider;

public class CountrySelectProvider extends Provider {

	
	@DataProvider(name = "ActionsCountrySelectProvider")
	public static Object[][] ActionsCountrySelectProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t2OXpathFormUbicacion").getValue(),
						GetParamLocatorsByName("t2OIdComboPaises").getValue(),
						GetParamLocatorsByName("t2OBtnConfirmar").getValue(),
						GetParamLocatorsByName("country").getValue()
						
					}
				};
	}
}
