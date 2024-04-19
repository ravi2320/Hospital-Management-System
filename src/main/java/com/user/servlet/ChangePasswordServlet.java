package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.PatientDAO;
import com.db.DBConnection;

public class ChangePasswordServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("oldPass");
		
		PatientDAO dao = new PatientDAO(DBConnection.getConnection());
		boolean flag = dao.checkOldPassword(pid, oldPass);
		HttpSession session = request.getSession();
		
		if(flag) {
			if(dao.changePassword(pid, newPass)) {
				session.setAttribute("succMsg", "Password changed..!");
			}
			else {
				session.setAttribute("failMsg", "Something wrong on server");
			}
		}
		else {
			session.setAttribute("failMsg", "Old password mismatch..!");
		}
		response.sendRedirect("change_password.jsp");
	}

}
