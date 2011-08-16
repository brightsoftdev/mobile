package com.immutable.nellodee.activities;

import java.util.ArrayList;

import org.apache.http.client.CookieStore;

import com.immutable.nellodee.NellodeeApplication;
import com.immutable.nellodee.R;
import com.immutable.nellodee.user.AboutMe;
import com.immutable.nellodee.webservices.MeService;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class AboutMeActivity extends Activity {
	private NellodeeApplication app;
	private AboutMe about;

	/** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = ((NellodeeApplication)getApplication());

        View viewToLoad = LayoutInflater.from(this.getParent()).inflate(R.layout.about_me, null);
        this.setContentView(viewToLoad);  
        Log.v("ABOUT ME","set About Me activity");
    }

	protected void onResume() {
		super.onResume();

    	String url = app.getURL(app.getApplicationContext());
    	CookieStore cookies = app.getCookies();
    	
    	MeService me = new MeService(url,cookies);
  
    	
    	about = me.aboutMeService();

    	
    	EditText aboutmeET = (EditText) findViewById(R.id.aboutMeET);
    	aboutmeET.setText(about.getAboutMe());
    	
    	EditText academicET = (EditText) findViewById(R.id.academicInterestsET);
    	academicET.setText(about.getAcademicInterests());

    	EditText personalET = (EditText) findViewById(R.id.personalInterestsET);
    	personalET.setText(about.getPersonalInterests());
    	
    	EditText hobbiesET = (EditText) findViewById(R.id.hobbiesET);
    	hobbiesET.setText(about.getAboutMe());
    	
    	Spinner spinner = (Spinner) findViewById(R.id.permissionsSP);

    	ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
    	            this, R.array.permissions_types, android.R.layout.simple_spinner_item);
    	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	    spinner.setAdapter(adapter);

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
