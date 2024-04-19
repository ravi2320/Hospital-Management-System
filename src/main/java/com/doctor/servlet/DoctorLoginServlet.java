package com.doctor.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDAO;
import com.dao.PatientDAO;
import com.db.DBConnection;
import com.model.Doctor;
import com.model.Patient;

public class DoctorLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		DoctorDAO dao = new DoctorDAO(DBConnection.getConnection());
		Doctor d = dao.doctorLogin(email, pass);
		
		HttpSession session = request.getSession();
		
		if(d != null) {
			session.setAttribute("doctorObj", d);
			response.sendRedirect("doctor/index.jsp");
		}
		else {
			session.setAttribute("failMsg", "Invalid email and Password...!");
			response.sendRedirect("doctor_login.jsp");
		}
	}

}
