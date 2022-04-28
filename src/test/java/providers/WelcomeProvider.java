package providers;

import javax.xml.bind.JAXBException;

import org.testng.annotations.DataProvider;

public class WelcomeProvider extends Provider{
	
	@DataProvider(name="OnBoardingTextOneProvider")
	public static Object[][] OnBoardingTextOneProvider() throws JAXBException
	{
		 return new Object[][] {
			 {
				 GetParamDataByName("OnboardingOne").getValue(),
				 GetParamLocatorsByName("t7OnboardingButtonContinue").getValue(),
				 GetParamLocatorsByName("t8XpathTextOnBoarding").getValue()
			 } 
		 }; 
	}
	
	@DataProvider(name="OnBoardingTextTwoProvider")
	public static Object[][] OnBoardingTextTwoProvider() throws JAXBException
	{
		 return new Object[][] {
			 {
				 GetParamDataByName("OnboardingTwo").getValue(),
				 GetParamLocatorsByName("t7OnboardingButtonContinue").getValue(),
				 GetParamLocatorsByName("t8XpathTextOnBoarding").getValue()
			 } 
		 }; 
	}
	
	@DataProvider(name="OnboardingTextThreeProvider")
	public static Object[][] OnboardingTextThreeProvider() throws JAXBException
	{
		 return new Object[][] {
			 {
				 GetParamDataByName("OnboardingThree").getValue(),
				 GetParamLocatorsByName("t7OnboardingButtonContinue").getValue(),
				 GetParamLocatorsByName("t8XpathTextOnBoarding").getValue()
			 } 
		 }; 
	}
	
	@DataProvider(name="OnboardingTextFourProvider")
	public static Object[][] OnboardingTextFourProvider() throws JAXBException
	{
		 return new Object[][] {
			 {
				 GetParamDataByName("OnBoardingFour").getValue(),
				 GetParamLocatorsByName("t7OnboardingButtonContinue").getValue(),
				 GetParamLocatorsByName("t8XpathTextOnBoarding").getValue()

			 } 
		 }; 
	}

	@DataProvider(name="OnboardingTextFiveProvider")
	public static Object[][] OnboardingTextFiveProvider() throws JAXBException
	{
		 return new Object[][] {
			 {
				 GetParamDataByName("OnboardingFive").getValue(),
				 GetParamLocatorsByName("t7OnboardingButtonContinue").getValue(),
				 GetParamLocatorsByName("t8XpathTextOnBoarding").getValue()

			 } 
		 }; 
	}
}
