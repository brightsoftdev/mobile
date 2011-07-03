package com.immutable.nellodee.contacts;

public class Contacts {
	private int accepted;
	private int pending;
	private int invited;
	
	public Contacts() {
		super();
		this.accepted = -1;
		this.pending = -1;
		this.invited = -1;
	}
	
	public Contacts(int accepted, int pending, int invited) {
		super();
		this.accepted = accepted;
		this.pending = pending;
		this.invited = invited;
	}

	public int getAccepted() {
		return accepted;
	}

	public void setAccepted(int accepted) {
		this.accepted = accepted;
	}

	public int getPending() {
		return pending;
	}

	public void setPending(int pending) {
		this.pending = pending;
	}

	public int getInvited() {
		return invited;
	}

	public void setInvited(int invited) {
		this.invited = invited;
	}
}
