package providers;

import javax.xml.bind.JAXBException;

import org.testng.annotations.DataProvider;

public class PassWelcomeIntroProvider extends Provider {


	@DataProvider(name = "SkipeIntroProvider")
	public static Object[][] SkipeIntroProvider() throws JAXBException
	{
		return new Object[][]
				{
					{
						GetParamLocatorsByName("t6IdSkipIntro").getValue()
					}
				};
	}
}
