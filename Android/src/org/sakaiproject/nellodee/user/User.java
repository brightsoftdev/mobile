package org.sakaiproject.nellodee.user;

import java.util.ArrayList;

import org.sakaiproject.nellodee.contacts.Contacts;
import org.sakaiproject.nellodee.messages.Messages;


public class User {
	private String userid;
	private String userStoragePrefix;
	private String userProfilePath;
	private Boolean superUser;
	private ArrayList<String> subjects;
	private Locale locale;
		

	public User() {
		super();
		this.userid = "";
		this.userStoragePrefix = "";
		this.userProfilePath = "";
		this.superUser = false;
		this.subjects = new ArrayList<String>();
		this.locale = new Locale();

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
