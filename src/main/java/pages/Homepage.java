package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class Homepage {
	
    WebDriver driver;
	private ElementUtils utils;
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccount;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement login;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement register;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement search;
	
	
	
	
	public Homepage(WebDriver driver) {
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
		utils = new ElementUtils(driver);
	}
	
	public void clickOnmyAccount() {
		utils.waitAndClickonElement(myAccount, 30);
		//myAccount.click();
		
	}
	public RegisterPage clickOnRegister() {
		utils.waitAndClickonElement(register, 30);
		//register.click();
		return new RegisterPage (driver);
	}

	public LoginPage clickOnLogin() {
		utils.waitAndClickonElement(login, 30);
		//login.click();
		return new LoginPage(driver);
	}
	public SearchPage clickOnSearch() {
		utils.waitAndClickonElement(search, 30);
		//search.click();
		return new SearchPage (driver);
	}
}
