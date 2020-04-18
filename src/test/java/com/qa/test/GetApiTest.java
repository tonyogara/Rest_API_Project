package com.qa.test;

import java.io.IOException;
import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetApiTest extends TestBase {
	
	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String url;
	RestClient restClient;
	CloseableHttpResponse closeableHttpResponse;
	
	
	
	@BeforeMethod
	public void setup() throws ClientProtocolException, IOException
	{
		testBase = new TestBase();
		serviceUrl = prop.getProperty("URL");
		apiUrl = prop.getProperty("serviceUrl");
		url =  serviceUrl + apiUrl;		
	}
	

	@Test
	public void getAPITestWithHeaders() throws ClientProtocolException, IOException
	{
		restClient = new RestClient();	
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		restClient.get(url, headerMap);
		closeableHttpResponse = closeableHttpResponse = restClient.get(url);
				
		//1. Status code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code is ---->" + statusCode);
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE, "Status code is not 200 opps!!");
		
		
		
		//2. Json response - check status has a value of success
		String jsonResponseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		System.out.println("Response string is --> " + jsonResponseString);
		JSONObject responseJsonObj = new JSONObject(jsonResponseString);
		System.out.println("JSONObject string is --> " + responseJsonObj);
		String statusVal = responseJsonObj.getString("status");
		System.out.println("Status values is  -->" + statusVal);
		Assert.assertEquals(statusVal, SUCCESS_STATUS_VAL, "Issue with status value");
		
		
		//3. Check it contains the value of employee_name of Tiger Nixon
		
		
		
		
	}
}
