package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement waitForElement(WebElement element, long durationinSec) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinSec));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Throwable e) {
			e.printStackTrace();

		}
		return webElement;
	}

	public void typeTextIntoElement(WebElement element, String textTobeTyped, long durationinSec) {
		WebElement webelement = waitForElement(element, durationinSec);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(textTobeTyped);
	}

	public void waitAndClickonElement(WebElement element, long durationinSec) {
		WebElement webelement = waitForElement(element, durationinSec);
		webelement.click();

	}

	public void selectOptionInDropDown(WebElement element, String dropdownoption, long durationinSec) {
		WebElement webelement = waitForElement(element, durationinSec);
		Select select = new Select(webelement);
		select.selectByVisibleText(dropdownoption);
	}

	public Alert waitForAlert(long durationinSec) {
		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinSec));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Throwable e) {
			e.printStackTrace();

		}
		return alert;

	}

	public void acceptAlert( long durationinSec) {
		Alert alert = waitForAlert (durationinSec);
		alert.accept();
	}
	public void dismisstAlert( long durationinSec) {
		Alert alert = waitForAlert (durationinSec);
		alert.dismiss();
	}
	public void mouseHoverAndClick ( WebElement element,long durationinSec) {
		WebElement webelement = waitForVisibilityOfElement( element, durationinSec);
		Actions action = new Actions(driver);
		action.moveToElement(webelement).build().perform();
	}
	public WebElement waitForVisibilityOfElement(WebElement element, long durationinSec) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationinSec));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			e.printStackTrace();

		}
		return webElement;
	}
	public void javaScriptClick (WebElement element, long durationinSec) {
		WebElement webelement = waitForVisibilityOfElement( element, durationinSec);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();",webelement);
	}
	public void javaScriptType (WebElement element,String textToBeType, long durationinSec) {
		WebElement webelement = waitForVisibilityOfElement( element, durationinSec);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+textToBeType+"'",webelement);
	}
}
