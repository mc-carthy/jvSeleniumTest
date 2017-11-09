package tests;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
	
	WebDriver driver;
	String url = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
	
	String name;
	String email; 
	String phone;
	String gender;
	String password; 
	String country;
	boolean weeklyEmail;
	boolean monthlyEmail;
	boolean occasionalEmail;
	
	WebElement nameElement;
	WebElement emailElement;
	WebElement phoneElement;
	WebElement passwordElement;
	WebElement verifyPasswordElement;
	WebElement maleGenderElement;
	WebElement femaleGenderElement;
	WebElement countryElement;
	WebElement weeklyEmailElement;
	WebElement monthlyEmailElement;
	WebElement occassionalEmailElement;
	WebElement submitFormElement;
	
	@Before
	public void Setup() {
		System.out.println("Setting up test");
		driver = utilities.DriverFactory.open("firefox");
	}
	
	@After
	public void tearDown() {
		System.out.println("Closing test");
		driver.close();
	}
	
	public void defineWebElements() {
		nameElement = driver.findElement(By.id("MainContent_txtFirstName"));
		emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		phoneElement = driver.findElement(By.id("MainContent_txtHomePhone"));
		passwordElement = driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']"));
		verifyPasswordElement = driver.findElement(By.id("MainContent_txtVerifyPassword"));
		maleGenderElement = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Male']"));
		femaleGenderElement = driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Female']"));
		countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		weeklyEmailElement = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		monthlyEmailElement = driver.findElement(By.id("MainContent_checkMonthlyEmail"));
		occassionalEmailElement = driver.findElement(By.id("MainContent_checkUpdates"));
		submitFormElement = driver.findElement(By.id("MainContent_btnSubmit"));
	}
	
	@Test
	public void newAccountTest() {
		System.out.println("NEW RECORD: " + 
			name + " " + 
			email + " " + 
			phone + " " +
			gender + " " +
			password + " " +
			country + " " +
			weeklyEmail + " " +
			monthlyEmail + " " +
			occasionalEmail
		);
		
		driver.get(url);
		
		driver.findElement(By.linkText("Create Account")).click();
		
		defineWebElements();
			
		// Text fields
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phone);
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
		
		// Submit form
		submitFormElement.click();

		// Get confirmation
		String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String expectedConf = "Customer information added successfully";
		
		if (conf.contains(expectedConf)) {
			System.out.println("Confirmation: " + conf);			
		} else {
			System.out.println("Test failed!");
		}
	}

	@Parameters
	public static List<String[]> getData() {
		String filename = "C:\\Users\\mick.mccarthy\\Documents\\testing\\seleniumJavaSetUp\\UserAccounts.csv";
		return utilities.CSV.get(filename);
	}
	
	public NewAccountDDT(
		String name, 
		String email, 
		String phone, 
		String gender, 
		String password, 
		String country, 
		String weeklyEmail,
		String monthlyEmail,
		String occasionalEmail
	) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
		this.country = country;
		this.weeklyEmail = (weeklyEmail.equals("TRUE")) ? true : false;
		this.monthlyEmail = (monthlyEmail.equals("TRUE")) ? true : false;
		this.occasionalEmail = (occasionalEmail.equals("TRUE")) ? true : false;
	}
}
