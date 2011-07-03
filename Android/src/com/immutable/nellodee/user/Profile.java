package com.immutable.nellodee.user;

public class Profile {
	private String sling_resourceType;
	private String hash;
	private BasicProfile basic;
	private String rep_userId;
	private String userId;
	private Counts counts;
	private Boolean sakai_excludeSearch;
	private String homePath;
	private String _path;

	public Profile() {
		super();
		this.sling_resourceType = "";
		this.hash ="";
		this.basic = new BasicProfile();
		this.rep_userId = "";
		this.userId = "";
		this.counts = new Counts();
		this.sakai_excludeSearch = false;
		this.homePath = "";
		this._path = "";
	}
	
	public Profile(String sling_resourceType, String hash, BasicProfile basic,
			String rep_userId, String userId, Counts counts,
			Boolean sakai_excludeSearch, String homePath, String _path) {
		super();
		this.sling_resourceType = sling_resourceType;
		this.hash = hash;
		this.basic = basic;
		this.rep_userId = rep_userId;
		this.userId = userId;
		this.counts = counts;
		this.sakai_excludeSearch = sakai_excludeSearch;
		this.homePath = homePath;
		this._path = _path;
	}

	public String getSling_resourceType() {
		return sling_resourceType;
	}

	public void setSling_resourceType(String sling_resourceType) {
		this.sling_resourceType = sling_resourceType;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public BasicProfile getBasic() {
		return basic;
	}

	public void setBasic(BasicProfile basic) {
		this.basic = basic;
	}

	public String getRep_userId() {
		return rep_userId;
	}

	public void setRep_userId(String rep_userId) {
		this.rep_userId = rep_userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Counts getCounts() {
		return counts;
	}

	public void setCounts(Counts counts) {
		this.counts = counts;
	}

	public Boolean getSakai_excludeSearch() {
		return sakai_excludeSearch;
	}

	public void setSakai_excludeSearch(Boolean sakai_excludeSearch) {
		this.sakai_excludeSearch = sakai_excludeSearch;
	}

	public String getHomePath() {
		return homePath;
	}

	public void setHomePath(String homePath) {
		this.homePath = homePath;
	}

	public String get_path() {
		return _path;
	}

	public void set_path(String _path) {
		this._path = _path;
	}

}
