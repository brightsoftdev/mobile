package com.immutable.nellodee.activities;

import org.apache.http.client.CookieStore;

import com.immutable.nellodee.NellodeeApplication;
import com.immutable.nellodee.R;
import com.immutable.nellodee.user.BasicProfile;
import com.immutable.nellodee.webservices.MeService;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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
    	
    	TextView usernameTV = (TextView) findViewById(R.id.txt_userName);
		usernameTV.setText("Mayte");
	}
    
}
