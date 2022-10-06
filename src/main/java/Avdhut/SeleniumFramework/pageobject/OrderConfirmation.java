package Avdhut.SeleniumFramework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Avdhut.SeleniumFramework.commoncomponents.CommonComponent;

public class OrderConfirmation extends CommonComponent {
	WebDriver driver;
	public OrderConfirmation(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".hero-primary")
	WebElement confirmElement ;
	
	By confirmBy=By.cssSelector(".hero-primary");
	public String confirm() {
		IsVisible(confirmBy);
		return confirmElement.getText();
		
	}
}
