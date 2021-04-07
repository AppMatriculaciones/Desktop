package data_access;

import java.nio.charset.StandardCharsets;

import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class GenerateHttpRequest {
	
	public static String post(String url, String body) {
		
		DefaultHttpClient httpClient = new DefaultHttpClient();
		url = url.replaceAll(" ", "%20");
		HttpPost httpPost = new HttpPost("http://localhost:5000/"+url);
		httpPost.setHeader("Content-type", "application/json");
		try {
			StringEntity stringEntity = new StringEntity(body);
			httpPost.getRequestLine();
			httpPost.setEntity(stringEntity);
			
			try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
		        StatusLine statusLine = response.getStatusLine();
		        System.out.println(statusLine.getStatusCode() + " " + statusLine.getReasonPhrase());
		        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
		        System.out.println("Response body: " + responseBody);
		        responseBody = responseBody.replaceAll("\"", "");
		        return responseBody;
		    }
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String get(String url) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		url = url.replaceAll(" ", "%20");
		HttpGet httpGet = new HttpGet("http://localhost:5000/"+url);
		httpGet.setHeader("Content-type", "application/json");
		try {
			httpGet.getRequestLine();
			
			try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
		        StatusLine statusLine = response.getStatusLine();
		        System.out.println(statusLine.getStatusCode() + " " + statusLine.getReasonPhrase());
		        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
		        System.out.println("Response body: " + responseBody);
		        return responseBody;
		    }
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
