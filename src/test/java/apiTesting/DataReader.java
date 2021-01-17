package apiTesting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

/* @author: Koshal Jain
 * Util Class for API Comparison
 */

public class DataReader {

	 private Properties properties;
	 private final String propertyFilePath= "src//test//resources//Configuration.properties";
	 public static Logger logger;
	 
	 /*
	  * Constructor will read Config file, It have filenames of APITestData
	  */
	 public DataReader()
	 {
		 BufferedReader reader;
		 logger = Logger.getLogger("API Comparison");
		 
		 try 
		 {
			 File log4jfile = new File("./src/test/resources/log4j.properties");
			 PropertyConfigurator.configure(log4jfile.getAbsolutePath());
			 
			 reader = new BufferedReader(new FileReader(propertyFilePath));
			 properties = new Properties();
			 try 
			 {
				 properties.load(reader);
				 reader.close();
			 } 
			 catch (IOException e) 
			 {
				 e.printStackTrace();
			 }
		 } 
		 catch (FileNotFoundException e) 
		 {
			 e.printStackTrace();
			 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		 } 
	 }
	 
	 /*
	  * function returns the fileName path from Config file
	  */
	 public String getFilePath(String key)
	 {
		 String value = properties.getProperty(key);
		 if(value!= null) return value;
		 else throw new RuntimeException("value not specified in the Configuration.properties file."); 
	 }

	 
}
