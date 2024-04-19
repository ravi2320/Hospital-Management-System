<%@page import="com.dao.AppointmentDAO"%>
<%@page import="com.model.Doctor"%>
<%@page import="com.db.DBConnection"%>
<%@page import="com.dao.DoctorDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Login</title>
<%@ include file="../component/all_css.jsp"%>
</head>
<body>
	<c:if test="${ empty doctorObj }">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>
	<%@ include file="navbar.jsp"%>

	<p class="text-center fs-3 mt-3">Doctor Dashboard</p>
	<div class="container p-5">
		<div class="row">
			
			<%
				Doctor d = (Doctor) session.getAttribute("doctorObj");
				DoctorDAO dao = new DoctorDAO(DBConnection.getConnection());
				AppointmentDAO dao2 = new AppointmentDAO(DBConnection.getConnection());
			%>
			<div class="col-md-4 offset-md-2">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fas fa-user-md fa-3x"></i>
						<p class="fs-4 text-center">
							Doctor <br><%=dao.countDoctor() %>
						</p>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fa-solid fa-calendar-check fa-3x"></i>
						<p class="fs-4 text-center">
							Total Appointment <br><%=dao2.countAppointmentByDoctorId(d.getId()) %>
						</p>
					</div>
				</div>
			</div>

		</div>
	</div>

</body>
</html>