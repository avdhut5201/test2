package Avdhut.SeleniumFramework.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Avdhut.SeleniumFramework.commoncomponents.CommonComponent;

public class Checkout  extends CommonComponent{
WebDriver driver;

	
	public Checkout(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		super(driver2);
    	this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="[placeholder='Select Country']")
	WebElement countryElements;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountryElement;
	
	By results=By.cssSelector(".ta-results");
	
//	public void selectCountry(String country) {
//		Actions a = new Actions(driver);
//		a.sendKeys(selectCountryElement, country).build().perform();
//		IsVisible(results);
//		selectCountryElement.click();
//	}
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(countryElements, countryName).build().perform();
		IsVisible(By.cssSelector(".ta-results"));
		selectCountryElement.click();
	}
	
	public OrderConfirmation submitOrder() {
	submit.click();
	return new OrderConfirmation(driver);
		
		
	}
	
	
	

}
