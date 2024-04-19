package com.doctor.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DoctorLogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("doctorObj");
		session.setAttribute("succMsg", "Doctor Logout Successfully");
		response.sendRedirect("doctor_login.jsp");
	}
}
