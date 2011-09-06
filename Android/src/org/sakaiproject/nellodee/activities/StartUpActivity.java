package org.sakaiproject.nellodee.activities;


import org.sakaiproject.nellodee.NellodeeApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


public class StartUpActivity extends Activity {

	private NellodeeApplication app;	

	/* Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		app = new NellodeeApplication();
	}

	protected void onResume() {
 		super.onResume();
		if(app.isFirstTime(this.getApplicationContext())){
			Log.i("START UP", "This is the first time");
			beginConfig();
		}
		else{
			Log.i("START UP", "This is NOT the first time");
			beginAuthorization();
		}
		
	}
 
	/* ACTIVITIES */
	private void beginConfig(){
		Intent intent = new Intent(this,UrlActivity.class);
		startActivity(intent);
	}
	
	private void beginAuthorization() {
		Intent intent = new Intent(this,LogInActivity.class);
		startActivity(intent);
	}
	
	/*
	 *  This method should be created when the app could store the user's credentials
	 *  
	 * private void beginSakai() throws Exception{
	 
		Intent intent = new Intent(this,LogInActivity.class);
		startActivity(intent);
	}*/


 
}