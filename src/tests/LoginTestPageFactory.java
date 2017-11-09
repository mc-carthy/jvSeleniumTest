package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.LoginPageFactory;

public class LoginTestPageFactory {
	String username = "tim@testemail.com";
	String password = "trpass";
	
	public void loginTestPageFactory() {
		// Initialise driver
		WebDriver driver;
		driver = utilities.DriverFactory.open("firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
		loginPageFactory.login(username, password);
		
	}
}
	


