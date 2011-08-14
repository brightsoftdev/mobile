package com.immutable.nellodee.activities;

import org.apache.http.client.CookieStore;

import com.immutable.nellodee.R;
import com.immutable.nellodee.auth.Authorization;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
	

public class YouMenuActivity extends Activity {
	private Button myMessagesButton;
	private Button myProfileButton;
	private Button myLibraryButton;
	private Button myMembershipButton;
	private Button myContactsButton;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.you_menu);
        Log.v("YOU MENU","set you menu activity");

	}

	protected void onResume() {
		super.onResume();
		
		myMessagesButton = (Button) findViewById(R.id.myMessagesButton);
		myMessagesButton.setOnClickListener(onMyMessages);
		
		myProfileButton = (Button) findViewById(R.id.myProfileButton);
		myProfileButton.setOnClickListener(onMyProfile);
		
		myLibraryButton = (Button) findViewById(R.id.myLibraryButton);
		myLibraryButton.setOnClickListener(onMyLibrary);
		
		myMembershipButton = (Button) findViewById(R.id.myMembershipButton);
		myMembershipButton.setOnClickListener(onMyMembership);
		
		myContactsButton = (Button) findViewById(R.id.myMessagesButton);
		myContactsButton.setOnClickListener(onMyContacts);
	}

	private View.OnClickListener onMyMessages = new View.OnClickListener() {
			public void onClick(View v) {
				loadMyMessages();		
			}
	};
	private void loadMyMessages(){
		Intent intent = new Intent(this,TabsActivity.class);
		startActivity(intent);
	}
	
	private View.OnClickListener onMyProfile = new View.OnClickListener() {
		public void onClick(View v) {
			loadMyProfile();		
		}
	};
	private void loadMyProfile(){
		
		Intent intent = new Intent(getParent(),ProfileMenuActivity.class);
		TabGroupActivity parentActivity = (TabGroupActivity)getParent();
		parentActivity.startChildActivity("PROFILE_MENU", intent);

	}
	
	private View.OnClickListener onMyLibrary = new View.OnClickListener() {
		public void onClick(View v) {
			loadMyLibrary();		
		}
	};
	private void loadMyLibrary(){
		Intent intent = new Intent(this,TabsActivity.class);
		startActivity(intent);
	}
	
	private View.OnClickListener onMyMembership = new View.OnClickListener() {
		public void onClick(View v) {
			loadMyMembership();		
		}
	};
	private void loadMyMembership(){
		Intent intent = new Intent(this,TabsActivity.class);
		startActivity(intent);
	}
	
	private View.OnClickListener onMyContacts = new View.OnClickListener() {
		public void onClick(View v) {
			loadMyContacts();		
		}
	};
	private void loadMyContacts(){
		Intent intent = new Intent(this,TabsActivity.class);
		startActivity(intent);
	}
}
