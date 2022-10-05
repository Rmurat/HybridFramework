package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProviders.ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginApplication extends BaseClass {

	LoginPage login;
	DashboardPage dash;
	
	
	@Test (dataProvider="Users")
	public void loginApp(String uname, String pass)
	{
		login=new LoginPage(driver);
		
		login.loginToApplication(uname, pass);
		
		dash=new DashboardPage(driver);
		
		boolean status=dash.isLogoutDisplayed();
		
		Assert.assertTrue(status);
		
		dash.clickOnlogoutButton();
	}
	
	@Test
	public void loginAppWithInvalidCredentails()
	{
		login=new LoginPage(driver);
		
		login.loginToApplication("ineuron@ineuron.ai", "rawa");

		String errorMessage=login.getErrorMessage();
				
		Assert.assertTrue(errorMessage.contains("Email and Password Doesn't match"));
	}
	@Test
	public void loginAppWithNoCredentails()
	{
		login=new LoginPage(driver);
		
		driver.navigate().refresh();
		
		login.clearUnameAndPass();
		
		String errorMessage=login.getErrorMessage();
		
		Assert.assertTrue(errorMessage.contains("Email and Password is required"));
	}
	
	
	@Test
	public void loginAppWithNoUsername()
	{
        login=new LoginPage(driver);
		
        login.clearUnameAndPass();
        
		login.loginPass("rawa2022");
		
		String errorMessage=login.getErrorMessage();
		
		Assert.assertTrue(errorMessage.equals("Email is required"));
	}
	
	
	@Test()
	public void loginAppWithNopassword()
	{
        login=new LoginPage(driver);
		
        login.clearUnameAndPass();
        
        driver.navigate().refresh();
        
		login.loginUname("ineuron@ineuron.ai");
		
		String errorMessage=login.getErrorMessage();
		
		Assert.assertTrue(errorMessage.contains("Password is required"));
	}
	
	
	@DataProvider(name="Users")
	public Object[][] getData()
	{
		Object[][] arr=ExcelUtility.getDataFromSheet2("Users");
		
		return arr;
		
	}


	
}
