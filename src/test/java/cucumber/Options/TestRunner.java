package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",glue= {"stepDefination"},plugin="json:target/jsonReports/test.json")
public class TestRunner {


        //SeleniumAutomationTestin
	   // Test user automation

	// add comment 
	// add test automation
	// add test


}
