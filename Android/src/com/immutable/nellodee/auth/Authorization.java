package com.immutable.nellodee.auth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.net.Credentials;

public class Authorization {

    
	public void formBasedAuth() throws Exception{
		
		HttpClient client = new DefaultHttpClient();
		HttpPost request = new HttpPost();
		BufferedReader in = null;
	try{
		request.setURI(new URI("http://10.211.55.2:8080/system/sling/formlogin"));
		List<NameValuePair> postParameters = new ArrayList<NameValuePair>(); 

		postParameters.add(new BasicNameValuePair("sakaiauth:un", "ada")); 
		postParameters.add(new BasicNameValuePair("sakaiauth:pw", "babagge")); 
		postParameters.add(new BasicNameValuePair("sakaiauth:login", "1")); 

		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(postParameters);
		request.setEntity(formEntity);
		
		
		HttpResponse response = client.execute(request);
		int status = response.getStatusLine().getStatusCode();
		System.out.println("STATUS" + status);
		in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer sb = new StringBuffer();
		String line= "";
		String NL = System.getProperty("line.separator");
		while ((line=in.readLine())!=null){
			sb.append(line+NL);
		}
		in.close();
		String page = sb.toString();
		System.out.println(page);
	}
	finally{
		if(in!=null){
			try{
				in.close();
			} 
			catch(IOException e){
				e.printStackTrace();
			}
		}

	}
	
	
	/*public void executeHttpGet() throws Exception{
		BufferedReader in = null;
		HttpHost targetHost = new HttpHost("10.211.55.2", 8080, "http");
		try{
			
			//HttpClient client = new DefaultHttpClient();
			
			UsernamePasswordCredentials creds = new UsernamePasswordCredentials("ada", "babagge");
			
			DefaultHttpClient httpclient = new DefaultHttpClient();
			httpclient.getCredentialsProvider().setCredentials(new AuthScope(targetHost.getHostName(),targetHost.getPort()), creds);
			HttpGet request = new HttpGet("http://10.211.55.2:8080/system/me");

			
			//HttpPost post=new HttpPost("http://10.211.55.2:8080/system/me");
			//post.addHeader("Authorization", "Basic "+Base64.encodeBytes(("ada"+":"+"babagge").getBytes()));
			
			//Test for get
			//HttpGet request = new HttpGet();
			//request.setURI(new URI("http://10.211.55.2:8080/dev/explore.html"));
			
			/*HttpPost request = new HttpPost();
			request.setURI(new URI("http://10.211.55.2:8080/system/sling/formlogin"));
			List<NameValuePair> postParameters = new ArrayList<NameValuePair>(); 

			postParameters.add(new BasicNameValuePair("sakaiauth:un", "ada")); 
			postParameters.add(new BasicNameValuePair("sakaiauth:pw", "babagge")); 
			postParameters.add(new BasicNameValuePair("sakaiauth:login", "1")); 

			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(postParameters);
			request.setEntity(formEntity);
			
			
			//HttpResponse response = client.execute(request);
			HttpResponse response = httpclient.execute(request);
			int status = response.getStatusLine().getStatusCode();
			System.out.println("STATUS" + status);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer();
			String line= "";
			String NL = System.getProperty("line.separator");
			while ((line=in.readLine())!=null){
				sb.append(line+NL);
			}
			in.close();
			String page = sb.toString();
			System.out.println(page);
		}
		finally{
			if(in!=null){
				try{
					in.close();
				} 
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
			
	}*/
	
	
}
