package org.sakaiproject.nellodee.activities;

import org.sakaiproject.nellodee.NellodeeApplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.immutable.nellodee.R;

public class EditSettingsActivity extends PreferenceActivity {
	private SharedPreferences prefs;
	private NellodeeApplication app;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		app = ((NellodeeApplication)getApplicationContext());

		addPreferencesFromResource(R.xml.settings);
	}

}
