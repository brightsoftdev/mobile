package com.immutable.nellodee.auth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.net.Credentials;
import android.util.Log;

public class Authorization {

    
	public void formBasedAuth() throws Exception{
		
		DefaultHttpClient client = new DefaultHttpClient();
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
					    
			//Add referer
			request.addHeader("Referer", "http://10.211.55.2:8080");
			
			HttpResponse response = client.execute(request);
			int status = response.getStatusLine().getStatusCode();
			Log.i("STATUS", String.valueOf(status));
			

			List<Cookie> cookies = client.getCookieStore().getCookies();
			CookieStore store = new BasicCookieStore();
			if (cookies.isEmpty()) {
                Log.i("COOKIES", "None");
            } else {
                for (int i = 0; i < cookies.size(); i++) {
                	store.addCookie(cookies.get(i));
                    Log.i("COOKIES","- " + cookies.get(i).toString());
                }
            }
			client.setCookieStore(store);
			
			HttpGet requestGET = new HttpGet();
			requestGET.setURI(new URI("http://10.211.55.2:8080/system/me"));
			response = client.execute(requestGET);
			System.out.println("STATUS: " + status);
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
	}
	
	
	public void me() throws Exception{
		
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet();
		BufferedReader in = null;
		try{
			/*new Uri.Builder()
		    .scheme("http")
		    .authority("foo.com")
		    .path("someservlet")
		    .appendQueryParameter("param1", foo)
		    .appendQueryParameter("param2", bar)
		    .build();
			*/
			request.setURI(new URI("http://10.211.55.2:8080/system/me"));
			request.getParams().setParameter("uid", "ada");
		
			HttpResponse response = client.execute(request);
			int status = response.getStatusLine().getStatusCode();
			System.out.println("STATUS: " + status);
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
