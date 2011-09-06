package org.sakaiproject.nellodee.activities;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import com.immutable.nellodee.R;

public class TabsActivity extends TabActivity {
	
	private TabHost mTabHost;

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.tabs);

	    Resources res = getResources(); 
	    TabHost tabHost = getTabHost(); 
	    TabHost.TabSpec spec;  
	    Intent intent;  
	    
	    // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, YouGroupActivity.class);
	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("you")
	    			  .setIndicator(getString(R.string.you), res.getDrawable(R.drawable.user))
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    // Do the same for the other tabs
	    intent = new Intent().setClass(this, BasicProfileActivity.class);
	    spec = tabHost.newTabSpec("createAdd")
	    			  .setIndicator(getString(R.string.createAdd), res.getDrawable(R.drawable.pencil))
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    intent = new Intent().setClass(this, BasicProfileActivity.class);
	    spec = tabHost.newTabSpec("explore")
	    		.setIndicator(getString(R.string.explore),res.getDrawable(R.drawable.magnify))
	    		.setContent(intent);	
	    tabHost.addTab(spec);

	    tabHost.setCurrentTab(0);
	}
	
	/*public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}*/


}
