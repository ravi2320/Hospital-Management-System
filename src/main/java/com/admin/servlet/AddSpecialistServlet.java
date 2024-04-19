package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SpecialistDAO;
import com.db.DBConnection;

public class AddSpecialistServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String spec_name = request.getParameter("spec_name");

		SpecialistDAO dao = new SpecialistDAO(DBConnection.getConnection());
		boolean f = dao.insertSpecialist(spec_name);

		HttpSession session = request.getSession();

		if (f) {
			session.setAttribute("successMsg", "Speacialist Added Successfully");
		} else {
			session.setAttribute("failMsg", "Something went wrong in server");
		}
		response.sendRedirect("admin/index.jsp");
	}

}
