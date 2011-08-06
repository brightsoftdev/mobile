package com.immutable.nellodee.user;

public class AboutMe {
	private String about;
	private String academicInterests;
	private String personalInterests;
	private String hobbies;
	
	
	public AboutMe() {
		super();
		this.about = "";
		this.academicInterests = "";
		this.personalInterests = "";
		this.hobbies = "";
	}
	
	public AboutMe(String about, String academicInterests,
			String personalInterests, String hobbies) {
		super();
		this.about = about;
		this.academicInterests = academicInterests;
		this.personalInterests = personalInterests;
		this.hobbies = hobbies;
	}
	
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getAcademicInterests() {
		return academicInterests;
	}
	public void setAcademicInterests(String academicInterests) {
		this.academicInterests = academicInterests;
	}
	public String getPersonalInterests() {
		return personalInterests;
	}
	public void setPersonalInterests(String personalInterests) {
		this.personalInterests = personalInterests;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
}
