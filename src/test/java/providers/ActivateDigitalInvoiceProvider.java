package providers;

import javax.xml.bind.JAXBException;

import org.testng.annotations.DataProvider;

public class ActivateDigitalInvoiceProvider extends Provider{

	@DataProvider(name="NavigateToInvoiceSubscriptionProvider")
	public static Object[][] NavigateToInvoiceSubscriptionProvider() throws JAXBException
	{
		 return new Object[][] {
			 {
				 GetParamLocatorsByName("t9ArrowButton").getValue(),
				 GetParamLocatorsByName("t9ButtonMenuPagos").getValue(),
				 GetParamLocatorsByName("t9XpathMiFactura").getValue(),
				 GetParamLocatorsByName("t10IdTitleActivateSubscriptionDigitalInvoice").getValue()
				 
			 } 
		 }; 
	}
	@DataProvider(name="CheckDigitalInvoiceActivationProvider")
	public static Object[][] CheckDigitalInvoiceActivationProvider() throws JAXBException
	{
		return new Object[][] {
			{
				GetParamLocatorsByName("t10IdTitleActivateSubscriptionDigitalInvoice").getValue(),
				GetParamLocatorsByName("t10IdSubtitleActivateSubscriptionDigitalInvoice").getValue(),
				GetParamLocatorsByName("t10IdBtnSubcribeDigitalInvoice").getValue(),
				GetParamDataByName("TextTitleDigitalInvoiceActivation").getValue(),
				GetParamDataByName("TextSubtitleDigitalInvoceActivation").getValue(),
				GetParamDataByName("TextButtonSucribeInvoice").getValue()
				
			}
		};
	}
}
