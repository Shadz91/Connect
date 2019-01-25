package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By depart = By.id("LandingPageAirSearchForm_originationAirportCode");
	By arrive = By.id("LandingPageAirSearchForm_destinationAirportCode");
	By search = By.id("LandingPageAirSearchForm_submit-button");

	public WebElement departMethod() {
		return driver.findElement(depart);
	}

	public WebElement arriveMethod() {
		return driver.findElement(arrive);
	}

	public WebElement searchMethod() {
		return driver.findElement(search);
	}

}
