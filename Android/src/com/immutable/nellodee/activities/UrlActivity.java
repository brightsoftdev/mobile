package com.immutable.nellodee.activities;

import java.net.HttpURLConnection;
import java.net.URL;

import com.immutable.nellodee.NellodeeApplication;
import com.immutable.nellodee.R;
import com.immutable.nellodee.auth.Authorization;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//This activity controls the configuration of the url where sakai is hosted.
public class UrlActivity extends Activity {
	private Button nextButton;
	private SharedPreferences settings;
	private AlertDialog alertDialog;

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.url_config);
		nextButton = (Button)findViewById(R.id.url_button);
		nextButton.setOnClickListener(onURL);

	}
 
	/* Button Listener */
    private View.OnClickListener onURL = new View.OnClickListener() {
		public void onClick(View v) {
			EditText url_EditText = (EditText) findViewById(R.id.url);
			String url = url_EditText.getText().toString();
			Log.v("URL", url);
			
			if(url.equals("")){
				Log.e("URL", "There is no URL");
				noUrl(); 
            }else{
            	if(saveUrl(url)){
					Log.v("URL","Saved URL, begin Authorization");
					beginLogIn();
				}
			}
		}
	};
	
	private void beginLogIn() {
		Intent intent = new Intent(this,LogInActivity.class);
		startActivity(intent);
	}
	
	/* Handling URL */
	private Boolean saveUrl(String url){
		if (checkUrl(url)){
			settings = getSharedPreferences(NellodeeApplication.getPrefsName(), MODE_PRIVATE);
			SharedPreferences.Editor editor = settings.edit();
			editor.putString("url", url);
			editor.putBoolean("first", false);
			editor.commit();
			Log.w("URL","Url has been saved");
			return true;
		}
		else{
			Log.e("URL", "Url has not been saved");
			noValidUrl();
			return false;
		}
	}
	
	private Boolean checkUrl(String url) {
		try {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestMethod("HEAD");
			return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/* Alert windows */
	public void  noUrl(){
		alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle(R.string.noURL);
		alertDialog.setMessage(this.getString(R.string.noURL_message));
		alertDialog.setButton(this.getString(R.string.OK), new DialogInterface.OnClickListener() {
             public void onClick(DialogInterface dialog, int which) {
                     return;
             }
         }); 
		alertDialog.show();

	}

	public void  noValidUrl(){
		alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle(R.string.noValid);
		alertDialog.setMessage(this.getString(R.string.noValid_message));
		alertDialog.setButton(this.getString(R.string.OK), new DialogInterface.OnClickListener() {
             public void onClick(DialogInterface dialog, int which) {
                     return;
             }
         }); 
		alertDialog.show();

	}
}
