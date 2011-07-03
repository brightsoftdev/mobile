package com.immutable.nellodee.user;

public class BasicProfile {
	private String access;
	private Elements elements;
	
	public BasicProfile() {
		super();
		this.access = "";
		this.elements = new Elements();
	}
	
	public BasicProfile(String access, Elements elements) {
		super();
		this.access = access;
		this.elements = elements;
	}
	
	
}
