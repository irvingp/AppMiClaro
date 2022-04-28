package providers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import configxml.Data;
import configxml.Locators;
import configxml.Parameter;
import configxml.Suite;


public class Provider {

	
	public static  Parameter GetParamByName(String name) throws JAXBException, FileNotFoundException, SAXException, ParserConfigurationException
	{
		System.setProperty("javax.xml.accessExternalDTD", "all");
		File file = new File("testng.xml");
		JAXBContext context = JAXBContext.newInstance(Suite.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		 Suite suite = (Suite) unmarshaller.unmarshal(file);
		 Parameter p  = suite.getTest().getParams().stream()	
					.filter(parameter-> name.equals(parameter.getName()))
					.findAny()
					.orElse(null);
		 
		 return p;
	}
	
	public static List<Parameter> GetListDataByParam (String param) throws JAXBException
	{
		System.setProperty("javax.xml.accessExternalDTD", "all");
		File file = new File("./xml/data.xml");
		JAXBContext context = JAXBContext.newInstance(Data.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		 Data data = (Data) unmarshaller.unmarshal(file);
		 List<Parameter> p  = data.getParams().stream()	
					.filter(parameter-> parameter.getName().contains(param))
					.collect(Collectors.toList());
		 
		 return p;
	}
	
	public static Parameter GetParamDataByName (String name) throws JAXBException
	{
		System.setProperty("javax.xml.accessExternalDTD", "all");
		File file = new File("./xml/data.xml");
		JAXBContext context = JAXBContext.newInstance(Data.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		 Data data = (Data) unmarshaller.unmarshal(file);
		 Parameter p  = data.getParams().stream()	
					.filter(parameter-> name.equals(parameter.getName()))
					.findAny()
					.orElse(null);
		 
		 return p;
	}
	public static Parameter GetParamLocatorsByName (String param) throws JAXBException
	{
		System.setProperty("javax.xml.accessExternalDTD", "all");
		File file = new File("./xml/locators.xml");
		JAXBContext context = JAXBContext.newInstance(Locators.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		 Locators locators = (Locators) unmarshaller.unmarshal(file);
		 Parameter p  = locators.getParams().stream()	
					.filter(parameter-> param.equals(parameter.getName()))
					.findAny()
					.orElse(null);
		 
		 return p;
	}
	public static List<Parameter> GetListLocatorsByParam (String param) throws JAXBException
	{
		System.setProperty("javax.xml.accessExternalDTD", "all");
		File file = new File("./xml/locators.xml");
		JAXBContext context = JAXBContext.newInstance(Locators.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		 Locators locators = (Locators) unmarshaller.unmarshal(file);
		 List<Parameter> p  = locators.getParams().stream()	
					.filter(parameter-> parameter.getName().contains(param))
					.collect(Collectors.toList());
		 
		 return p;
	}

}
