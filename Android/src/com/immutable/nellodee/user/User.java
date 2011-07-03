package com.immutable.nellodee.user;

import java.util.ArrayList;

import com.immutable.nellodee.contacts.Contacts;
import com.immutable.nellodee.messages.Messages;

public class User {
	private String userid;
	private String userStoragePrefix;
	private String userProfilePath;
	private Boolean superUser;
	private Properties properties;
	private ArrayList<String> subjects;
	private Locale locale;
		

	public User() {
		super();
		this.userid = "";
		this.userStoragePrefix = "";
		this.userProfilePath = "";
		this.superUser = false;
		this.properties = new Properties();
		this.subjects = new ArrayList<String>();
		this.locale = new Locale();

	}
	
	public User(String userid, String userStoragePrefix,
			String userProfilePath, Boolean superUser, Properties properties, 
			ArrayList<String> subjects, Locale locale) {
		super();
		this.userid = userid;
		this.userStoragePrefix = userStoragePrefix;
		this.userProfilePath = userProfilePath;
		this.superUser = superUser;
		this.properties = properties;
		this.subjects = subjects;
		this.locale = locale;

	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserStoragePrefix() {
		return userStoragePrefix;
	}

	public void setUserStoragePrefix(String userStoragePrefix) {
		this.userStoragePrefix = userStoragePrefix;
	}

	public String getUserProfilePath() {
		return userProfilePath;
	}

	public void setUserProfilePath(String userProfilePath) {
		this.userProfilePath = userProfilePath;
	}

	public Boolean getSuperUser() {
		return superUser;
	}

	public void setSuperUser(Boolean superUser) {
		this.superUser = superUser;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public ArrayList<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<String> subjects) {
		this.subjects = subjects;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}


}
