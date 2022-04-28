package providers;

import javax.xml.bind.JAXBException;

import org.testng.annotations.DataProvider;

public class ChatBotPolicesHelpProvider extends Provider{

	@DataProvider(name = "FindChatBotProvider")
	public static Object[][] FindChatBotProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t4XpathButtonHelp").getValue(),
						GetParamLocatorsByName("t4IdChatBot").getValue(),
						GetParamLocatorsByName("XpathPoliticasUsoDatos").getValue()
					}
				};
	}
	
}
