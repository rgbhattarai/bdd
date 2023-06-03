package myHooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import facotory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {

	WebDriver driver;
	@Before 
public void setup() {
		
		ConfigReader configreader = new ConfigReader();
		Properties prop = configreader.initializeProperty();
		driver=DriverFactory.initializeBrowser(prop.getProperty("browserName"));
		//driver= DriverFactory.getDriver();
		driver.get(prop.getProperty("url"));
		
	}
	@After
	public void tearDown(Scenario scenario) {
		String scenarioName = scenario.getName().replaceAll(" ", "_");
		if (scenario.isFailed()) {
			byte[]srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs (OutputType.BYTES);
			scenario.attach(srcScreenshot, "image/png", scenarioName);
		}
		
		driver.quit();
	
		
	}
}
