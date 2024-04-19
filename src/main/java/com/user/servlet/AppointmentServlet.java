package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.Request;

import com.dao.AppointmentDAO;
import com.db.DBConnection;
import com.model.Appointment;


public class AppointmentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int patient_id = Integer.parseInt(request.getParameter("userId"));
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String appoint_date = request.getParameter("appoint_date");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String dieases = request.getParameter("dieases");
		int doctor_id = Integer.parseInt(request.getParameter("doctor"));
		String address = request.getParameter("address");
		
		Appointment ap = new Appointment(patient_id, name, gender, age, appoint_date, email, phone, dieases, doctor_id, address, "Pending");
		
		AppointmentDAO dao = new AppointmentDAO(DBConnection.getConnection());
		
		HttpSession session = request.getSession();
		
		if(dao.addAppointment(ap)) {
			session.setAttribute("succMsg", "Appointment Added Successfully...!");
		}
		else {
			session.setAttribute("failMsg", "something wrong on server");
		}
		response.sendRedirect("appointmnet.jsp");
	}

}
