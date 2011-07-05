package com.immutable.nellodee;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class NellodeeApplication extends Application {

	private static final String PREFS_NAME = "SakaiPrefs";
	private DefaultHttpClient client;
	private CookieStore store;
	
	
	public NellodeeApplication() {
		this.client = new DefaultHttpClient();
		this.store = new BasicCookieStore();
	}

	public DefaultHttpClient getClient() {
		return client;
	}

	public void setClient(DefaultHttpClient client) {
		this.client = client;
	}

	public CookieStore getStore() {
		return store;
	}

	public void setStore(CookieStore store) {
		this.store = store;
	}
	public static String getPrefsName() {
		return PREFS_NAME;
	}
	
	
	/* MANAGE PREFERENCES */
	public boolean isFirstTime(Context context) {
		return context.getSharedPreferences(getPrefsName(),MODE_PRIVATE).getBoolean("first", true);
    }

	public boolean isSavedUser(Context context) {
		return context.getSharedPreferences(getPrefsName(),MODE_PRIVATE).getBoolean("savedUser", false);
    }
	
	public String getURL(Context context) {
		return context.getSharedPreferences(getPrefsName(),MODE_PRIVATE).getString("url", "");
    }

}
