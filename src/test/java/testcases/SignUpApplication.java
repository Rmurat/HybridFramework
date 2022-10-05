package testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProviders.ExcelUtility;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SignupPage;

public class SignUpApplication extends BaseClass {
	
	 SignupPage user;
	LoginPage login;
	DashboardPage dash;
	
	
	@Test (dataProvider="NewAccount2")
	public void signUp(String name, String email, String pass, String interest,String gender,String stateName)
	
	{
		user=new SignupPage(driver);
	
		
		user.signUp(name, email, pass);
		
		user.pickInterest(interest);
		
		user.pickgender(gender);
		
		user.pickState(stateName);
		
		user.clickOnSignUpButton();
		
		boolean ele=user.userCreated();
		
		Assert.assertTrue(ele);
		
		
	}
	
	
	
	
	
	@Test (dataProvider="NewAccounts")
	public void userExist(String name, String email, String pass, String interest,String gender,String stateName,String uname, String passs)
	
	{
		user=new SignupPage(driver);
	    dash= new DashboardPage(driver);
	    login=new LoginPage(driver);
		
		user.signUp(name,email, pass);
		
		user.pickInterest(interest);
		
		System.out.println("Name is "+name + " Gender is "+gender);
		
		user.pickgender(gender);
		
		user.pickState(stateName);
		
		user.clickOnSignUpButton();
		
		boolean error=user.getErrorMsg();
		
		Assert.assertTrue(error);
		
		user.clickOnAlreadyUser();
		
		
		
        login.loginToApplication(uname, passs);
        
      
        
        dash.clickOnlogoutButton();
	}	
		
	
	
	@DataProvider(name="NewAccounts")
	public Object[][] getData()
	{
		Object[][] arr=ExcelUtility.getDataFromSheet("Accounts");
		
		return arr;
	}
	
	@DataProvider(name="NewAccount2")
	public Object[][] getData2()
	{
		Object[][] arr=ExcelUtility.getDataFromSheet2("Accounts");
		
		return arr;
	}
}


