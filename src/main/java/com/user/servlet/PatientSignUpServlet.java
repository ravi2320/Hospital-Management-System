package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.PatientDAO;
import com.db.DBConnection;
import com.model.Patient;

public class PatientSignUpServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("pname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		Patient p = new Patient();
		p.setPname(name);
		p.setEmail(email);
		p.setPassword(pass);
		
		PatientDAO dao = new PatientDAO(DBConnection.getConnection());
		boolean flag = dao.registerPatient(p);
		
		HttpSession session = request.getSession();
		if(flag)
			session.setAttribute("sucMsg", "Registration Successful...!");
		else
			session.setAttribute("failMsg", "Registration Failed...!");

		response.sendRedirect("signup.jsp");
	}

}
