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

public class AddDoctorServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String name = request.getParameter("name");
			String dob = request.getParameter("dob");
			String qualification = request.getParameter("quali");
			String spec = request.getParameter("spec");
			String mobno = request.getParameter("mobno");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			
			Doctor d = new Doctor();
			d.setName(name);
			d.setDob(dob);
			d.setQualification(qualification);
			d.setSpecialist(spec);
			d.setMobNo(mobno);
			d.setEmail(email);
			d.setPassword(pass);
			
			DoctorDAO dao = new DoctorDAO(DBConnection.getConnection());
			boolean f = dao.registerDoctor(d);
			
			HttpSession session = request.getSession();
			if(f) {
				session.setAttribute("successMsg", "Doctor Added Successfully...!");
			}
			else
			{
				session.setAttribute("failMsg", "Something wrong on server");
			}
			response.sendRedirect("admin/doctor.jsp");
	}

}
