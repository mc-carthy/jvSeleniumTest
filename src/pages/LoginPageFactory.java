package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	WebDriver driver;
	
	@FindBy(id = "MainContent_txtUserName")
	WebElement usernameElement;
	
	@FindBy(id = "MainContent_txtPassword")
	WebElement passwordElement;
	
	@FindBy(id = "MainContent_btnLogin")
	WebElement submitElement;

	
	// Steps
	public void setUserName(String username) {
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(username);
	}
	
	public void setPassword(String password) {
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);
	}
	
	public void clickSubmit() {
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	
	// Actions
	public void login(String username, String password) {
		setUserName(username);
		setPassword(password);
		clickSubmit();
	}
	
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
