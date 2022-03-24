package providers;

import java.io.File;
import java.io.FileNotFoundException;



import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

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
}
