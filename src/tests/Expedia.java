package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
	
	WebDriver driver;
	String url = "https://www.expedia.co.uk/";
	long implicitWait = 7;
	
	String destinationCity = "New York, NY";
	String checkInDate = "10/12/2017";
	String checkOutDate = "17/12/2017";
	String numOfAdults = "3";
	String numOfChildren = "0";
	String numStars = "4";
	String searchResult = "3";
	
	WebElement hotelTabElement;
	WebElement hotelDestinationElement;
	WebElement checkInDateElement;
	WebElement checkOutDateElement;
	WebElement numOfAdultsDropdownElement;
	WebElement numOfChildrenDropdownElement;
	WebElement submitFormButton;
	
	WebElement starButton;
	WebElement updatingResultsModal;
	WebElement thirdSearchResult;
	
	WebElement hotelNameElement;
	WebElement starsElement;
	WebElement reserveButtonElement;

	WebElement paymentOptionsTitleElement;

	
	public void defineHomeWebElements() {
		hotelTabElement = driver.findElement(By.id("tab-hotel-tab-hp"));
		hotelDestinationElement = driver.findElement(By.id("hotel-destination-hp-hotel"));
		checkInDateElement = driver.findElement(By.id("hotel-checkin-hp-hotel"));
		checkOutDateElement = driver.findElement(By.id("hotel-checkout-hp-hotel"));
		numOfAdultsDropdownElement = driver.findElement(By.id("hotel-1-adults-hp-hotel"));
		numOfChildrenDropdownElement = driver.findElement(By.id("hotel-1-children-hp-hotel"));
		// TODO - Make this selector less brittle
		submitFormButton = driver.findElement(By.cssSelector("#gcw-hotel-form-hp-hotel > div:nth-child(13) > label > button"));
	}
	
	public void defineResultsWebElements() {
		starButton = driver.findElement(By.id("star" + numStars));
		thirdSearchResult = driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[" + (Integer.parseInt(searchResult)) + "]/div[2]/div/a"));
	}
	
	public void defineHotelResultWebElements() {
		hotelNameElement = driver.findElement(By.id("hotel-name"));
		starsElement = driver.findElement(By.cssSelector("#license-plate > div.star-rating-wrapper > strong.star-rating > span.stars-grey"));
		reserveButtonElement = driver.findElement(By.cssSelector("#rooms-and-rates > div > article > table > tbody.room.room-above-fold.first-room-featured.single-offer-room > tr > td.book-button-column > div > div.book-button-wrapper > button"));
	}
	
	public void defintePaymentOptionModalWebElements() {
		paymentOptionsTitleElement = driver.findElement(By.id("payment-choice-modal-title"));
	}
	
	@Test
	public void hotelReservation() {
		
		defineHomeWebElements();
		
		
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
		defineResultsWebElements();
		
		starButton.click();
		
		
		// Analyze the results and make a selection
		// TODO - This is brittle as a result of the result occasionally being clicked
		// before the page has reloaded the results after selecting a star rating
		thirdSearchResult.click();
		
		
		// Switch window to new popup (2nd tab)
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		defineHotelResultWebElements();
		
		String hotelName = hotelNameElement.getText();
		String starsRating = starsElement.getAttribute("title");
		
		System.out.println(hotelName);
		System.out.println(starsRating);
		
		// Book reservation
		reserveButtonElement.click();
				
		// Get confirmation
		defintePaymentOptionModalWebElements();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement visiblePaymentOptionsTitleElement = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id("payment-choice-modal-title")));
		
		String paymentOptionsText = visiblePaymentOptionsTitleElement.getText();	
		System.out.println(paymentOptionsText);
		Assert.assertTrue(paymentOptionsText.contains("Payment options"));
	}
	
	@BeforeMethod
	public void setup() {
		driver = utilities.DriverFactory.open("firefox");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
