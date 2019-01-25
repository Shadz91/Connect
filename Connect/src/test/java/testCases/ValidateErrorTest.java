package testCases;

import org.apache.logging.log4j.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SelectFlightPage;
import resources.Base;

public class ValidateErrorTest extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	@Test(dataProvider = "testData")
	public void y(String username, String password) throws Exception {

		driver = initializebrowser();
		driver.get(prop.getProperty("url"));
		log.info("Page loaded successfully");

		HomePage homePage = new HomePage(driver);
		homePage.departMethod().sendKeys(username);
		Thread.sleep(3000);
		homePage.departMethod().sendKeys(Keys.TAB);

		homePage.arriveMethod().sendKeys(password);
		Thread.sleep(3000);
		homePage.arriveMethod().sendKeys(Keys.TAB);
		homePage.searchMethod().click();
		log.debug("Clicked on Search button");

		SelectFlightPage selectFlightPage = new SelectFlightPage(driver);
		selectFlightPage.continueButtonMethod().click();
		System.out.println(selectFlightPage.errorMethod().getText());

	}

	@DataProvider(name = "testData")
	public Object[][] pulldata() throws Exception {
		Object[][] data = getData("Sheet3");
		return data;
	}

}
