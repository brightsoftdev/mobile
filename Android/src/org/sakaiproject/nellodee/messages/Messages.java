package org.sakaiproject.nellodee.messages;

public class Messages {
	private int unread;

	
	public Messages() {
		super();
		this.unread = -1;
	}
	public Messages(int unread) {
		super();
		this.unread = unread;
	}
	
	public int getUnread() {
		return unread;
	}
	
	public void setUnread(int unread) {
		this.unread = unread;
	}

}
