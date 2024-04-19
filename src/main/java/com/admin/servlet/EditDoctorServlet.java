package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDAO;
import com.db.DBConnection;
import com.model.Doctor;

public class EditDoctorServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String qualification = request.getParameter("quali");
		String spec = request.getParameter("spec");
		String mobno = request.getParameter("mobno");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		Doctor d = new Doctor();
		d.setId(id);
		d.setName(name);
		d.setDob(dob);
		d.setQualification(qualification);
		d.setSpecialist(spec);
		d.setMobNo(mobno);
		d.setEmail(email);
		d.setPassword(pass);
		
		DoctorDAO dao = new DoctorDAO(DBConnection.getConnection());
		boolean f = dao.updateDoctor(d);
		
		HttpSession session = request.getSession();
		if(f) {
			session.setAttribute("successMsg", "Doctor Updated Successfully...!");
			response.sendRedirect("admin/view_doctor.jsp");
		}
		else
		{
			session.setAttribute("failMsg", "Something wrong on server");
			response.sendRedirect("admin/edit_doctor.jsp");
		}
	}

}
