package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import browserFactory.BrowserFactory;
import dataProviders.ConfigUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	@Parameters({"BrowserName","AppToTest"})
	@BeforeClass
	public void setupBrowser(String browser, String url)
	{
		/*
		 *  This is best when you dont have to change browser and url very freq.If values are very dynamic in nature then
		 *  we will go with second approach where user will pass this details while running
		 * 
		 1 -driver = BrowserFactory.startBrowser(ConfigUtility.getValue("browser"), ConfigUtility.getValue("appURL"));
		
		*/
		System.out.println("Test will ne be running on "+browser +" "+url);
		
		driver = BrowserFactory.startBrowser(browser, url);

		

	}


	@AfterClass
	public void closeBrowser()
	{
		driver.quit();

	}

}
