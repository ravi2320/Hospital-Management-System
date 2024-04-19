package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Patient;

public class AdminLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		Patient p = new Patient();
		p.setEmail(email);
		
		HttpSession session = request.getSession();
		if(email.equals("admin@gmail.com") && pass.equals("admin")) {
			session.setAttribute("adminObj", p);
			response.sendRedirect("admin/index.jsp");
		}
		else {
			session.setAttribute("failMsg", "Invalid email and Password...!");
			response.sendRedirect("admin_login.jsp");
		}
	}

}
