package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
	}

	By logoutButton=By.xpath("//button[text()='Sign out']");
	
	
	public boolean isLogoutDisplayed()
	{
		return driver.findElement(logoutButton).isDisplayed();
	}
	
	
	public void clickOnlogoutButton()
	{
		driver.findElement(logoutButton).click();
	}
}
