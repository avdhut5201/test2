package Avdhut.SeleniumFramework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Avdhut.SeleniumFramework.commoncomponents.CommonComponent;

public class LandingPage  extends CommonComponent{
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement loginbutton ;
	//css=".ng-tns-c4-12"
	@FindBy(css="[class*='flyInOut']")
	WebElement messageElement;
	
		public ProductCatalougePage loginapplication(String useremail,String userpassword ) {
			userEmail.sendKeys(useremail);
			userPassword.sendKeys(userpassword);
			loginbutton.click();
			ProductCatalougePage productCatalougePage=new ProductCatalougePage(driver);
			return productCatalougePage;
			
		}
		
		public String getErrorMessage() {
			 WebelementIsVisible(messageElement);
			 return messageElement.getText();
		}
		
		public void goTo() {
			// TODO Auto-generated method stub
			driver.get("https://rahulshettyacademy.com/client");
			
		}
		
	

}
