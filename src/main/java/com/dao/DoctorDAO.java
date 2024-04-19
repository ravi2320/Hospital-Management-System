package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Doctor;
import com.model.Patient;

public class DoctorDAO {
	private Connection con;

	public DoctorDAO(Connection con) {
		super();
		this.con = con;
	}

	public boolean registerDoctor(Doctor d) {
		boolean flag = false;

		try {
			String query = "insert into doctor(name, dob, qualification, specialist, email, mobno, password) values(?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, d.getName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobNo());
			ps.setString(7, d.getPassword());
			
			int i = ps.executeUpdate();
			
			if(i == 1)
				flag = true;
			
		} catch (Exception e) {
			e.addSuppressed(e);
		}

		return flag;
	}
	
	public List<Doctor> getAllRecords(){
		List<Doctor> list = new ArrayList<Doctor>();
		
		try {
			String query = "select * from doctor order by id desc";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Doctor d = new Doctor();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
				list.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Doctor getDoctorById(int id){
		Doctor d = null;
		
		try {
			String query = "select * from doctor where id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}
	
	public boolean updateDoctor(Doctor d) {
		boolean flag = false;

		try {
			String query = "update doctor set name=?, dob=?, qualification=?, specialist=?, email=?, mobno=?, password=? where id=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, d.getName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobNo());
			ps.setString(7, d.getPassword());
			ps.setInt(8, d.getId());
			
			int i = ps.executeUpdate();
			
			if(i == 1)
				flag = true;
			
		} catch (Exception e) {
			e.addSuppressed(e);
		}

		return flag;
	}
	
	public boolean deleteDoctorById(int id){
		boolean flag = false;
		
		try {
			String query = "delete from doctor where id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			
			if(i == 1)
				flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public Doctor doctorLogin(String email, String pass) {
		Doctor d = null;
		try {
			String query = "select * from doctor where email = ? and password = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}
	
	public int countPatient() {
		int cnt = 0;
		try {
			String query = "select * from Patient";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cnt++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public int countDoctor() {
		int cnt = 0;
		try {
			String query = "select * from doctor";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cnt++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public int countAppointment() {
		int cnt = 0;
		try {
			String query = "select * from appointment";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cnt++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public int countSpecialist() {
		int cnt = 0;
		try {
			String query = "select * from Specialist";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cnt++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
