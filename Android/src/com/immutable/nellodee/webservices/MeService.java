package com.immutable.nellodee.webservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.immutable.nellodee.user.BasicProfile;


public class MeService {
    private String url;
    private CookieStore cookies;


    public MeService() {
		super();
		this.url = "";
		this.cookies = new CookieStore() {
			
			public List<Cookie> getCookies() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public boolean clearExpired(Date date) {
				// TODO Auto-generated method stub
				return false;
			}
			
			public void clear() {
				// TODO Auto-generated method stub
				
			}
			
			public void addCookie(Cookie cookie) {
				// TODO Auto-generated method stub
				
			}
		};
	}
    
	public MeService(String url, CookieStore cookies) {
		super();
		this.url = url;
		this.cookies = cookies;
	}

	public BasicProfile callService(){
		
		int status;
		HttpResponse response;
		HttpGet requestGET = new HttpGet();
		BufferedReader in = null;
		BasicProfile basic = new BasicProfile();
		
		Log.i("ME SERVICE", "Saved URL: " + url);
		String uri = url + "/system/me";
		Log.i("ME SERVICE", "Service URL: " + uri);
		try {
			requestGET.setURI(new URI(uri));
			DefaultHttpClient client  = new DefaultHttpClient();
			
			CookieStore store = cookies;
			client.setCookieStore(store);

			response = client.execute(requestGET);
			status = response.getStatusLine().getStatusCode();
			Log.i("ME SERVICE","Status: "+ status);
			
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer();
			String line= "";
			String NL = System.getProperty("line.separator");
			while ((line=in.readLine())!=null){
				sb.append(line+NL);
			}
			in.close();
			String jString = sb.toString();
			System.out.println("JSON:" + jString);

			
	    	/* Parse JSON String and populate Basic Profile */
			JSONObject jObject;
			jObject = new JSONObject(jString); 
			JSONObject userObject = jObject.getJSONObject("user");
			basic.setUsername(userObject.getString("userid"));
			
			JSONObject propertiesObject = userObject.getJSONObject("properties");
			basic.setFirstName(propertiesObject.getString("firstName"));
			basic.setLastName(propertiesObject.getString("lastName"));
			basic.setPrefName(propertiesObject.getString("preferredName"));
			basic.setEmail(propertiesObject.getString("email"));
			basic.setDepartment(propertiesObject.getString("department"));
			basic.setCollege(propertiesObject.getString("college"));
			basic.setTags(propertiesObject.getString("tags"));
			
			return basic;
		
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
