package com.immutable.nellodee.activities;


import com.immutable.nellodee.R;
import com.immutable.nellodee.R.id;
import com.immutable.nellodee.R.layout;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogInActivity extends Activity {

	/** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorization);
        Log.v("INI:","set login activity");
    }
    
    protected void onResume() {
		super.onResume();
        Button loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(onLogin);

	}
    
    private View.OnClickListener onLogin = new View.OnClickListener() {
		public void onClick(View v) {
			EditText username_EditText = (EditText) findViewById(R.id.username);
			EditText password_EditText = (EditText) findViewById(R.id.password);
			String username = username_EditText.getText().toString();
			String password = password_EditText.getText().toString();
			
			Log.v("CREDENTIALS: ", "Clicked the sign in button. This is the username: "+ username+ " and pass:" + password);
		}
	};
  
}