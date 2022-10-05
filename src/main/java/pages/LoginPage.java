package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

	By uname=By.id("email1");
	By pass=By.id("password1");
	By loginButton=By.className("submit-btn");
	By errorMessage=By.xpath("//h2[@class='errorMessage']");
	
	
	public void loginToApplication(String username,String password)
	{
		
		driver.findElement(uname).sendKeys(username);
		driver.findElement(pass).sendKeys(password);
		driver.findElement(loginButton).click();
	}
	
	public String getErrorMessage()
	{
		return driver.findElement(errorMessage).getText();
	}
		
	public void clearUnameAndPass()
	{
		
		driver.findElement(uname).clear();
		driver.findElement(pass).clear();
		driver.findElement(loginButton).click();
	}
	
	
	public void loginUname(String username)
	{
		driver.findElement(uname).sendKeys(username);
		driver.findElement(loginButton).click();
	}
	
	public void loginPass(String password)
	{
		driver.findElement(pass).sendKeys(password);
		driver.findElement(loginButton).click();
	}
	

}
