package providers;

import javax.xml.bind.JAXBException;

import org.testng.annotations.DataProvider;

public class PassPolicesProviders extends Provider {

	@DataProvider(name="AccepButttonProvider")
	public static Object[][] AccepButttonProvider() throws JAXBException
	{
		return new Object[][] {
			 {
				 GetParamLocatorsByName("puAcceptButton").getValue()
			 } 
		 }; 
	}
	
	@DataProvider(name="SkipePolicesProvider")
	public static Object[][] SkipePolicesProvider() throws JAXBException
	{
		return new Object[][] {
			 {
				 GetParamLocatorsByName("puSkipePolices").getValue()
			 } 
		 }; 
	}
	@DataProvider(name="AcceptPermissions")
	public static Object[][] AcceptPermissions() throws JAXBException
	{
		return new Object[][]
		{
			{
			 GetParamLocatorsByName("XpathPoliticaBtnPermitir").getValue()
			}
		};
	}
}
