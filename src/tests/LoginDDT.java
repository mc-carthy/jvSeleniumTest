package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT {
	
	WebDriver driver;
	String url = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
	
	WebElement emailElement;
	WebElement passwordElement;
	WebElement submitElement;
	
	@BeforeTest
	public void setup() {
		System.out.println("Setting up test");
		driver = utilities.DriverFactory.open("firefox");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Closing test");
		driver.close();
	}
	
	@Test(dataProvider = "getData")
	public void loginTest(String name, String email, String password) {
		System.out.println("Running test");
		
		driver.get(url);
		
		defineWebElements();
		
		emailElement.sendKeys(email);
		passwordElement.sendKeys(password);
		submitElement.click();
		
		String message = driver.findElement(By.id("conf_message")).getText();
		System.out.println("Confirmation: " + message);
		
		String pageTitle = driver.getTitle();
		if (pageTitle.equals("SDET Training | Account Management")) {
			System.out.println("PAGE TITLE TEST PASSED");
		} else {
			System.out.println("PAGE TITLE TEST FAILED. Actual title: " + pageTitle);
		}
	}
	
	@DataProvider
	public String[][] getData() {
		String filename = "C:\\Users\\mick.mccarthy\\Documents\\testing\\seleniumJavaSetUp\\UserLogin.xls";
		return utilities.Excel.get(filename);
	}
	
	public void defineWebElements() {
		emailElement = driver.findElement(By.id("MainContent_txtUserName"));
		passwordElement = driver.findElement(By.id("MainContent_txtPassword"));
		submitElement = driver.findElement(By.id("MainContent_btnLogin"));
	}

}
