package smokeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPresentTestNG {

	WebDriver driver;
	String url = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
	
	@BeforeMethod
	public void setup() {
		System.out.println("Starting test");
		driver = utilities.DriverFactory.open("chrome");

	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Ending test");
		driver.close();
	}

	@Test
	public void loginElementsPresentTest() {
		System.out.println("Running test");
		driver.get(url);
		
		boolean loginEmailBox = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
		boolean loginPasswordBox = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
		
		Assert.assertTrue(loginEmailBox, "Email textbox present");
		Assert.assertTrue(loginPasswordBox, "Password textbox present");
	}
}
