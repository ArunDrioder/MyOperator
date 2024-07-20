package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (features = "src/test/java/features",
                glue = "stepDefinition",
                monochrome = true,
                plugin = {"html:target/cucumber.html"}

        )


public class TestNGTestRunner extends AbstractTestNGCucumberTests
{

}