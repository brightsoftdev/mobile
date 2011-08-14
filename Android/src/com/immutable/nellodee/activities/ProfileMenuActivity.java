package com.immutable.nellodee.activities;

import com.immutable.nellodee.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
		aboutMeButton.setOnClickListener(onBasicInfo);
		
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
	

}
