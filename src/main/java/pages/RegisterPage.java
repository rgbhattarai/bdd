package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	ElementUtils utils;
	@FindBy(id = "input-firstname")
	private WebElement firstName;

	@FindBy(id = "input-lastname")
	private WebElement lastName;

	@FindBy(id = "input-email")
	private WebElement inputemail;

	@FindBy(id = "input-telephone")
	private WebElement inserttelePhone;

	@FindBy(id = "input-password")
	private WebElement insertpassword;

	@FindBy(id = "input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement selectPrivacyPloicy;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement selectContinueButton;
	

	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement selectforNewsletter;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateWarningMsg;
	
	
	
	
	public RegisterPage (WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		utils = new ElementUtils(driver);
	}

	public void insertFirstname(String firstname) {
		utils.typeTextIntoElement(firstName, firstname, 30);
		//firstName.sendKeys(firstname);
	}
	public void insertLastname(String lastname) {
		utils.typeTextIntoElement(lastName, lastname, 30);
		//lastName.sendKeys(lastname);
	}
	public void insertEmail(String email) {
		utils.typeTextIntoElement(inputemail, email, 30);
		//inputemail.sendKeys(email);
	}
	public void insertTelephone(String telephone) {
		utils.typeTextIntoElement(inserttelePhone, telephone, 30);
	//	inserttelePhone.sendKeys(telephone);
	}
	public void insertPassword(String password) {
		utils.typeTextIntoElement(insertpassword, password, 30);
		//insertpassword.sendKeys(password);
	}
	public void confirmPassword (String password) {
		utils.typeTextIntoElement(confirmPassword, password, 30);
		//confirmPassword.sendKeys(password);
	}
	
	public void selectPrivacyPloicy () {
		utils.waitAndClickonElement(selectPrivacyPloicy, 30);
		//selectPrivacyPloicy.click();
	}
	public AccounSuccessPage selectContinueButton (){
		utils.waitAndClickonElement(selectContinueButton, 30);
		// selectContinueButton.click();
		 return new AccounSuccessPage(driver);
}
	
		public void selectNewsletter() {
			utils.waitAndClickonElement(selectforNewsletter, 30);
			//selectforNewsletter.click();
		}

	public boolean duplicateWarningMsg(){
		boolean duplicateWarning =duplicateWarningMsg.isDisplayed();
		return duplicateWarning ;
}
}
