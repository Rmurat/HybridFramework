package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utility.Utility;

public class ExtentManager {

	public static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
	
		
		if(extent==null)
		{
			System.out.println("LOG:INFO - No Report Object Found - Creating Report Object");
			extent=createInstance();
			return extent;
			
		}
		else
		{
			System.out.println("LOG:INFO - Report Object Found - Reusing existing Object");
			return extent;
		}
		
	}
	
	
	
	public static ExtentReports createInstance()
	{
		// append date time with report
		
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/Automation"+Utility.getDate()+".html");
		
		//add configration to change the them of the report
		
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Automation Report");
		htmlReport.config().setDocumentTitle("Sprint Report");
		
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReport);
		return extent;
		
	}
}
