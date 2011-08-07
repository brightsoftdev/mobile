package com.immutable.nellodee.activities;

import com.immutable.nellodee.NellodeeApplication;
import com.immutable.nellodee.R;

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
	}
    
}
