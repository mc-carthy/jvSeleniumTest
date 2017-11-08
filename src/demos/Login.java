package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		
		// 1. Define the WebDriver
		System.setProperty("webdrver.chrome.driver", "C:\\Users\\mick.mccarthy\\Documents\\testing\\seleniumJavaSetUp\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// 2. Open browser navigate to URL: http://sdettraining.com/trguitransactions/AccountManagement.aspx
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		// 3. Enter email address
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
		
		// 4. Enter password
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
		
		// 5. Submit login form
		driver.findElement(By.id("MainContent_btnLogin")).click();
		
		// 6. Confirm result
		String message = driver.findElement(By.id("conf_message")).getText();
		System.out.println("Confirmation: " + message);
		
		String pageTitle = driver.getTitle();
		if (pageTitle.equals("SDET Training | Account Management")) {
			System.out.println("PAGE TITLE TEST PASSED");
		} else {
			System.out.println("PAGE TITLE TEST FAILED. Actual title: " + pageTitle);
		}
		
		// 7. Close browser
		driver.close();
	}
	
}
