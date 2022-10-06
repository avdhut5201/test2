package Avdhut.SeleniumFramework.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Avdhut.SeleniumFramework.commoncomponents.CommonComponent;

public class ProductCatalougePage  extends CommonComponent{
	WebDriver driver;
	public ProductCatalougePage(WebDriver driver) { 
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
// 
	By productBy=By.cssSelector(".mb-3");
	By addtocartBy=By.cssSelector(".card-body button:last-of-type");
	By toastBy=By.cssSelector("#toast-container");
	By spinner=By.cssSelector("ng-animating");
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinnerElement;
	
	
	@FindBy(id="login")
	WebElement loginbutton ;
	
	public  List<WebElement> getProducts( ) {
			IsVisible(productBy);
			return products;
	}
	
	public  WebElement getProductByname(String product_name) {
		return  getProducts().stream().filter(product->
		product.findElement(By.tagName("b")).getText().equals( product_name)).findFirst().orElse(null);
		
	}
	
	public void Addcart(String product_name) throws InterruptedException {
			WebElement product=getProductByname(product_name);
			product.findElement(addtocartBy).click();
			IsVisible(toastBy);
			IsInVisible(spinner);
			
	}
	

}
