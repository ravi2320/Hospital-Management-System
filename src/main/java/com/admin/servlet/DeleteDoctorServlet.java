package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDAO;
import com.db.DBConnection;

public class DeleteDoctorServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		DoctorDAO dao = new DoctorDAO(DBConnection.getConnection());
		boolean f = dao.deleteDoctorById(id);
		
		HttpSession session = request.getSession();
		if(f) {
			session.setAttribute("successMsg", "Doctor Deleted Successfully...!");
		}
		else
		{
			session.setAttribute("failMsg", "Something wrong on server");
		}
		response.sendRedirect("admin/view_doctor.jsp");
	}

}
