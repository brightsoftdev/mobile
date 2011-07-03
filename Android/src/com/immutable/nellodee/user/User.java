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
	private String eventbus;
	private Profile profile;
	private Messages messages;
	private Contacts contacts;
	private ArrayList<String> groups;
	

	public User() {
		super();
		this.userid = "";
		this.userStoragePrefix = "";
		this.userProfilePath = "";
		this.superUser = false;
		this.properties = new Properties();
		this.eventbus = "";
		this.profile = new Profile();
		this.messages = new Messages();
		this.contacts = new Contacts();
		this.groups = new ArrayList<String>();
	}
	
	public User(String userid, String userStoragePrefix,
			String userProfilePath, Boolean superUser, Properties properties,
			String eventbus, Profile profile, Messages messages,
			Contacts contacts, ArrayList<String> groups) {
		super();
		this.userid = userid;
		this.userStoragePrefix = userStoragePrefix;
		this.userProfilePath = userProfilePath;
		this.superUser = superUser;
		this.properties = properties;
		this.eventbus = eventbus;
		this.profile = profile;
		this.messages = messages;
		this.contacts = contacts;
		this.groups = groups;
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

	public String getEventbus() {
		return eventbus;
	}

	public void setEventbus(String eventbus) {
		this.eventbus = eventbus;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Messages getMessages() {
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}

	public Contacts getContacts() {
		return contacts;
	}

	public void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}

	public ArrayList<String> getGroups() {
		return groups;
	}

	public void setGroups(ArrayList<String> groups) {
		this.groups = groups;
	} 
	

}
