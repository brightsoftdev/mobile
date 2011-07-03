package com.immutable.nellodee.user;

import java.util.ArrayList;
import java.util.Date;

public class Properties {
	private String lastName;
	private Date lastModified;
	private String locale;
	private int contentCount;
	private int contactsCount;
	private String type;
	private String countLastUpdate;  //What format should have?
	private String timezone;
	private String createdBy;
	private Date created;
	private String email;
	private String name;
	private String lastModifiedBy;
	private String firstName;
	private int membershipsCount;

	
	public Properties() {
		super();
		this.lastName = "";
		this.lastModified = new Date();
		this.locale = "";
		this.contentCount = -1;
		this.contactsCount = -1;
		this.type = "";
		this.countLastUpdate = "";
		this.timezone = "";
		this.createdBy = "";
		this.created = new Date();
		this.email = "";
		this.name = "";
		this.lastModifiedBy = "";
		this.firstName = "";
		this.membershipsCount = -1;

	}
	
	public Properties(String lastName, Date lastModified, String localeString,
			int contentCount, int contactsCount, String type,
			String countLastUpdate, String timezone, String createdBy,
			Date created, String email, String name, String lastModifiedBy,
			String firstName, int membershipsCount, ArrayList<String> subjects,
			Locale locale) {
		super();
		this.lastName = lastName;
		this.lastModified = lastModified;
		this.locale = localeString;
		this.contentCount = contentCount;
		this.contactsCount = contactsCount;
		this.type = type;
		this.countLastUpdate = countLastUpdate;
		this.timezone = timezone;
		this.createdBy = createdBy;
		this.created = created;
		this.email = email;
		this.name = name;
		this.lastModifiedBy = lastModifiedBy;
		this.firstName = firstName;
		this.membershipsCount = membershipsCount;

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public int getContentCount() {
		return contentCount;
	}

	public void setContentCount(int contentCount) {
		this.contentCount = contentCount;
	}

	public int getContactsCount() {
		return contactsCount;
	}

	public void setContactsCount(int contactsCount) {
		this.contactsCount = contactsCount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountLastUpdate() {
		return countLastUpdate;
	}

	public void setCountLastUpdate(String countLastUpdate) {
		this.countLastUpdate = countLastUpdate;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getMembershipsCount() {
		return membershipsCount;
	}

	public void setMembershipsCount(int membershipsCount) {
		this.membershipsCount = membershipsCount;
	}
	
	

}
