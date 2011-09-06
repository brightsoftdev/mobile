package org.sakaiproject.nellodee.webservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.sakaiproject.nellodee.user.AboutMe;
import org.sakaiproject.nellodee.user.BasicProfile;

import android.util.Log;



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

	public BasicProfile basicProfileService(){
		
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
			String userStoragePrefix = userObject.has("userStoragePrefix") ? userObject.getString("userStoragePrefix") : "";

			
			JSONObject propertiesObject = userObject.getJSONObject("properties");
			System.out.println("JSON:" + propertiesObject.toString());

			
			basic.setFirstName(propertiesObject.has("firstName") ? propertiesObject.getString("firstName") : "");
			basic.setLastName(propertiesObject.has("lastName") ? propertiesObject.getString("lastName") : "");
			basic.setPrefName(propertiesObject.has("preferredName") ? propertiesObject.getString("preferredName") : "");
			basic.setEmail(propertiesObject.has("email") ? propertiesObject.getString("email") : "");
			basic.setRol(propertiesObject.has("role") ? propertiesObject.getString("role") : "");			
			String pic = propertiesObject.has("picture") ? propertiesObject.getString("picture") : "";

			if (pic.length()>1 && userStoragePrefix.length()>1){
				Pattern p = Pattern.compile("name.{3}[a-zA-Z_0-9]+.[a-zA-Z]{3}");
		    	Matcher m = p.matcher(pic);
		    	String picture="";
				if (m.find())
					picture = m.group(0);
				picture = picture.substring(7);
				Log.i("[ME SERVICE]", userStoragePrefix);
				Log.i("[ME SERVICE]", picture);
				
				String picPath = userStoragePrefix + "public/profile/" + picture;
				basic.setPicPath(picPath);
			}
		    basic.setDepartment(propertiesObject.has("department") ? propertiesObject.getString("department") : "");
			basic.setCollege(propertiesObject.has("college") ? propertiesObject.getString("college") : "");
			basic.setTags(propertiesObject.has("sakai:tags") ? propertiesObject.getString("sakai:tags") : "");
			
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
	
	public AboutMe aboutMeService(){
		
		int status;
		HttpResponse response;
		HttpGet requestGET = new HttpGet();
		BufferedReader in = null;
		AboutMe about = new AboutMe();
		
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
			JSONObject aboutMeProfileObject = jObject.getJSONObject("profile").getJSONObject("aboutme").getJSONObject("elements");
			
			if(aboutMeProfileObject.has("aboutme")){
				JSONObject aboutMeObject = aboutMeProfileObject.getJSONObject("aboutme");
				about.setAboutMe(aboutMeObject.has("value") ? aboutMeObject.getString("value") : "");
			}
			else{
				about.setAboutMe("");
			}
			
			if (aboutMeProfileObject.has("academicinterests")){
				JSONObject academicInterestsObject = aboutMeProfileObject.getJSONObject("academicinterests");
				about.setAcademicInterests(academicInterestsObject.has("value") ? academicInterestsObject.getString("value") : "");
			}
			else{
				about.setAcademicInterests("");
			}
			
			if (aboutMeProfileObject.has("personalinterestsObject")){
				JSONObject PersonalInterestsObject = aboutMeProfileObject.getJSONObject("personalinterestsObject");
				about.setPersonalInterests(PersonalInterestsObject.has("value") ? PersonalInterestsObject.getString("value") : "");
			}
			else{
				about.setPersonalInterests("");
			}
			
			if (aboutMeProfileObject.has("hobbies")){
				JSONObject hobbiesObject = aboutMeProfileObject.getJSONObject("hobbies");
				about.setHobbies(hobbiesObject.has("value") ? hobbiesObject.getString("value") : "");
			}
			else{
				about.setHobbies("");
			}
			
			
			return about;
			
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
