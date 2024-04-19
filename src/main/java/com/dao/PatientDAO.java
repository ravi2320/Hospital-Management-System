package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Patient;

public class PatientDAO {
	private Connection con = null;

	public PatientDAO(Connection con) {
		super();
		this.con = con;
	}

	public boolean registerPatient(Patient p) {
		boolean flag = false;

		try {

			String query = "insert into patient(pname, email, password) values(?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, p.getPname());
			ps.setString(2, p.getEmail());
			ps.setString(3, p.getPassword());

			int i = ps.executeUpdate();

			if (i == 1)
				flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public Patient patientLogin(String email, String pass) {

		Patient p = null;
		try {
			String query = "select * from patient where email = ? and password = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new Patient();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setEmail(rs.getString(3));
				p.setPassword(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	public boolean checkOldPassword(int pid, String oldPass) {
		boolean flag = false;

		try {
			String query = "select * from patient where pid=? and password=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, pid);
			ps.setString(2, oldPass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean changePassword(int pid, String newPass) {
		boolean flag = false;

		try {

			String query1 = "update patient set password = ? where pid = ?";
			PreparedStatement ps2 = con.prepareStatement(query1);
			ps2.setInt(1, pid);
			ps2.setString(2, newPass);

			int i = ps2.executeUpdate();
			if (i == 1)
				flag = true;
		} catch (

		Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

}
