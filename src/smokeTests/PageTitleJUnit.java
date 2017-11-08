package smokeTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {
	
	WebDriver driver;
	
	String url = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
	String expectedTitle = "SDET Training | Account Management";
	
	@Before
	public void Setup() {
		driver = utilities.DriverFactory.open("firefox");
		driver.get(url);
	}
	
	@After
	public void TearDown() {
		driver.close();
	}

	@Test
	public void PageTitleTest() {
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(expectedTitle, actualTitle);
	}
}
