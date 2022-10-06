package Avdhut.SeleniumFramework.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Avdhut.SeleniumFramework.commoncomponents.CommonComponent;

public class CartPage  extends CommonComponent {
	WebDriver driver;
	
	public 	CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	@FindBy(css=".totalRow button")
	WebElement checkout_buttonElement;
	
	public boolean verifyProduct(String product_name) {
		return cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(product_name));
	}
	
	public Checkout gotoCheckout() {
		checkout_buttonElement.click();
		return new Checkout(driver);
		
	}

}
