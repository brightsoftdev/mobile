package org.sakaiproject.nellodee;

public class DataController {
	private Rols rols;

	public DataController() {
		super();
		this.rols = new Rols();
	}
	
	public DataController(Rols rols) {
		super();
		this.rols = rols;
	}
	
	public Rols getRols() {
		return rols;
	}

	public void setRols(Rols rols) {
		this.rols = rols;
	}
}
