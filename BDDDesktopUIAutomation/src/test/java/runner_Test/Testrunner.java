package runner_Test;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = {"src/test/resources/Features/"},
 glue={"MyStepDefinitions"},
 //plugin = { "pretty", "html:target/htmlreports" }
 plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json" }
 )

public class Testrunner {

}


 