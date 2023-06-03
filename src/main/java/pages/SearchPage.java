package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class SearchPage {
 WebDriver driver;
 private ElementUtils utils;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement validProduct;
	
	@FindBy(linkText="HP LP3065")
	WebElement validProductDisplayed;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement enterInvalidProduct;
	
	@FindBy(xpath="//p[contains(text(),'There is no product ')]")
	WebElement productNomatch;
	
	public SearchPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		utils = new ElementUtils(driver);
		
	}
	public void enterValidProdcut(String validprodcut) {
		utils.typeTextIntoElement(validProduct, validprodcut, 30);
		//validProduct.sendKeys(validprodcut);
	}
	public void enterInValidProdcut(String invalidprodcut) {
		utils.typeTextIntoElement(enterInvalidProduct, invalidprodcut, 30);
		//enterInvalidProduct.sendKeys(invalidprodcut);
	}
	public boolean validProdcutDisplayed() {
		boolean vaildProduct= validProductDisplayed.isDisplayed();
		return vaildProduct;
	}
	
	public boolean productNomatch() {
		boolean noavailableproduct=  productNomatch.isDisplayed();
		return noavailableproduct;
		
	}
}
