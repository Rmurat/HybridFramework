package dataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility {

	public static Properties pro;
	
	public static String getValue(String key)
	{
		
		if (pro==null)
		{
			System.out.println("LOG:INFO- Loading properties file first time ");
			creatInstance();
		}
		else
		{
			System.out.println("LOG:INFO - Reusing existing object");
		}
		
		String value=pro.getProperty(key);

		return value;
	}
	
	public static void creatInstance()
	{
		pro=new Properties();
		
		try {
			pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/Config/config.properties")));
		} catch (FileNotFoundException e) 
		{
			System.out.println("File not found "+e.getMessage());
			
		} catch (IOException e) 
		{
			System.out.println("Something Went Wrong "+e.getMessage());
		}
	}
	
}
