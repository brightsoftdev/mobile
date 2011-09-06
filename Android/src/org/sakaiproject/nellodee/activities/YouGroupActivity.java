package org.sakaiproject.nellodee.activities;

import com.immutable.nellodee.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class YouGroupActivity extends TabGroupActivity {
	
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	startChildActivity(getPackageName(), new Intent(this,YouMenuActivity.class));
    	
    }


    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	menu.clear();
        return  getLocalActivityManager().getCurrentActivity().onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        return getLocalActivityManager().getCurrentActivity().onMenuItemSelected(featureId, item);
    }
     
    
    
}
