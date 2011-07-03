package com.immutable.nellodee.activities;


import com.immutable.nellodee.NellodeeApplication;
import com.immutable.nellodee.R;
import com.immutable.nellodee.R.id;
import com.immutable.nellodee.R.layout;
import com.immutable.nellodee.auth.Authorization;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LogInActivity extends Activity {

	private AlertDialog alertDialog;
	private Button loginButton;
	private CheckBox rememberButton;
	private SharedPreferences settings;
	private NellodeeApplication app;


	/** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //app = (NellodeeApplication) this.getApplication();
        //System.out.println(app.getPrefsName());
        setContentView(R.layout.authorization);
        Log.v("LOG IN:","set login activity");
    }
    
    protected void onResume() {
		super.onResume();
        loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(onLogin);

	}
 
    
    private View.OnClickListener onLogin = new View.OnClickListener() {
		public void onClick(View v) {
			EditText username_EditText = (EditText) findViewById(R.id.username);
			EditText password_EditText = (EditText) findViewById(R.id.password);
			String username = username_EditText.getText().toString();
			String password = password_EditText.getText().toString();
			Log.v("CREDENTIALS: ", "Clicked the sign in button. This is the username: "+ username+ " and pass:" + password);

			
			if(username_EditText == null || password_EditText == null){
				notLogin();
            }else{
            	Authorization auth = new Authorization();
            	try {
            		auth.formBasedAuth();
            	} catch (Exception e) {
            		e.printStackTrace();
            	}
			}
		}
	};
	
	public void  notLogin(){
		alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle("Not login");
		alertDialog.setMessage("There are missing fields");
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
             public void onClick(DialogInterface dialog, int which) {
                     return;
             }
         }); 
		alertDialog.show();

	}
  
}