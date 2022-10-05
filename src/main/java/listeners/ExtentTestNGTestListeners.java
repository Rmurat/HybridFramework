package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import browserFactory.BrowserFactory;
import utility.Utility;

public class ExtentTestNGTestListeners implements ITestListener {
	
	// Step 1 - Create Object of extent report
	ExtentReports extent=ExtentManager.getInstance();
	
	// Step 2- Create ThreadLocal so that each thread can have own local copy
	ThreadLocal<ExtentTest> parentTest=new ThreadLocal<ExtentTest>();
	
	
	public void onTestStart(ITestResult result)
	{
		ExtentTest extentTest=extent.createTest(result.getMethod().getMethodName());
		//set once
		parentTest.set(extentTest);
	}

	public void onTestSuccess(ITestResult result)
	{
		//get every time you need it
		parentTest.get().pass("Test Pass");
	}
	
	public void onTestFailure(ITestResult result)
	{
		String base64=Utility.captureScreenshotAsBase64(BrowserFactory.getBrowserInstance());
		parentTest.get().fail("Test Failed "+result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		parentTest.get().skip("Test Skipped");
	}
	
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
}
