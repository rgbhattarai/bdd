package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage {
    WebDriver driver;
	private ElementUtils utils;

	@FindBy(xpath="//input[@id='input-email']")
	private WebElement validEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement validPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginclick;
	
	
	
//	@FindBy(xpath="//input[@id='input-email']")
//	private WebElement inValidEmail;
	
//	@FindBy(xpath="//input[@id='input-password']")
//	private WebElement inValidPassword;

	@FindBy(xpath="//div[contains(@class,'alert')]")
	private WebElement credentialMismatched;
	
	public LoginPage (WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		utils = new ElementUtils(driver);
	}
	
	public void validEmailId(String validemail) {
		utils.typeTextIntoElement(validEmail, validemail, 30);
		//validEmail.sendKeys(validemail);
	}
	
	public void validPassword1(String validpassword) {
		utils.typeTextIntoElement(validPassword, validpassword, 30);
		//validPassword.sendKeys(validpassword);
	}
	
	public AccounSuccessPage loginClick () {
		utils.waitAndClickonElement(loginclick, 30);
		//loginclick.click();
		return new AccounSuccessPage(driver);
	}
	

	public boolean IncorrectCredential() {
		 boolean  errorCredentailMsg=credentialMismatched.isDisplayed();
		return errorCredentailMsg;
	}
}
