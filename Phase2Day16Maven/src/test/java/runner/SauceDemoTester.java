package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/saucedemo.feature",
    glue = "stepDefinitions",
    //tags = "tag1",
    plugin = {"pretty", "json:target/cucumber-reports-json/Cucumber.json"} // Generate JSON report
   // plugin = {"pretty", "html:target/cucumber-reports"}
)

public class SauceDemoTester extends AbstractTestNGCucumberTests 
{

}
