package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;

	public void SetUserName(String username) {
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
	}
	
	public void SetPassword(String password) {
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
	}
	
	public void ClickSubmit() {
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
}
