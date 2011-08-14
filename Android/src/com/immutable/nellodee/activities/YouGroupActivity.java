package com.immutable.nellodee.activities;

import android.content.Intent;
import android.os.Bundle;

public class YouGroupActivity extends TabGroupActivity {
	
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	startChildActivity(getPackageName(), new Intent(this,YouMenuActivity.class));
    	
    }
}
