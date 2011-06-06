package com.immutable.nellodee.activities;

import com.immutable.nellodee.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartUp extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loging);
        
        Button loging = (Button) findViewById(R.id.login_button);
        loging.setOnClickListener(onLogin);
    }
   
    private View.OnClickListener onLogin = new View.OnClickListener() {
		public void onClick(View v) {
			EditText username = (EditText) findViewById(R.id.username);
			EditText password = (EditText) findViewById(R.id.password);			
		}
	};
    

}
