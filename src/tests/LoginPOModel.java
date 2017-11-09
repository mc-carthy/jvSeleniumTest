package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.DashboardPage;
import pages.LoginPage;

public class LoginPOModel {
	
	String username = "tim@testemail.com";
	String password = "trpass";
	
	@Test
	public void loginTestPOModel() {
		// Initialise driver
		WebDriver driver;
		driver = utilities.DriverFactory.open("firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		// Enter login credentials
		LoginPage loginPage = new LoginPage(driver);
		loginPage.SetUserName(username);
		loginPage.SetPassword(password);
		loginPage.ClickSubmit();
		
		// Get login confirmation
		DashboardPage dashboardPage = new DashboardPage(driver);
		String conf = dashboardPage.getConfirmation();
		Assert.assertTrue(conf.contains("Logged in successfully"));
		
		// Close driver
		driver.quit();
	}
		

}
