package com.model;

public class Specialist {
	private int spec_id;
	private String spec_name;
	public Specialist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Specialist(int spec_id, String spec_name) {
		super();
		this.spec_id = spec_id;
		this.spec_name = spec_name;
	}
	public int getSpec_id() {
		return spec_id;
	}
	public void setSpec_id(int spec_id) {
		this.spec_id = spec_id;
	}
	public String getSpec_name() {
		return spec_name;
	}
	public void setSpec_name(String string) {
		this.spec_name = string;
	}
	
}
