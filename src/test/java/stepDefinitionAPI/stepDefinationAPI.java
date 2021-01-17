package stepDefinitionAPI;


import org.junit.Assert;

import apiTesting.APIComparator;
import io.cucumber.java.en.*;


public class stepDefinationAPI {

	public APIComparator reader = new APIComparator();
	String pathFile1, pathFile2;
	
	@Given("Get path of File1 from {string} and File2 from {string}")
	public void get_path_of_file1_from_and_file2_from(String configFilePath1, String configFilePath2) {
		pathFile1 = reader.getFilePath(configFilePath1);
		pathFile2 = reader.getFilePath(configFilePath2);
	}


	@Then("Compare the API responses")
	public void compare_the_api_responses() {
		boolean result  = reader.compareApiFiles(pathFile1, pathFile2);
		Assert.assertTrue("API Test Completed", result);
	}
}
