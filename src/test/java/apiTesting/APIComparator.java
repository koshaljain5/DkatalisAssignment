package apiTesting;

import java.io.File;
import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/* @author: Koshal Jain
 * Test Class for API Comparison
 */

public class APIComparator extends DataReader{

	/*
	 * function sends the API request and returns the JSON response
	 */
	public String sendRequest(String url)
	{
		String res = "";
		try 
		{
			RestAssured.baseURI = url;
			Response response = RestAssured.given().request().get();
			
			if(response.getStatusCode() == 200)
				res = response.getBody().asString();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			e.toString();
		}
		return res;
	}
	
	
	/*
	 * function compares responses of two API's
	 */
	public Boolean compareAPI(String res1, String res2)
	{
		Boolean result = res1.equals(res2);
		return result;
	}
	
	
	 
	 /*
	  * function to compare API responses
	  * For each iteration/input present in testdata files
	  */
	 public boolean compareApiFiles(String file1, String file2)
	 {
		String flag = "";
		try 
		{
			String res1, res2;
			
			File f1 = new File(System.getProperty("user.dir") + file1.toString());
			File f2 = new File(System.getProperty("user.dir") + file2.toString());
			
			Scanner sc1 = new Scanner(f1);  
			Scanner sc2 = new Scanner(f2);
			
			 while(sc1.hasNextLine() || sc2.hasNextLine() )
			 {
				 String url1 = sc1.nextLine();
				 String url2 = sc2.nextLine();
				 
				 res1 = sendRequest(url1);
				 res2 = sendRequest(url2);
				 
				 
				 if(compareAPI(res1, res2))
				 {
					 logger.info(url1 + " equals " + url2);
				 }
				 else
				 {
					 logger.info(url1 + " not equals " + url2);
					 flag = "not equals";
				 }	 
			 }
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag.equals("not equals") || flag.equals("") ? false : true;
	 }
}
