package utility;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {
	
	
	public static WebElement getElementIntoView(WebDriver driver,By locator) {
		
		WebElement ele=driver.findElement(locator);
		
		JavascriptExecutor je = (JavascriptExecutor) driver; 
		
		je.executeScript("arguments[0].scrollIntoView(true);",ele);
		
		waitForSecond(1);
		
		return ele;
	}
	
	
	
	public static void waitForSecond(int second)
	{
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			
		}
	}
	
	
	
	
	
	public static void selectValueFromList(WebDriver driver,By locator,String valueToBeSelected)
	{
			
		// accept locator
		List<WebElement> allValuesFromDropDown=driver.findElements(locator);
		
		// run a loop
		for(WebElement element:allValuesFromDropDown)
		{
			// check condition
			if(element.getText().contains(valueToBeSelected))
			{
				element.click();
				break;
			}

		}
	}
		
		
		public static String getDate()
		{
			Date date = new Date();

			SimpleDateFormat dateFormat = new SimpleDateFormat("HH_mm_ss_dd__MM_yyyy");

			return dateFormat.format(date);

		}
		
		//Third way to capture in base64 format
		public static String captureScreenshotAsBase64(WebDriver driver)
		{

			TakesScreenshot ts=(TakesScreenshot)driver;
			
			String base64=ts.getScreenshotAs(OutputType.BASE64);
			
			//System.out.println("Base 64 data is "+base64);
			
			return  base64;
			
		}	
		
		public static String robotScreenshot() throws AWTException, IOException
		{
			String screenshotPath=System.getProperty("user.dir") + "/RobotScreenshot/Screenshot" + getDate() + ".png";
			
			ImageIO.write(new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())),"png",new File(screenshotPath));
			
			return  screenshotPath;
		}
		
	
	
	
	
}
