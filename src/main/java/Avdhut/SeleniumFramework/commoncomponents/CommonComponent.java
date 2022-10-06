package Avdhut.SeleniumFramework.commoncomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Avdhut.SeleniumFramework.pageobject.CartPage;
import Avdhut.SeleniumFramework.pageobject.OrderPage;

public class CommonComponent {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;
	public CommonComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	

	public void IsVisible(By element) {
     	wait.until(ExpectedConditions.visibilityOfElementLocated(element));
     	
	}
	public void IsInVisible(By element) throws InterruptedException {
//     	wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
     	Thread.sleep(10000);
	}
	
	public void WebelementIsVisible(WebElement element) {
     	wait.until(ExpectedConditions.visibilityOf(element));
     	
	}
	public CartPage gotocart() {
		cart.click();
		CartPage cartpage =new CartPage(driver);
		return cartpage;
	}
	public OrderPage goToOrdersPage()
	{
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
	
}
