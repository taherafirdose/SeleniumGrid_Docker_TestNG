package ApplicationPages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;


public class LandingPageTest extends base {
	public WebDriver driver;

	LandingPage landingPage;

	@BeforeTest
	public void setUp() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		landingPage = new LandingPage(driver);

	}

	@Test

	public void ValidateClickSignIn() throws IOException {

		landingPage.getLogin();

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}