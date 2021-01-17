package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions
		(
				 features = ".//Features/APIComparison.feature",
				 glue= {"stepDefinitionAPI"},
				 plugin = {"pretty", "html:target/cucumber-api.html"},
				 monochrome = true,
				 dryRun = false
		)

public class TestRunnerAPI {
	
}
