package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;



public class RestClient {

	
	
	public RestClient()
	{
	}
	
	
	//1 Get Method Without Headers
	//Sets up a client, executes the api, and returns the response
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient = HttpClients.createDefault();//create client
		HttpGet httpGet = new HttpGet(url);//http get request
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);//hit the Get url
		
		return closeableHttpResponse; 
	}
	
	
	//2 Get Method With Headers
	//Sets up a client, executes the api, and returns the response
		public CloseableHttpResponse get(String url, HashMap<String, String> headerMap) throws ClientProtocolException, IOException
		{
			CloseableHttpClient httpClient = HttpClients.createDefault();//create client
			HttpGet httpGet = new HttpGet(url);//http get request
			
			for(Map.Entry<String, String> entry : headerMap.entrySet())
			{
				httpGet.addHeader(entry.getKey(), entry.getValue());							
			}	
				
			CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);//hit the Get url
			
			return closeableHttpResponse; 
		}
	
	
//	//1 Get Method
//	public void get(String url) throws ClientProtocolException, IOException
//	{
//		CloseableHttpClient httpClient = HttpClients.createDefault();//create client
//		HttpGet httpGet = new HttpGet(url);//http get request
//		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);//hit the Get url
//		
//		//a. Status Code
//		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();//identify the status code that is returned
//		System.out.println("Status code is --> " + statusCode);
//		
//		//b. json
//		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
//		JSONObject responseJson = new JSONObject(responseString);
//		System.out.println("Response Json is -->" + responseJson);
//		
//		//c. Headers
//		Header[] headerArray = closeableHttpResponse.getAllHeaders();
//		
//		//Hashmap is an unorderdered collection of key value pairs, it cannot contain duplicates
//		HashMap<String, String> allHeaders = new HashMap<String, String>();
//		
//		for(Header header : headerArray)
//		{
//			allHeaders.put(header.getName(), header.getValue());
//			
//		}	
//		
//		System.out.println("All headers -->" + allHeaders);
//		
//		
//	}
	
	
	
	
}
