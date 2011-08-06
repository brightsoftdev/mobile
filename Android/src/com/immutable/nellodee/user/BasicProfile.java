package com.immutable.nellodee.user;

import java.util.ArrayList;

public class BasicProfile {
	private String firstName;
	private String lastName;
	private String prefName;
	private String email;
	private String rol;
	private String department;
	private String college;
	private ArrayList<String> tags;

	public BasicProfile() {
		super();
		this.firstName = "";
		this.lastName = "";
		this.prefName = "";
		this.email = "";
		this.rol = "";
		this.department = "";
		this.college = "";
		this.tags = new ArrayList<String>();
	}
	
	public BasicProfile(String firstName, String lastName, String prefName,
			String email, String rol, String department, String college,
			ArrayList<String> tags) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.prefName = prefName;
		this.email = email;
		this.rol = rol;
		this.department = department;
		this.college = college;
		this.tags = tags;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPrefName() {
		return prefName;
	}

	public void setPrefName(String prefName) {
		this.prefName = prefName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	
	
}
