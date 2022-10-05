package pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import dataProviders.ExcelUtility;
import utility.Utility;



public class SignupPage {
	
	WebDriver driver;
	Select sel;
	
	public SignupPage(WebDriver driver)
	{
		this.driver=driver;
	}

	
	By newuser=By.xpath("//a[@class='subLink']");
	By namee=By.name("name");
	By emaill=By.id("email");
	By passcode=By.name("password");
	By interests=By.xpath("//div[@class='interests-div']//label");
	//By gender=By.xpath("//input[@value='Female']");
	By state=By.name("state");
	By signupButton=By.xpath("//button[@type='submit']");
	By userCreated=By.xpath("//h2[text()='Sign In']");
	By emailAlreayRegistered=By.xpath("//h2[text()='Email already registered!']");
	By alreayUser=By.xpath("//a[text()='Already a user? Login']");
	
	public void signUp(String name, String email, String pass)
	{
		driver.findElement(newuser).click();
		driver.findElement(namee).sendKeys(name);
		driver.findElement(emaill).sendKeys(email);
		driver.findElement(passcode).sendKeys(pass);
			
	}
	
	
	
	public void pickInterest(String picker)
	{
		Utility.selectValueFromList(driver, interests, picker);
	}
	
	public void pickgender(String gender)
	{
		//Utility.selectValueFromList(driver, gender, picker);
		//driver.findElement(gender);
		
		System.out.println("XPath is "+"//label[text()='"+gender+"']");
		
		Utility.getElementIntoView(driver, By.xpath("//label[text()='"+gender+"']")).click();
		
		//driver.findElement(By.xpath("//label[text()='"+gender+"']")).click();

	}
	
	public void pickState(String picker)
	{
		sel=new Select(driver.findElement(state));
		sel.selectByVisibleText(picker);
		
	}
	
	public void clickOnSignUpButton()
	{
	    driver.findElement(signupButton).click();;
	
	}
	
	public boolean userCreated()
	{
		return driver.findElement(userCreated).getText().contains("SIGN IN");
		
	}
	
	/*public void AlreadyRegisteredMsg()
	{
		if(driver.findElement(emailAlreayRegistered).getText().contains("Email already registered!"))
		{
			JavascriptExecutor je = (JavascriptExecutor) driver; 
			je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(alreayUser));
			driver.findElement(alreayUser).click();
		}
		
	}
	*/
	
	
	public boolean getErrorMsg()
	{
		return driver.findElement(emailAlreayRegistered).isDisplayed();
		
	}
	
	public void clickOnAlreadyUser()
	{
		driver.findElement(alreayUser).click();
	}
}
