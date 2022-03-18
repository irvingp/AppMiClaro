package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JOptionPane;


public class FuncionesProperties {

	public String leerProperties(String propertie,int num) {
		Properties propiedades = new Properties();
		InputStream entrada = null;

		propiedades.getProperty(propertie);
		try {
			entrada = new FileInputStream(direccionProperties(num));
			propiedades.load(entrada);
			//propiedades.getProperty(propertie);
			entrada.close();
			return propiedades.getProperty(propertie);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			
			return null;
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void escribirProperties(String comentario,String llave,String igual,String valor,String fondo) {
		Properties newProps = new Properties();
		   File archivo = new File(direccionProperties(13));       
           System.out.println("Crearemos un nuevo archivo de configuraciones");
           		try {
			                 
			try (OutputStream outputStream = new FileOutputStream(archivo)) {
	                        System.out.println("\tCreando el objeto Properties");
	                        Properties prop = new Properties();                 
	                        System.out.println("\tCreamos las claves del archivo properties y sus valores");
	                        // set key and value
	        	            prop.setProperty("comentario", comentario); 
	        	            prop.setProperty("llave", llave);       
	        	            prop.setProperty("igual",igual);       
	        	            prop.setProperty("valor", valor);   
	        	            prop.setProperty("font", fondo);   
	                        prop.store(outputStream, "Config");	                         
	                        System.out.println("\tEl archivo se cierra en este punto gracias al Try-catch con recursos");
	                    }
	                     
	             
	                        
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	private String direccionProperties(int i) {
		switch(i) {
		case 1:
			return "./src/test/java/properties/MiAppDataHN.Properties";
		case 2:
			return "./src/test/java/properties/MiAppDataNI.properties";	
		
		default:
			return null;
		}
	}
	
}
