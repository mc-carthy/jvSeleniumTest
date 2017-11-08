package smokeTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {
	
	String url = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
	String expectedTitle = "SDET Training | Account Management";

	@Test
	public void PageTitleTest() {
		WebDriver driver = utilities.DriverFactory.open("firefox");
		driver.get(url);
		
		
		String actualTitle = driver.getTitle();
		
	}
}
