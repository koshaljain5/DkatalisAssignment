package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions
		(
				features = ".//Features/PurchasePillow.feature",
				 glue= {"stepDefinitions"},
				 plugin = {"pretty",
						   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				 monochrome = true,
				 dryRun = false
		)
public class TestRunner {
	
}
