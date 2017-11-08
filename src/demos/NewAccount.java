package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {
		
		String browser = "firefox";
		
		String url = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		String name = "Mick McCarthy";
		String email = "mick@test.com";
		String password = "sdetPassword";
		String country = "Denmark";
		String phoneNumber = "00000000";
		String gender = "Male";
		
		boolean weeklyEmail = true;
		boolean monthlyEmail = false;
		boolean occasionalEmail = false;


		// 1. Create WebDriver
		WebDriver driver;
		driver = utilities.DriverFactory.open(browser);
		
		// 2. Navigate to URL (http://sdettraining.com/trguitransactions/AccountManagement.aspx)
		driver.get(url);
		
		// 3. Click on Create Account
		driver.findElement(By.linkText("Create Account")).click();
		
		// 4. Declare web elements and fill out form
		WebElement nameElement = driver.findElement(By.id("MainContent_txtFirstName"));
		WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement phoneElement = driver.findElement(By.id("MainContent_txtHomePhone"));
		WebElement passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
		WebElement verifyPasswordElement = driver.findElement(By.id("MainContent_txtVerifyPassword"));
		WebElement maleGenderElement = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Male']"));
		WebElement femaleGenderElement = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']"));
		WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		WebElement weeklyEmailElement = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		WebElement monthlyEmailElement = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		WebElement occassionalEmailElement = driver.findElement(By.id("MainContent_checkUpdates"));
		WebElement submitFormElement = driver.findElement(By.id("MainContent_btnSubmit"));
		
		// Text fields
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phoneNumber);
		passwordElement.sendKeys(password);
		verifyPasswordElement.sendKeys(password);
		
		// Radio button
		if (gender.equalsIgnoreCase("Male")) {
			maleGenderElement.click();			
		} else if (gender.equalsIgnoreCase("Male")) {
			femaleGenderElement.click();			
		} else {
			System.out.println("Gender not entered correctly");
		}
		
		// Dropdown
		new Select(countryElement).selectByVisibleText(country);

		// Checkboxes
		if (weeklyEmail) {
			if (!weeklyEmailElement.isSelected())
			{
				weeklyEmailElement.click();
			}
		} else {
			if (weeklyEmailElement.isSelected())
			{
				weeklyEmailElement.click();
			}
		}
		
		if (monthlyEmail) {
			if (!monthlyEmailElement.isSelected())
			{
				monthlyEmailElement.click();
			}
		} else {
			if (monthlyEmailElement.isSelected())
			{
				monthlyEmailElement.click();
			}
		}
		
		if (occasionalEmail) {
			if (!occassionalEmailElement.isSelected())
			{
				occassionalEmailElement.click();
			}
		} else {
			if (occassionalEmailElement.isSelected())
			{
				occassionalEmailElement.click();
			}
		}
		
		// 5. Submit
		submitFormElement.click();

		// 6. Get confirmation
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String expectedConf = "Customer information added successfully";
		
		if (conf.contains(expectedConf)) {
			System.out.println("Confirmation: " + conf);			
		} else {
			System.out.println("Test failed!");
		}
		
		
		// 7. Close browser
		driver.close();
	}

}
