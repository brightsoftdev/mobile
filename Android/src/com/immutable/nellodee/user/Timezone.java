package com.immutable.nellodee.user;

public class Timezone {
	private String name;
	private int GMT;
	
	public Timezone() {
		super();
		this.name = "";
		GMT = 0;
	}
	
	public Timezone(String name, int gMT) {
		super();
		this.name = name;
		GMT = gMT;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGMT() {
		return GMT;
	}
	public void setGMT(int gMT) {
		GMT = gMT;
	}

}
