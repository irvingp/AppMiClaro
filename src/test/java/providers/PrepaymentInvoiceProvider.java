package providers;

import javax.xml.bind.JAXBException;

import org.testng.annotations.DataProvider;

public class PrepaymentInvoiceProvider extends Provider {

	@DataProvider(name="CheckPrepaymentsInvoiceProvider")
	public static Object[][] CheckPrepaymentsInvoiceProvider() throws JAXBException
	{
		 return new Object[][] {
			 {
				 GetParamLocatorsByName("t9ArrowButton").getValue(),
				 GetParamLocatorsByName("t9ButtonMenuPagos").getValue(),
				 GetParamLocatorsByName("t9XpathMiFactura").getValue(),
				 GetParamLocatorsByName("t9IdBalancesTitle").getValue()
				 
			 } 
		 }; 
	}
}
