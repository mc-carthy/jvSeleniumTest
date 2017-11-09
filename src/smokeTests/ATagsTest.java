package smokeTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATagsTest {
	
	WebDriver driver;
	String url = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
	
	@Test
	public void loginElementsPresentTest() {
		System.out.println("Running test");
		driver.get(url);
		
		boolean createAccountPresent = false;
		boolean forgotPasswordPresent = false;
	
		List<WebElement> aElements = driver.findElements(By.tagName("a"));
		int numOfAElements = aElements.size();
		System.out.println("There are " + numOfAElements + " 'a' elements on the page.");
		
		for (WebElement aElement : aElements) {
			System.out.println(aElement.getText());
			if (aElement.getText().equalsIgnoreCase("Create Account")) {
				createAccountPresent = true;
			}
			if (aElement.getText().equalsIgnoreCase("Forgot Password?")) {
				forgotPasswordPresent = true;				
			}
		}
		
		Assert.assertTrue(createAccountPresent, "Create Account <a> present");
		Assert.assertTrue(forgotPasswordPresent, "Forgot Password <a> present");
		
	}
	
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
}
