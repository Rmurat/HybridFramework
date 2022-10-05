package unitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import dataProviders.ConfigUtility;

public class ConfigUtilityTest {

	@Test
	public void checkConfig()
	{
		String browserValue=ConfigUtility.getValue("browser");
		Assert.assertTrue(browserValue.equalsIgnoreCase("Chrome"));
		String applicationURL=ConfigUtility.getValue("appURL");
		Assert.assertTrue(applicationURL.contains("ineuron"));
	}
}
