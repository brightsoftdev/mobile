package com.immutable.nellodee.webservices;

import java.util.Date;
import java.util.List;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;

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
		Log.i("ME SERVICE", "Saved URL: " + url);
		HttpGet requestGET = new HttpGet();
		String uri = url + "/system/me";
		Log.i("ME SERVICE", "Service URL: " + uri);

		
		return null;
	}
	
	
	
	
	//Me service
	/*
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
