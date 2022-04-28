package test;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	 private static ExtentReports extent;
	    
	    public synchronized static ExtentReports getReporter(String filePath) {
	        if (extent == null) {
	            extent = new ExtentReports(filePath, true);
	            extent.loadConfig(new File("extendsreport.xml"));
	        }
	        
	        return extent;
	    }
}
