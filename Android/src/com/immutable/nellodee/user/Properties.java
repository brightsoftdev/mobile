package com.immutable.nellodee.user;

import java.util.ArrayList;
import java.util.Date;

public class Properties {
	private String lastName;
	private Date lastModified;
	private String localeString;
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
	private ArrayList<String> subjects;
	private Locale locale;
	
	public Properties() {
		super();
		this.lastName = "";
		this.lastModified = new Date();
		this.localeString = "";
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
		this.subjects = new ArrayList<String>();
		this.locale = new Locale();
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
		this.localeString = localeString;
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
		this.subjects = subjects;
		this.locale = locale;
	}
	
	

}
