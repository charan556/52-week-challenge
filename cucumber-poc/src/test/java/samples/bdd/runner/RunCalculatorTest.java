package samples.bdd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, dryRun = true, format = { "pretty",
		"html:target/cucumber" }, glue = "samples.bdd.steps", features = { "classpath:cucumber/calculator.feature",
				"classpath:cucumber/Banking.feature" })
public class RunCalculatorTest {
}
