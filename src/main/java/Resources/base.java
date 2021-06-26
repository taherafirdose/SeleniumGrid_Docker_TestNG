package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

public class base {
	public WebDriver driver;
	public Properties prop;
	String nodeURL;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\main\\java\\Resources\\config.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		nodeURL = "http://localhost:4444/wd/hub";

		if(browserName.equalsIgnoreCase("chrome"))
        {
            System.out.println("Inside Chrome");
            ChromeOptions options = new ChromeOptions();
            driver = new RemoteWebDriver(new URL(nodeURL), options);        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
            System.out.println("Inside Firefox");
            FirefoxOptions options = new FirefoxOptions();
            driver = new RemoteWebDriver(new URL(nodeURL), options);        }
    
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

		return driver;

	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

	public String testCaseName(ITestResult result) {
		return ("method name:" + result.getMethod().getMethodName());
	}

}
