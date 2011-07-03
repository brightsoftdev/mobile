package com.immutable.nellodee.user;

import java.util.Date;

public class Counts {
	private int contactsCount;
	private int membershipsCount;
	private int contentCount;
	private Date countLastUpdate;	//This should be a Date or int?

	
	public Counts() {
		super();
		this.contactsCount = -1;
		this.membershipsCount = -1;
		this.contentCount = -1;
		this.countLastUpdate = new Date();
	}
	
	public Counts(int contactsCount, int membershipsCount, int contentCount,
			Date countLastUpdate) {
		super();
		this.contactsCount = contactsCount;
		this.membershipsCount = membershipsCount;
		this.contentCount = contentCount;
		this.countLastUpdate = countLastUpdate;
	}

	public int getContactsCount() {
		return contactsCount;
	}

	public void setContactsCount(int contactsCount) {
		this.contactsCount = contactsCount;
	}

	public int getMembershipsCount() {
		return membershipsCount;
	}

	public void setMembershipsCount(int membershipsCount) {
		this.membershipsCount = membershipsCount;
	}

	public int getContentCount() {
		return contentCount;
	}

	public void setContentCount(int contentCount) {
		this.contentCount = contentCount;
	}

	public Date getCountLastUpdate() {
		return countLastUpdate;
	}

	public void setCountLastUpdate(Date countLastUpdate) {
		this.countLastUpdate = countLastUpdate;
	}
	

}
