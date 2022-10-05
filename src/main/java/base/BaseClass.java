package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import browserFactory.BrowserFactory;
import dataProviders.ConfigUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	@BeforeClass
	public void setupBrowser()
	{
		driver = BrowserFactory.startBrowser(ConfigUtility.getValue("browser"), ConfigUtility.getValue("appURL"));
		

	}

	@AfterClass
	public void closeBrowser()
	{
		driver.quit();

	}

}
