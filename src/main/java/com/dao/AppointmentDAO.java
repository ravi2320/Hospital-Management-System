package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Appointment;

public class AppointmentDAO {
	private Connection con;

	public AppointmentDAO(Connection con) {
		super();
		this.con = con;
	}

	public boolean addAppointment(Appointment ap) {

		boolean flag = false;

		try {

			String query = "insert into APPOINTMENT(patient_id, name, gender, age, appoint_date, email, phone, disease, doctor_id, address, status) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, ap.getPatientId());
			ps.setString(2, ap.getName());
			ps.setString(3, ap.getGender());
			ps.setInt(4, ap.getAge());
			ps.setString(5, ap.getAppointDate());
			ps.setString(6, ap.getEmail());
			ps.setString(7, ap.getPhone());
			ps.setString(8, ap.getDieases());
			ps.setInt(9, ap.getDoctorId());
			ps.setString(10, ap.getAddress());
			ps.setString(11, ap.getStatus());

			int i = ps.executeUpdate();
			if (i == 1)
				flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public List<Appointment> getAllAppointmentById(int userId) {

		List<Appointment> list = new ArrayList<Appointment>();

		try {
			String query = "select * from APPOINTMENT where patient_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Appointment ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setPatientId(userId);
				ap.setName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getInt(5));
				ap.setAppointDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhone(rs.getString(8));
				ap.setDieases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Appointment> getAllAppointmentByDoctorId(int doctorId) {

		List<Appointment> list = new ArrayList<Appointment>();

		try {
			String query = "select * from APPOINTMENT where doctor_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, doctorId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Appointment ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setPatientId(rs.getInt(2));
				ap.setName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getInt(5));
				ap.setAppointDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhone(rs.getString(8));
				ap.setDieases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public int countAppointmentByDoctorId(int doctorId) {

		int cnt = 0;

		try {
			String query = "select * from APPOINTMENT where doctor_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, doctorId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cnt++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnt;
	}
	
	public List<Appointment> getAllAppointment() {

		List<Appointment> list = new ArrayList<Appointment>();

		try {
			String query = "select * from APPOINTMENT order by appoint_date desc";
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Appointment ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setPatientId(rs.getInt(2));
				ap.setName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getInt(5));
				ap.setAppointDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhone(rs.getString(8));
				ap.setDieases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				list.add(ap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public Appointment getAppointmentByAppointmentId(int id) {

		Appointment ap = null;
		try {
			String query = "select * from APPOINTMENT where id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setPatientId(rs.getInt(2));
				ap.setName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getInt(5));
				ap.setAppointDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setPhone(rs.getString(8));
				ap.setDieases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ap;
	}
	
	public boolean updateSuccessStatus(int id, int doct_id, String comm) {
		boolean flag = false;
		
		try {
			String query = "update Appointment set status=? where id=? and doctor_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, comm);
			ps.setInt(2, id);
			ps.setInt(3, doct_id);
			int i = ps.executeUpdate();
			
			if(i == 1)
					flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
}
