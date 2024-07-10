package com.djsldji.gpt_basic_app;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class InitHttpClient {

	final static Logger logger = LoggerFactory.getLogger(InitHttpClient.class);
	
    public static void setupAPI() {
    	
        // Replace with your actual API key
        String apiKey = "YOUR_API_KEY";

        // ChatGPT API end point
        String apiUrl = "https://api.openai.com/v1/engines/davinci/completions";

        // JSON pay load
        String jsonPayload = "{\"prompt\": \"Hello, ChatGPT!\", \"max_tokens\": 50}";

        // Create HTTP client
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(apiUrl);

        // Set headers
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", "Bearer " + apiKey);

        try {
        	
	        // Set request body
	        StringEntity entity = new StringEntity(jsonPayload);
	        httpPost.setEntity(entity);
	
	        // Execute HTTP request
	        CloseableHttpResponse response = httpClient.execute(httpPost);
	
	        try {
	            // Print response
	            HttpEntity responseEntity = response.getEntity();
	            if (responseEntity != null) {
	                System.out.println(EntityUtils.toString(responseEntity));
	            }
	        } finally {
	            response.close();
	            httpClient.close();
	        }
        } catch (IOException io) {
        	logger.error(io.getMessage());
        }
    }
}
