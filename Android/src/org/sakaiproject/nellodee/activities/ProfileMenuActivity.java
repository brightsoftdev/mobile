package org.sakaiproject.nellodee.activities;

import org.sakaiproject.nellodee.user.AboutMe;

import com.immutable.nellodee.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ProfileMenuActivity extends Activity {

	private Button basicInfoButton;
	private Button aboutMeButton;
	private Button categoriesButton;
	private Button publicationsButton;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		

		setContentView(R.layout.profile_menu);
        Log.v("PROFILE MENU","set profile menu activity");
	}

	protected void onResume() {
		super.onResume();
		
		basicInfoButton = (Button) findViewById(R.id.basicInfoButton);
		basicInfoButton.setOnClickListener(onBasicInfo);
		
		aboutMeButton = (Button) findViewById(R.id.aboutMeButton);
		aboutMeButton.setOnClickListener(onAboutMe);
		
		categoriesButton = (Button) findViewById(R.id.categoriesButton);
		categoriesButton.setOnClickListener(onBasicInfo);
		
		publicationsButton = (Button) findViewById(R.id.publicationsButton);
		publicationsButton.setOnClickListener(onBasicInfo);

	}
	
	
	private View.OnClickListener onBasicInfo = new View.OnClickListener() {
		public void onClick(View v) {
			loadBasicInfo();		
		}
	};
	private void loadBasicInfo(){
		
		Intent intent = new Intent(getParent(),BasicProfileActivity.class);
		TabGroupActivity parentActivity = (TabGroupActivity)getParent();
		parentActivity.startChildActivity("BASIC_INFO", intent);

	}
	
	private View.OnClickListener onAboutMe = new View.OnClickListener() {
		public void onClick(View v) {
			loadAboutMe();		
		}
	};
	private void loadAboutMe(){
		
		Intent intent = new Intent(getParent(),AboutMeActivity.class);
		TabGroupActivity parentActivity = (TabGroupActivity)getParent();
		parentActivity.startChildActivity("ABOUT_ME", intent);

	}
	
    public boolean onCreateOptionsMenu(Menu menu) {
    	menu.clear();
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.basic_menu, menu); 
        return true;
    }
 
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()){
		case R.id.settings:
			startActivity(new Intent(this, EditSettingsActivity.class));
			break;
		case R.id.about:
			break;
		case R.id.quit:
			System.exit(RESULT_OK);
			break;
		}
		return true;
     }

}
