package com.immutable.nellodee.user;
 

public class Locale {
	private String country;
	private String displayCountry;
	private String displayLanguage;
	private String displayName;
	private String displayVariant;
	private String ISO3Country;
	private String ISO3Language;
	private String language;
	private String variant; 
	private Timezone timezone;
	
	
	public Locale() {
		super();
		this.country = "";
		this.displayCountry = "";
		this.displayLanguage = "";
		this.displayName = "";
		this.displayVariant = "";
		this.ISO3Country = "";
		this.ISO3Language = "";
		this.language = "";
		this.variant = "";
		this.timezone = new Timezone();
	}


	public Locale(String country, String displayCountry,
			String displayLanguage, String displayName, String displayVariant,
			String iSO3Country, String iSO3Language, String language,
			String variant, Timezone timezone) {
		super();
		this.country = country;
		this.displayCountry = displayCountry;
		this.displayLanguage = displayLanguage;
		this.displayName = displayName;
		this.displayVariant = displayVariant;
		this.ISO3Country = iSO3Country;
		this.ISO3Language = iSO3Language;
		this.language = language;
		this.variant = variant;
		this.timezone = timezone;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getDisplayCountry() {
		return displayCountry;
	}


	public void setDisplayCountry(String displayCountry) {
		this.displayCountry = displayCountry;
	}


	public String getDisplayLanguage() {
		return displayLanguage;
	}


	public void setDisplayLanguage(String displayLanguage) {
		this.displayLanguage = displayLanguage;
	}


	public String getDisplayName() {
		return displayName;
	}


	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


	public String getDisplayVariant() {
		return displayVariant;
	}


	public void setDisplayVariant(String displayVariant) {
		this.displayVariant = displayVariant;
	}


	public String getISO3Country() {
		return ISO3Country;
	}


	public void setISO3Country(String iSO3Country) {
		ISO3Country = iSO3Country;
	}


	public String getISO3Language() {
		return ISO3Language;
	}


	public void setISO3Language(String iSO3Language) {
		ISO3Language = iSO3Language;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getVariant() {
		return variant;
	}


	public void setVariant(String variant) {
		this.variant = variant;
	}


	public Timezone getTimezone() {
		return timezone;
	}


	public void setTimezone(Timezone timezone) {
		this.timezone = timezone;
	}
	

	
	
}
