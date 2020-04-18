package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase 
{

	public static Properties prop;
	public int RESPONSE_STATUS_CODE = 200;
	public String SUCCESS_STATUS_VAL = "success";
	
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/tony/AutomateApiWS/restapi/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
		} 
			catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
			catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}	
}
