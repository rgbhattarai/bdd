package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccounSuccessPage {
	WebDriver driver;
	
	@FindBy(linkText="Edit your account information")
	private WebElement successfullyLoggedIn; 
	

	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	private WebElement accountCreatedSuccessfully;
	
	public AccounSuccessPage (WebDriver driver ) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean successfullyLoggedIn() {
		boolean success= successfullyLoggedIn.isDisplayed();
		return success;
	}
	public boolean accountSuccessMsg(){
		boolean accountCreated =accountCreatedSuccessfully.isDisplayed();
		return accountCreated ;
	}	
}
