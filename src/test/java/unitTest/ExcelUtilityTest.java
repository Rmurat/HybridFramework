package unitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import dataProviders.ExcelUtility;

public class ExcelUtilityTest {
	
	
	@Test
	public void checkExcel()
	{
		Object [][] arr=ExcelUtility.getDataFromSheet("Users");
		String data= (String) arr[1][0];
		Assert.assertTrue(data.equalsIgnoreCase("mukesh@gmail.com"));
	}

}
