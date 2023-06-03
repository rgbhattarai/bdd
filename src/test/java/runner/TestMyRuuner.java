package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith (Cucumber.class)
	@CucumberOptions(features="srs\\test\\resource\\features",
	                   glue= {"StepsDefinition","myHooks"},
	                   publish =true,
	                   plugin= {"pretty","html:target/CumCumberReports/cucumber.html"})
	
	public class TestMyRuuner {

}
