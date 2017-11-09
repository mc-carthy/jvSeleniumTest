package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
	
	WebDriver driver;
	String url = "https://www.expedia.co.uk/";
	
	String destinationCity = "New York, NY";
	String checkInDate = "10/12/2017";
	String checkOutDate = "17/12/20017";
	String numOfAdults = "2";
	String numOfChildren = "0";
	
	WebElement hotelTabElement;
	WebElement hotelDestinationElement;
	WebElement checkInDateElement;
	WebElement checkOutDateElement;
	WebElement numOfAdultsDropdownElement;
	WebElement numOfChildrenDropdownElement;
	WebElement submitFormButton;

	
	public void defineWebElements() {
		hotelTabElement = driver.findElement(By.id("tab-hotel-tab-hp"));
		hotelDestinationElement = driver.findElement(By.id("hotel-destination-hp-hotel"));
		checkInDateElement = driver.findElement(By.id("hotel-checkin-hp-hotel"));
		checkOutDateElement = driver.findElement(By.id("hotel-checkout-hp-hotel"));
		numOfAdultsDropdownElement = driver.findElement(By.id("hotel-1-adults-hp-hotel"));
		numOfChildrenDropdownElement = driver.findElement(By.id("hotel-1-children-hp-hotel"));
		// TODO - Make this selector less brittle
		submitFormButton = driver.findElement(By.cssSelector("#gcw-hotel-form-hp-hotel > button.submit"));
	}
	
	@Test
	public void hotelReservation() {
		
		defineWebElements();
		
		// Search
		hotelTabElement.click();
		hotelDestinationElement.sendKeys(destinationCity);
		// These are submitted in this order so the check out field isn't prepopulated
		checkOutDateElement.sendKeys(checkOutDate);
		checkInDateElement.sendKeys(checkInDate);
		
		new Select(numOfAdultsDropdownElement).selectByValue(numOfAdults);
		new Select(numOfChildrenDropdownElement).selectByValue(numOfChildren);
		
		submitFormButton.click();
		
		// Modify the search results giving criteria
		
		// Analyze the results and make a selection
		
		// Book reservation
		
		// Fill out contact & booking forms
		
		// Get confirmation
	}
	
	@BeforeMethod
	public void setup() {
		driver = utilities.DriverFactory.open("firefox");
		driver.get(url);
	}
	
	@AfterMethod
	public void tearDown() {
//		driver.close();
	}

}
