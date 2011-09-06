package org.sakaiproject.nellodee.user;

public class AboutMe {
	String aboutMe;
	String academicInterests;
	String personalInterests;
    String hobbies;
	
	
	public AboutMe() {
		super();
		this.aboutMe = "";
		this.academicInterests = "";
		this.personalInterests = "";
		this.hobbies = "";
	}
	
	public AboutMe(String about, String academicInterests,
			String personalInterests, String hobbies) {
		super();
		this.aboutMe = about;
		this.academicInterests = academicInterests;
		this.personalInterests = personalInterests;
		this.hobbies = hobbies;
	}
	
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String about) {
		this.aboutMe = about;
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
