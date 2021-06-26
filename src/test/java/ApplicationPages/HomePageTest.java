package ApplicationPages;

import java.io.IOException;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Resources.base;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePageTest extends base {
	public WebDriver driver;

	LoginPage login;
	LandingPage landing;
	HomePage homePage;

	@BeforeTest

	public void setup() throws IOException, InterruptedException {
		driver = initializeDriver();
		login = new LoginPage(driver);
		landing = new LandingPage(driver);
		homePage = new HomePage(driver);

		driver.get(prop.getProperty("url"));
		landing.getLogin();
		login.loginsuccess(prop.getProperty("emailid"), prop.getProperty("password"));

	}

	@Test

	public void ValidateTheHeaderOptions() {

		homePage.ValidateMenuTabs();
	}

	@Test

	public void ValidateWomenShoppingPageisDisplayed() {
		homePage.ValidateWomenMenuisclicable();
		homePage.ValidateWomenPageIsDisplayed();
	}

	

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
