package com.immutable.nellodee.activities;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.client.CookieStore;

import com.immutable.nellodee.NellodeeApplication;
import com.immutable.nellodee.R;
import com.immutable.nellodee.user.BasicProfile;
import com.immutable.nellodee.webservices.MeService;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class BasicProfileActivity extends Activity {
	private NellodeeApplication app;

	/** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = ((NellodeeApplication)getApplication());
        
        setContentView(R.layout.basic_profile);
        Log.v("BASIC PROFILE:","set Basic Profile activity");
    }

	protected void onResume() {
		super.onResume();

    	String url = app.getURL(app.getApplicationContext());
    	CookieStore cookies = app.getCookies();
    	
    	MeService me = new MeService(url,cookies);
  
    	
    	BasicProfile basic = me.callService();

    	Log.i("BASIC PROFILE", url+"/"+basic.getPicPath());
    	Drawable image = ImageOperations(url+"/"+basic.getPicPath());
		ImageView imgView = new ImageView(this);
		imgView = (ImageView)findViewById(R.id.profile_pic);
		imgView.setImageDrawable(image);
    	
    	TextView firstNameTV = (TextView) findViewById(R.id.txt_firstName);
    	firstNameTV.setText(basic.getFirstName());
    	TextView lastNameTV = (TextView) findViewById(R.id.txt_lastName);
    	lastNameTV.setText(basic.getLastName());
    	TextView prefNameTV = (TextView) findViewById(R.id.txt_prefName);
    	prefNameTV.setText(basic.getPrefName());
    	
    	TextView usernameTV = (TextView) findViewById(R.id.txt_userName);
		usernameTV.setText(basic.getUsername());
    	TextView emailTV = (TextView) findViewById(R.id.txt_email);
    	emailTV.setText(basic.getEmail());
    	
    	TextView rolTV = (TextView) findViewById(R.id.txt_rol);
    	rolTV.setText(basic.getRol());
    	TextView departmentTV = (TextView) findViewById(R.id.txt_department);
    	departmentTV.setText(basic.getDepartment());
    	TextView collegeTV = (TextView) findViewById(R.id.txt_college);
    	collegeTV.setText(basic.getCollege());
    	
    	TextView tagsTV = (TextView) findViewById(R.id.txt_tags);
    	tagsTV.setText(basic.getTags());
    	
	}

	private Drawable ImageOperations(String url) {
		try {
			InputStream is = (InputStream) this.fetch(url);
			Drawable d = Drawable.createFromStream(is, "src");
			return d;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Object fetch(String address) throws MalformedURLException,IOException {
		URL url = new URL(address);
		Object content = url.getContent();
		return content;
	}
    
}
