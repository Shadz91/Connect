package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlightPage {

	WebDriver driver;

	public SelectFlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(id = "air-booking-product-2")
	private WebElement continueButton;

	@FindBy(className = "message--content")
	private WebElement error;

	public WebElement continueButtonMethod() {
		return continueButton;
	}

	public WebElement errorMethod() {
		return error;
	}

}
