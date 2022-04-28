package providers;

import javax.xml.bind.JAXBException;

import org.testng.annotations.DataProvider;

public class ChatBotPolicesPaymentsProvier extends Provider {

	
	@DataProvider(name = "FindChatBotPaymentsProvider")
	public static Object[][] FindChatBotPaymentsProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t5XpathPagos").getValue(),
						GetParamLocatorsByName("t5XpathScrollView").getValue(),
						GetParamLocatorsByName("t5XpathCompraPaquetes").getValue(),
						GetParamLocatorsByName("XpathPoliticasUsoDatos").getValue(),
						GetParamLocatorsByName("t5XpathButtonCancelar").getValue()
					}
				};
	}
}
