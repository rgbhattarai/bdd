package StepsDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import facotory.DriverFactory;
import io.cucumber.java.en.*;
import pages.Homepage;
import pages.SearchPage;

public class Search {
 WebDriver driver;
 private SearchPage searchpage ;
 
	@Given("User enters the Aplication")
	public void user_enters_the_aplication() {
		
      driver = DriverFactory.getDriver();
      
	}

	@When("User enters valid product {string} into Search box filed")
	public void user_enters_valid_product_into_search_box_filed(String validproduct) {
		searchpage = new SearchPage(driver);
		searchpage.enterInValidProdcut(validproduct);
		//driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(validproduct);
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		
		Homepage homepage = new Homepage(driver);
		searchpage=homepage.clickOnSearch();
		//driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
	}

	@Then("User should get a valid product displayed in search results")
	public void user_should_get_a_valid_product_displayed_in_search_results() {
		//searchpage = new SearchPage(driver);
		Assert.assertTrue(searchpage.validProdcutDisplayed());
		Assert.fail();
	}
	@When("User enters invalid product {string} into Search box filed")
	public void user_enters_invalid_product_into_search_box_filed(String invalidproduct) {
		searchpage = new SearchPage(driver);
		searchpage.enterInValidProdcut(invalidproduct);
		//driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(invalidproduct);
	}
	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		//searchpage = new SearchPage(driver);
		Assert.assertTrue(searchpage.productNomatch());
	}

	@When("User does not enter any product name  into Search box filed")
	public void user_does_not_enter_any_product_name_into_search_box_filed() {
		//searchpage = new SearchPage(driver);
		

	}
}
