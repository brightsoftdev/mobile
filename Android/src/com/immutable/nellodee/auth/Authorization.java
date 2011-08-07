package com.immutable.nellodee.auth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
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

import com.immutable.nellodee.NellodeeApplication;

import android.net.Credentials;
import android.util.Log;

public class Authorization {

    private String url;
    private String user;
    private String pass;
    
	public Authorization() {
		super();
		this.url = "";
		this.user = "";
		this.pass = "";
	}
    
	public Authorization(String url, String user, String pass) {
		super();
		this.url = url;
		this.user = user;
		this.pass = pass;
	}


	public boolean formBasedAuth(NellodeeApplication app) throws Exception{
		DefaultHttpClient client  = new DefaultHttpClient();
		HttpPost request = new HttpPost();
		//BufferedReader in = null;
		//try{
			Log.i("URL",url);
			
			String uri = url + "/system/sling/formlogin";
			Log.i("URL",uri);
			request.setURI(new URI(uri));
			
			List<NameValuePair> postParameters = new ArrayList<NameValuePair>(); 

			postParameters.add(new BasicNameValuePair("sakaiauth:un", user)); 
			postParameters.add(new BasicNameValuePair("sakaiauth:pw", pass)); 
			postParameters.add(new BasicNameValuePair("sakaiauth:login", "1")); 

			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(postParameters);
			request.setEntity(formEntity);
					    
			//Add referer
			request.addHeader("Referer", url);
			
			HttpResponse response = client.execute(request);
			int status = response.getStatusLine().getStatusCode();
			Log.i("STATUS", String.valueOf(status));
			
			//Store cookies
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
			
			if(status==200){
                Log.i("AUTH", "Working");
				return true;
			}
			else{
                Log.i("AUTH", "None");
				return false;
			}
			
			//Me service
			/*HttpGet requestGET = new HttpGet();
			uri = url + "/system/me";
			Log.i("URL",uri);
			requestGET.setURI(new URI(uri));
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
			String jString = sb.toString();
			System.out.println("JSON:" + jString);
			*/
			//Parse Json response 
			/*JSONObject jObject;
			jObject = new JSONObject(jString); 
			JSONObject userObject = jObject.getJSONObject("user");
			String userId = userObject.getString("userid");
			String userStoragePrefix = userObject.getString("userStoragePrefix");
			String userProfilePath = userObject.getString("userProfilePath");
			Boolean superUser = Boolean.parseBoolean(userObject.getString("superUser"));
			
			JSONObject propertiesObject = userObject.getJSONObject("properties");
			String lastName = propertiesObject.getString("lastName");
			Date lastModified = new Date(Long.parseLong(propertiesObject.getString("lastModified")));
			String locale = propertiesObject.getString("locale");
			int contentCount =Integer.parseInt(propertiesObject.getString("contentCount"));
			int contactsCount =Integer.parseInt(propertiesObject.getString("contactsCount"));
			String type = propertiesObject.getString("type");
			Date countLastUpdate = new Date(Long.parseLong(propertiesObject.getString("countLastUpdate")));
			String timezone = propertiesObject.getString("timezone");
			String createdBy = propertiesObject.getString("createdBy");
			Date created = new Date(Long.parseLong(propertiesObject.getString("created")));
			String email = propertiesObject.getString("email");
			String name = propertiesObject.getString("name");
			String lastModifiedBy = propertiesObject.getString("lastModifiedBy");
			String firstName = propertiesObject.getString("firstName");
			int membershipsCount =Integer.parseInt(propertiesObject.getString("membershipsCount"));


			//I don't know what is the purpose of this. Investigate! 
			String eventbus = jObject.getString("eventbus");

			JSONObject profileObject = jObject.getJSONObject("profile");
			String sling_resourceType = profileObject.getString("sling:resourceType");
			String hash = profileObject.getString("hash");
			JSONObject basicObject = profileObject.getJSONObject("basic");
			String access = basicObject.getString("access");
			JSONObject elementsObject = basicObject.getJSONObject("elements");
			String e_lastName = elementsObject.getString("lastName");
			String e_email = elementsObject.getString("email");
			String e_firstName = elementsObject.getString("firstName");
			String rep_userId = profileObject.getString("rep:userId");
			String userid = profileObject.getString("userid");
			JSONObject countsObject = profileObject.getJSONObject("counts");
			int p_contactsCount =Integer.parseInt(countsObject.getString("contactsCount"));
			int p_membershipsCount =Integer.parseInt(countsObject.getString("membershipsCount"));
			int p_contentCount =Integer.parseInt(countsObject.getString("contentCount"));
			Date p_countLastUpdate = new Date(Long.parseLong(countsObject.getString("countLastUpdate")));
			Boolean sakai_excludeSearch = Boolean.parseBoolean(profileObject.getString("sakai:excludeSearch"));
			String homePath = profileObject.getString("homePath");
			String _path = profileObject.getString("_path");

			JSONObject messagesObject = jObject.getJSONObject("messages");
			int unread =Integer.parseInt(messagesObject.getString("unread"));

			JSONObject contactsObject = jObject.getJSONObject("contacts");
			int accepted =Integer.parseInt(contactsObject.getString("accepted"));
			int pending =Integer.parseInt(contactsObject.getString("pending"));
			int invited =Integer.parseInt(contactsObject.getString("invited"));

			Log.i("JUSER", "User id: "+ userId + " - User Storage Prefix:" + userStoragePrefix + " - User Profile Path:" + userProfilePath);
			Log.i("JUSER", "super User: "+ superUser + " - last Name:" + lastName + " - lastModified:" + lastModified + " - locale: " + locale);
			Log.i("JUSER", "contentCount: "+ contentCount + " - contactsCount:" + contactsCount + " - type:" + type);
			Log.i("JUSER", "countLastUpdate: "+ countLastUpdate + " - timezone:" + timezone + " - createdBy:" + createdBy);
			Log.i("JUSER", "created: "+ created + " - email:" + email + " - name:" + name);
			Log.i("JUSER", "lastModifiedBy: "+ lastModifiedBy + " - firstName:" + firstName + " - membershipsCount:" + membershipsCount);
			Log.i("JUSER", "eventbus: "+ eventbus );
			Log.i("JUSER", "sling_resourceType:" + sling_resourceType + " - hash:" + hash);
			Log.i("JUSER", "access: "+ access + " - elastName:" + e_lastName + " - eemail:" + e_email);
			Log.i("JUSER", "efirstName: "+ e_firstName + " - rep_userId:" + rep_userId + " - userid:" + userid);
			Log.i("JUSER", "pcontactsCount: "+ p_contactsCount + " - pmembershipsCount:" + p_membershipsCount + " - p_contentCount:" + p_contentCount);
			Log.i("JUSER", "p_countLastUpdate: "+ p_countLastUpdate + " - sakai_excludeSearch:" + sakai_excludeSearch + " - homePath:" + homePath);
			Log.i("JUSER", "_path: "+ _path + " - unread:" + unread + " - accepted:" + accepted);
			Log.i("JUSER", "pending: "+ pending + " - invited:" + invited );
			*/
			
			
		/*}
		finally{
			if(in!=null){
				try{
					in.close();
				} 
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}*/
	}
	
	
	public void meService() throws Exception{
		
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
