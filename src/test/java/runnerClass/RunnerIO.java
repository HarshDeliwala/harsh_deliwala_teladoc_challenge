package runnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions
(
		features = "./src/test/java/featureFiles/Teladoc.feature",
		glue = "stepDefinitions",
		dryRun = false
		
		
)
	



public class RunnerIO extends AbstractTestNGCucumberTests
{
	

}
