package org.sakaiproject.nellodee;

import java.util.ArrayList;

public class Rols {
	private ArrayList<String> tags;

	public Rols() {
		super();
		this.tags = new ArrayList<String>();
		tags.add("academic_related_staff");
		tags.add("academic_staff");
		tags.add("graduate_student");
		tags.add("undergraduate_student");
		tags.add("non-academic_staff");
		tags.add("postgraduate_student");
		tags.add("research_staff");
		tags.add("other");
	}
	
	public Rols(ArrayList<String> tags) {
		super();
		this.tags = tags;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	
}
