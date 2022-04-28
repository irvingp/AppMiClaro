package providers;


import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.DataProvider;
import org.xml.sax.SAXException;


public class PolicesProviders extends Provider {

	public PolicesProviders() throws JAXBException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@DataProvider(name="ExistePoliticadeAccesoProvider")
	public static Object[][] ExistePoliticadeAccesoProvider() throws JAXBException
	{
		 return new Object[][] {
			 {
			GetParamLocatorsByName("XpathPoliticasUsoDatos").getValue()				 
			 } 
		 }; 
	}
	
	@DataProvider(name="PermisoUbicacionTitleProvider")
	public static Object[][] PermisoUbicacionTitleProvider() throws JAXBException
	{
		return new Object[][] {
			 {
			GetParamLocatorsByName("puXpathUbicacionTitle").getValue(),
			GetParamDataByName("puUbicacionTitle").getValue()
			 } 
		 }; 
	}
	
	@DataProvider(name="PermisoUbicacionDescriptionProvider")
	public static Object[][] PermisoUbicacioDescriptionProvider() throws JAXBException
	{
		return new Object[][] {
			 {
			GetParamLocatorsByName("puXpathUbicacionDescription").getValue(),
			GetParamDataByName("puUbicacion").getValue()
			 } 
		 }; 
	}
	
	@DataProvider(name="PermisoUsuarioTitleProvider")
	public static Object[][] PermisoUsuarioTitleProvider() throws JAXBException
	{
		return new Object[][] {
			 {
				 GetParamLocatorsByName("puXpathUsuarioTitle").getValue(),
				 GetParamDataByName("puUsuarioTitle").getValue()
			 } 
		 }; 
	}
	
	@DataProvider(name="PermisoUsuarioDescriptionProvider")
	public static Object[][] PermisoUsuarioDescriptionProvider() throws JAXBException
	{
		return new Object[][] {
			 {
				 GetParamLocatorsByName("puXpathUsuarioDescription").getValue(),
				 GetParamDataByName("puUsuario").getValue()
			 } 
		 }; 
	}
	
	@DataProvider(name="PermisoNumTeleTitleProvider")
	public static Object[][] PermisoNumTeleTitleProvider() throws JAXBException
	{
		return new Object[][] {
			 {
				 GetParamLocatorsByName("puXpathNumTeleTitle").getValue(),
				 GetParamDataByName("puUsuario").getValue(),
				 GetParamDataByName("puNuTelefono").getValue()
			 } 
		 }; 
	}
	@DataProvider(name="PermisoNumTeleDescriptionProvider")
	public static Object[][] PermisoNumTeleDescriptionProvider() throws JAXBException
	{
		return new Object[][] {
			 {
				 GetParamLocatorsByName("puXpathNumTeleDescription").getValue(),
				 GetParamDataByName("puNuTelefono").getValue()
			 } 
		 }; 
	}
	@DataProvider(name="PermisoSisOpTitleProvider")
	public static Object[][] PermisoSisOpTitleProvider() throws JAXBException
	{
		return new Object[][] {
			 {
				 GetParamLocatorsByName("puXpathSisOpTitle").getValue(),
				 GetParamDataByName("puSistemaTitle").getValue()
			 } 
		 }; 
	}
	@DataProvider(name="PermisoSisOpDescriptionProvider")
	public static Object[][] PermisoSisOpDescriptionProvider() throws JAXBException
	{
		return new Object[][] {
			 {
				 GetParamLocatorsByName("puXpathSisOpDescription").getValue(),
				 GetParamDataByName("puSistema").getValue()
			 } 
		 }; 
	}
	@DataProvider(name="PermisoDatosdeUsoTitleProvider")
	public static Object[][] PermisoDatosdeUsoTitleProvider() throws JAXBException
	{
		return new Object[][] {
			 {
				 GetParamLocatorsByName("puXpathDataUsTitle").getValue(),
				 GetParamDataByName("puDatosTitle").getValue()
			 } 
		 }; 
	}
	
	@DataProvider(name="PermisoDatosdeUsoDescriptionProvider")
	public static Object[][] PermisoDatosdeUsoDescriptionProvider() throws JAXBException
	{
		return new Object[][] {
			 {
				 GetParamLocatorsByName("puXpathDataUsDescription").getValue(),
				 GetParamDataByName("puDatos").getValue()
			 } 
		 }; 
	}
	
	
	@DataProvider(name="PermisoUbicacionProvider")
	public static Object[][] PermisoUbicacionProvider() throws JAXBException
	{
		return new Object[][] {
			 {
			GetParamLocatorsByName("puXpathUbicacionTitle").getValue(),
			GetParamLocatorsByName("puIdDescription").getValue(),
			GetParamDataByName("puUbicacion").getValue()
			 } 
		 }; 
	}
	@DataProvider(name="PermisoUsuarioProvider")
	public static Object[][] PermisoUsuarioProvider() throws JAXBException
	{
		return new Object[][] {
			 {
			GetParamLocatorsByName("puXpathUsuarioTitle").getValue(),
			GetParamLocatorsByName("puIdDescription").getValue(),
			GetParamDataByName("puUsuario").getValue()
			 } 
		 }; 
	}
	@DataProvider(name="PermisoNumTelefProvider")
	public static Object[][] PermisoNumTelefProvider() throws JAXBException
	{
		return new Object[][] {
			 {
			GetParamLocatorsByName("puXpathNumTeleTitle").getValue(),
			GetParamLocatorsByName("puIdDescription").getValue(),
			GetParamDataByName("puNuTelefono").getValue()
			 } 
		 }; 
	}
	@DataProvider(name = "PoliticasAccesoProvider")
	public static  Object[][] BeforeTestPoliticasProvider() throws FileNotFoundException, JAXBException, SAXException, ParserConfigurationException 
	{
		 return new Object[][] {
			 {
			GetParamLocatorsByName("XpathPoliticasUsoDatos").getValue(),
			GetParamLocatorsByName("XpathPoliticasBAccepta").getValue(),
			GetParamLocatorsByName("XpathPoliticaBtnPermitir").getValue()
					 
			 } 
		 }; 
	}
	
	

}
