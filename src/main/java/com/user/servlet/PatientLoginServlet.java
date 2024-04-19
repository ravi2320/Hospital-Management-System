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

public class PatientLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		PatientDAO dao = new PatientDAO(DBConnection.getConnection());
		Patient p = dao.patientLogin(email, pass);
		
		HttpSession session = request.getSession();
		
		if(p != null) {
			session.setAttribute("patientObj", p);
			response.sendRedirect("index.jsp");
		}
		else {
			session.setAttribute("failMsg", "Invalid email and Password...!");
			response.sendRedirect("user_login.jsp");
		}
	}

}
