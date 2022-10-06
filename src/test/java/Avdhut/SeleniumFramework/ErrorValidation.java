package Avdhut.SeleniumFramework;

import static org.testng.Assert.assertEquals;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Avdhut.SeleniumFramework.TestComponent.BaseTest;
import Avdhut.SeleniumFramework.pageobject.CartPage;
import Avdhut.SeleniumFramework.pageobject.LandingPage;
import Avdhut.SeleniumFramework.pageobject.ProductCatalougePage;

public class ErrorValidation extends BaseTest {
	LandingPage landingPage;
	@Test(groups= {"ErrorHandling"})
	public void submitorder() throws IOException, InterruptedException {
		LandingPage landingPage=launchApplication();
		landingPage.loginapplication("anshika@gmail.com", "Iamki000");
		Assert.assertEquals("Incorrect email or passwoord.", landingPage.getErrorMessage());
		

		
		
	}
	
	@Test(groups= {"ErrorHandling"})
	public void ProductErrorValidation() throws IOException, InterruptedException
	{

		String productName = "ZARA COAT 3";
	LandingPage landingPage=launchApplication();
		ProductCatalougePage productCatalogue = landingPage.loginapplication("rahulshetty@gmail.com", "Iamking@000");
		List<WebElement> products = productCatalogue.getProducts();
		productCatalogue.Addcart(productName);
		CartPage cartPage = productCatalogue.gotocart();
		Boolean match = cartPage.verifyProduct("ZARA COAT 33");
		Assert.assertFalse(match);
		
	

	}


}
