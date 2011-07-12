package com.immutable.nellodee.activities;


import com.immutable.nellodee.NellodeeApplication;
import com.immutable.nellodee.R;
import com.immutable.nellodee.R.id;
import com.immutable.nellodee.R.layout;
import com.immutable.nellodee.auth.Authorization;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class StartUpActivity extends Activity {

	private AlertDialog alertDialog;
	private NellodeeApplication app;	

	/* Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		app = new NellodeeApplication();
	}

	protected void onResume() {
 		super.onResume();
		if(app.isFirstTime(this.getApplicationContext())){
			beginConfig();
		}
		else{
			beginAuthorization();
		}
		/*else if (!app.isSavedUser()){
			beginAuthorization();
		}
		else{
			try {
				beginSakai();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		
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
	
	private void beginSakai() throws Exception{
		Intent intent = new Intent(this,LogInActivity.class);
		startActivity(intent);
	}


 
}