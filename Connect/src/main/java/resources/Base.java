package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializebrowser() throws Exception {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\M1036018\\oxygen-workspace\\Connect\\src\\main\\java\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

	public Object[][] getData(String SheetName) throws Exception {

		Object[][] data = null;
		FileInputStream fis = new FileInputStream(
				"C:\\\\Users\\\\M1036018\\\\Documents\\\\Selenium_Udemy\\\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int count = workbook.getNumberOfSheets();

		for (int i = 0; i < count; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(SheetName)) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				int r = sheet.getLastRowNum();
				r = r + 1;
				int c = sheet.getRow(0).getLastCellNum();
				data = new Object[r][c];
				for (int j = 0; j < r; j++) {
					for (int k = 0; k < c; k++) {
						data[j][k] = sheet.getRow(j).getCell(k).getStringCellValue();
					}
				}

			}
		}

		return data;

	}

	public void getScreenshot(String result) throws Exception {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\test\\" + result + "screensot.png"));

	}

}
