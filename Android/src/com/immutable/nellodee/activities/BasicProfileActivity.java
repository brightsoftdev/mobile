package com.immutable.nellodee.activities;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.client.CookieStore;

import com.immutable.nellodee.NellodeeApplication;
import com.immutable.nellodee.R;
import com.immutable.nellodee.Rols;
import com.immutable.nellodee.user.BasicProfile;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class BasicProfileActivity extends Activity {
	private NellodeeApplication app;
	private BasicProfile basic;

	/** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = ((NellodeeApplication)getApplication());
        
        View viewToLoad = LayoutInflater.from(this.getParent()).inflate(R.layout.basic_profile, null);
        this.setContentView(viewToLoad);  
        Log.v("BASIC PROFILE:","set Basic Profile activity");
    }

	protected void onResume() {
		super.onResume();

    	String url = app.getURL(app.getApplicationContext());
    	CookieStore cookies = app.getCookies();
    	
    	MeService me = new MeService(url,cookies);
  
    	
    	basic = me.basicProfileService();

    	Log.i("BASIC PROFILE", url+"/"+basic.getPicPath());
    	if(basic.getPicPath().length()<1){
            ImageView image = (ImageView) findViewById(R.id.profile_pic);
            Bitmap defaultIcon = BitmapFactory.decodeResource(getResources(), R.drawable.default_icon);
            image.setImageBitmap(defaultIcon);
    	}
    	else{
    		Drawable image = ImageOperations(url+"/"+basic.getPicPath());
			ImageView imgView = new ImageView(this);
			imgView = (ImageView)findViewById(R.id.profile_pic);
			imgView.setImageDrawable(image);
    	}   	
    	EditText firstNameET = (EditText) findViewById(R.id.firstNameET);
    	firstNameET.setText(basic.getFirstName());
    	EditText lastNameET = (EditText) findViewById(R.id.lastNameET);
    	lastNameET.setText(basic.getLastName());
    	EditText prefNameET = (EditText) findViewById(R.id.prefNameET);
    	prefNameET.setText(basic.getPrefName());
    	
    	EditText usernameET = (EditText) findViewById(R.id.usernameET);
    	usernameET.setText(basic.getUsername());
		EditText emailET = (EditText) findViewById(R.id.emailET);
		emailET.setText(basic.getEmail());
		
		//BUG! There is an error when the user clicks on the spinner, because it is inside a activitygroup
		Spinner s = (Spinner) findViewById(R.id.rolSP);
	    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.rols, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    s.setAdapter(adapter);
	    ArrayList<String> rols = app.getData().getRols().getTags();
	    if(basic.getRol()!=""){
	    	if(rols.contains(basic.getRol())){
	    		s.setSelection(rols.indexOf(basic.getRol())+1);
	    	}
	    }
	    else{
	    	s.setSelection(0);
	    }
	    //s.setOnItemSelectedListener(new MyOnItemSelectedListener());
	    
		EditText departmentET = (EditText) findViewById(R.id.departmentET);
		departmentET.setText(basic.getDepartment());
    	EditText collegeET = (EditText) findViewById(R.id.colllegeET);
    	collegeET.setText(basic.getCollege());
    	
    	EditText tagsET = (EditText) findViewById(R.id.tagsET);
    	tagsET.setText(basic.getTags());
    	
	}

	private Drawable ImageOperations(String url) {
		try {
			InputStream is = (InputStream) this.fetch(url);
			Drawable d = Drawable.createFromStream(is, "src");
			return d;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Object fetch(String address) throws MalformedURLException,IOException {
		URL url = new URL(address);
		Object content = url.getContent();
		return content;
	}
	
    
    public boolean onCreateOptionsMenu(Menu menu) {
    	menu.clear();
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.basic_menu, menu); 
        return true;
    }
 
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        //handle on menu item selected here
        //do not call super.onMenuItemSelected(featureId, item) here
 
        return true;
    }
    
    /*public class MyOnItemSelectedListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        	Toast.makeText(parent.getContext(), "The planet is " +
        	parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
        }

        public void onNothingSelected(AdapterView parent) {
          // Do nothing.
        }


    }*/
}
