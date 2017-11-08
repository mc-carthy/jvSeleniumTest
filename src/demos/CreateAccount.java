package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		// 1. Create WebDriver
		System.setProperty("webdrver.gecko.driver", "C:\\Users\\mick.mccarthy\\Documents\\testing\\seleniumJavaSetUp\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		// 2. Navigate to URL (http://sdettraining.com/trguitransactions/AccountManagement.aspx)
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		// 3. Click on Create Account
		driver.findElement(By.linkText("Create Account")).click();
		
		// 4. Fill out form
		driver.findElement(By.id("MainContent_txtFirstName")).sendKeys("Mick McCarthy");
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys("mick@test.com");
		driver.findElement(By.id("MainContent_txtHomePhone")).sendKeys("00000000");
		driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']")).sendKeys("sdetPassword");
		driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys("sdetPassword");
		driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Male']")).click();
		
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Denmark");

		driver.findElement(By.id("MainContent_checkWeeklyEmail")).click();
		
		// 5. Submit
		driver.findElement(By.id("MainContent_btnSubmit")).click();

		// 6. Get confirmation
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println("Confirmation: " + conf);
		
		// 7. Close browser
		driver.close();
	}

}