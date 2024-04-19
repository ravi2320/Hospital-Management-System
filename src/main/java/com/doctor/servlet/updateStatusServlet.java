package com.doctor.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDAO;
import com.db.DBConnection;
import com.model.Appointment;

public class updateStatusServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		int did = Integer.parseInt(request.getParameter("did"));
		String comment = request.getParameter("comm");
		
		AppointmentDAO dao = new AppointmentDAO(DBConnection.getConnection());
		
		HttpSession session = request.getSession();
		if(dao.updateSuccessStatus(id, did, comment)){
			session.setAttribute("succMsg", "Comment Updated.!");
		}
		else {
			session.setAttribute("errorMsg", "Something wrong on server.!");
		}
		response.sendRedirect("doctor/patient.jsp");
	}

}
