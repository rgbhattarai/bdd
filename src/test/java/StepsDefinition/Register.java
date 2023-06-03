package StepsDefinition;
import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import facotory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccounSuccessPage;
import pages.Homepage;
import pages.RegisterPage;
import utils.CommonUtils;


public class Register {

	WebDriver driver;
	private RegisterPage registerpage;
	private AccounSuccessPage accountsuccesspage;
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
	    driver=DriverFactory.getDriver();
	    
	    Homepage homepage = new Homepage(driver);
//	    driver.findElement(By.xpath("//span[text()='My Account']")).click();
//	    driver.findElement(By.xpath("//a[text()='Register']")).click();
	    homepage.clickOnmyAccount();
	    registerpage=homepage.clickOnRegister();
	}

	@When("User enters the details into the below fields")
	public void user_enters_the_details_into_the_below_fields(DataTable dataTable) {
		Map<String,String>dataMap= dataTable.asMap(String.class, String.class);
//		  driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
//		  driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
//		  driver.findElement(By.id("input-email")).sendKeys(getEmailWtihTimeStamp());
//		  driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
//		  driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
//		  driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
			CommonUtils commonutils = new CommonUtils (); 
		  registerpage.insertFirstname(dataMap.get("firstname"));
		  registerpage.insertLastname(dataMap.get("lastname"));
		  registerpage.insertEmail(commonutils.getEmailWtihTimeStamp());
		  registerpage.insertTelephone(dataMap.get("telephone"));
		  registerpage.insertPassword(dataMap.get("password"));
		  registerpage.confirmPassword(dataMap.get("password"));
		  
			
	}

	@When("User selects privacy policy")
	public void user_selects_privacy_policy() {
		
		registerpage.selectPrivacyPloicy();
	   //driver.findElement(By.xpath("//input[@name='agree']")).click();
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		
		accountsuccesspage=registerpage.selectContinueButton();
	   //driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		
		Assert.assertTrue(accountsuccesspage.accountSuccessMsg());
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
	   //driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		
		registerpage.selectNewsletter();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		Map<String,String>dataMap= dataTable.asMap(String.class, String.class);
		
		  registerpage.insertFirstname(dataMap.get("firstname"));
		  registerpage.insertLastname(dataMap.get("lastname"));
		  registerpage.insertEmail(dataMap.get("email"));
		  registerpage.insertTelephone(dataMap.get("telephone"));
		  registerpage.insertPassword(dataMap.get("password"));
		  registerpage.confirmPassword(dataMap.get("password"));
	
	}

	@Then("User account should get proper warning message about duplicate email")
	public void user_account_should_get_proper_warning_message_about_duplicate_email() {
		
		Assert.assertTrue(registerpage.duplicateWarningMsg());  
	}

	@When("User do not enters details into any fields")
	public void user_do_not_enters_details_into_any_fields() {
		//registerpage = new RegisterPage (driver);
	}

	@Then("User should get proper warning messages for every mandatory fields")
	public void user_should_get_proper_warning_messages_for_every_mandatory_fields() {
//		registerpage = new RegisterPage (driver);
//		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: E-Mail Address is already registered!"));
//		String actualPrivacyPolicyMsz=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
//		  Assert.assertEquals(actualPrivacyPolicyMsz,"Warning: You must agree to the Privacy Policy!");
//		  
//		  String actualWarningFirstName =driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
//		  Assert.assertEquals(actualWarningFirstName, "First Name must be between 1 and 32 characters!");
//		  
//		  
//		  String actualWarningLastName =driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
//		  Assert.assertEquals(actualWarningLastName, "Last Name must be between 1 and 32 characters!");
//		  
//		  String actualWarningEmail =driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
//		  Assert.assertEquals(actualWarningEmail, "E-Mail Address does not appear to be valid!");
//		  
//		  String actualWarningPhone =driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
//		  Assert.assertEquals(actualWarningPhone, "Telephone must be between 3 and 32 characters!");
//		  
//		  String actualWarningPassword =driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
//		  Assert.assertEquals(actualWarningPassword, "Password must be between 4 and 20 characters!");
		String actualPrivacyWarningMsg= driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible'] ")).getText();
		  Assert.assertEquals(actualPrivacyWarningMsg, "Warning: You must agree to the Privacy Policy!");
		 
		  String actualFirstNameWarningMsg= driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
		  Assert.assertEquals(actualFirstNameWarningMsg, "First Name must be between 1 and 32 characters!");
		  
		  String actualLastNameWarningMsg= driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
		  Assert.assertEquals(actualLastNameWarningMsg, "Last Name must be between 1 and 32 characters!");
		  
		  String actualEmailWarningMsg= driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
		  Assert.assertEquals(actualEmailWarningMsg, "E-Mail Address does not appear to be valid!");
		  
		  String actualTelephoneWarningMsg= driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
		  Assert.assertEquals(actualTelephoneWarningMsg, "Telephone must be between 3 and 32 characters!");
		  
		  String actualPasswordWarningMsg= driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		  Assert.assertEquals(actualPasswordWarningMsg, "Password must be between 4 and 20 characters!");
	
	}

	
	}