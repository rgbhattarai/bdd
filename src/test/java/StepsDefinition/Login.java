package StepsDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import facotory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccounSuccessPage;
import pages.Homepage;
import pages.LoginPage;
import utils.CommonUtils;


public class Login {
	
	WebDriver driver;
	private LoginPage loginpage ;
	private AccounSuccessPage accountsuccesspage;

	@Given ("User navigates to login page") 
	public void User_navigates_to_login_page() {
		driver= DriverFactory.getDriver();
		Homepage homepage = new Homepage(driver);
//		driver.findElement(By.xpath("//span[text()='My Account']")).click();
//		driver.findElement(By.xpath("//a[text()='Login']")).click();
		homepage.clickOnmyAccount();
		loginpage= homepage.clickOnLogin();
	}
	@When("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String vvalidemail) {
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(validemail);
		
		loginpage.validEmailId(vvalidemail);
}
	
	@When("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String vvalidpassword) {
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(validpassword);
		//loginpage = new LoginPage(driver);
		loginpage .validPassword1(vvalidpassword);
	}
	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
	  // driver.findElement(By.xpath("//input[@type='submit']")).click();
		//loginpage = new LoginPage(driver);
		accountsuccesspage=loginpage.loginClick();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
	   //Assert.assertEquals("Edit your account information", driver.findElement(By.xpath("//a[text()='Edit your account information']")).getText());
		//loginpage = new LoginPage(driver);
		
		Assert.assertTrue(accountsuccesspage.successfullyLoggedIn());
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(invalidemail);
		CommonUtils commonutils = new CommonUtils();
		
		loginpage.validEmailId(commonutils.getEmailWtihTimeStamp());
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidpassword) {
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(invalidpassword);
		loginpage.validPassword1(invalidpassword);
	}

	@Then("User should get proper warning message about credentials mismatch")
	public void user_should_get_proper_warning_message_about_credentials_mismatch() {
		 //Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.",driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText() );
		Assert.assertTrue(loginpage.IncorrectCredential());
	}

	@When("User enters no email address  into email field")
	public void user_enters_no_email_address_into_email_field() {
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("");
		
		loginpage.validEmailId("");
	}

	@When("User enters no passwordinto password field")
	public void user_enters_no_passwordinto_password_field() {
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("");
		loginpage.validPassword1("");
	}
	
}
