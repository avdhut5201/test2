package Avdhut.SeleniumFramework;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Avdhut.SeleniumFramework.TestComponent.BaseTest;
import Avdhut.SeleniumFramework.pageobject.CartPage;
import Avdhut.SeleniumFramework.pageobject.Checkout;
import Avdhut.SeleniumFramework.pageobject.LandingPage;
import Avdhut.SeleniumFramework.pageobject.OrderConfirmation;
import Avdhut.SeleniumFramework.pageobject.OrderPage;
import Avdhut.SeleniumFramework.pageobject.ProductCatalougePage;
import io.github.bonigarcia.wdm.WebDriverManager;

@Test(dataProvider = "getData",groups = {"Purchase"})
public class SubmitOrderTest extends BaseTest {
	String product_nameString = "ZARA COAT 3";
	LandingPage landingPage;
	WebDriver driver;

	public void submitorder(HashMap<String,String> input) throws IOException, InterruptedException {
		// div[aria-label='Incorrect email or password.']

		String urlString = "https://rahulshettyacademy.com/client";

		String message;
		boolean match;
		String countryString = "India";
		LandingPage landingPage=launchApplication();
		ProductCatalougePage productCatalougePage = landingPage.loginapplication(input.get("email"), input.get("password"));
		// ProductCatalougePage productCatalougePage=new ProductCatalougePage(driver);
		List<WebElement> products = productCatalougePage.getProducts();
		productCatalougePage.Addcart(input.get("product"));
		CartPage cartpage = productCatalougePage.gotocart();
		match = cartpage.verifyProduct(input.get("product"));
		Assert.assertTrue(match);
		Checkout checkout = cartpage.gotoCheckout();
		checkout.selectCountry(countryString);
		OrderConfirmation orderConfirmation = checkout.submitOrder();
		message = orderConfirmation.confirm();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "submitorder" },dataProvider = "getData")
	public void OrderHistoryTest(HashMap<String,String> input) throws IOException {
		// "ZARA COAT 3";
		landingPage = launchApplication();
		ProductCatalougePage productCatalogue = landingPage.loginapplication(input.get("email"), input.get("password"));
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(input.get("product")));

	}
	
	

	@DataProvider
	public Object[][] getData() throws IOException {
	//		HashMap<String,String> map = new HashMap<String,String>();
	//		map.put("email", "anshika@gmail.com");
	//		map.put("password", "Iamking@000");
	//		map.put("product", "ZARA COAT 3");
	//		
	//		HashMap<String,String> map1 = new HashMap<String,String>();
	//		map1.put("email", "shetty@gmail.com");
	//		map1.put("password", "Iamking@000");
	//		map1.put("product", "ADIDAS ORIGINAL");
		List<HashMap<String, String>>data=getJsonDataToMap(System.getProperty("user.dir")+"\\\\src\\\\test\\\\java\\\\Avdhut\\\\SeleniumFramework\\\\TestData\\\\PurchaseOrder.json");
		return new Object[][] { {data.get(0)},
				{data.get(1) } };

	}

} 
