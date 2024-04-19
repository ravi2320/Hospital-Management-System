package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Specialist;

public class SpecialistDAO {
	private Connection con = null;
	
	public SpecialistDAO(Connection conn) {
		super();
		this.con = conn;
	}

	public boolean insertSpecialist(String spec_name) {
		boolean flag = false;
		
		try {
			String query = "insert into specialist(spec_name) values(?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, spec_name);
			
			int i = ps.executeUpdate();
			
			if(i == 1)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public List<Specialist> getSpecialist() {
		List<Specialist> list = new ArrayList<Specialist>();
		
		try {
			String query = "select * from Specialist";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Specialist spec = new Specialist();
				spec.setSpec_id(rs.getInt(1));
				spec.setSpec_name(rs.getString(2));
				list.add(spec);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
