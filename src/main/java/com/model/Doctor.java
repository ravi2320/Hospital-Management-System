package com.model;

public class Doctor {
	private int id;
	private String name;
	private String dob;
	private String qualification;
	private String specialist;
	private String mobNo;
	private String email;
	private String password;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Doctor(int id, String name, String dob, String qualification, String specialist, String mobNo, String email,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.qualification = qualification;
		this.specialist = specialist;
		this.mobNo = mobNo;
		this.email = email;
		this.password = password;
	}
	public Doctor(int id, String name, String dob, String qualification, String specialist, String mobNo,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.qualification = qualification;
		this.specialist = specialist;
		this.mobNo = mobNo;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
