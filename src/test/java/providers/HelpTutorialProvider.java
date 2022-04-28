package providers;

import javax.xml.bind.JAXBException;

import org.testng.annotations.DataProvider;

public class HelpTutorialProvider extends Provider{

	@DataProvider(name="TestNavigateToTutorialProvider")
	public static Object[][] TestNavigateToTutorialProvider() throws JAXBException
	{
		 return new Object[][] {
			 {
				 GetParamLocatorsByName("t4XpathButtonHelp").getValue(),
				 GetParamLocatorsByName("t8XpathButtonTuorial").getValue(),
			 } 
		 }; 
	}
	
	@DataProvider(name="TestShowTutorialProvider")
	public static Object[][] TestShowTutorialProvider() throws JAXBException
	{
		 return new Object[][] {
			 {
				 GetParamDataByName("OnboardingOne").getValue(),
				 GetParamLocatorsByName("t8XpathTextOnBoarding").getValue(),
				 GetParamLocatorsByName("t8XpathButtonTuorial").getValue()
			 } 
		 }; 
	}
	@DataProvider(name="ReturnProvider")
	public static Object[][] ReturnProvider() throws JAXBException
	{
		 return new Object[][] {
			 {
				
				 GetParamLocatorsByName("t6IdSkipIntro").getValue()
			 } 
		 }; 
	}
}
