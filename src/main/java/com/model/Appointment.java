package com.model;

public class Appointment {
	private int id;
	private int patientId;
	private String name;
	private String gender;
	private int age;
	private String appointDate;
	private String email;
	private String phone;
	private String dieases;
	private int doctorId;
	private String address;
	private String status;
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appointment(int patientId, String name, String gender, int age, String appointDate, String email,
			String phone, String dieases, int doctorId, String address, String status) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.appointDate = appointDate;
		this.email = email;
		this.phone = phone;
		this.dieases = dieases;
		this.doctorId = doctorId;
		this.address = address;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAppointDate() {
		return appointDate;
	}
	public void setAppointDate(String appointDate) {
		this.appointDate = appointDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDieases() {
		return dieases;
	}
	public void setDieases(String dieases) {
		this.dieases = dieases;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
