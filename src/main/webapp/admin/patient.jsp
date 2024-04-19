<%@page import="com.dao.DoctorDAO"%>
<%@page import="com.model.Appointment"%>
<%@page import="com.dao.AppointmentDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnection"%>
<%@page import="com.model.Doctor"%>
<%@page import="com.dao.PatientDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Patient</title>

<%@ include file="../component/all_css.jsp"%>
</head>
<body>
	<c:if test="${ empty adminObj }">
		<c:redirect url="../admin_login.jsp"></c:redirect>
	</c:if>
	<%@ include file="navbar.jsp"%>
	<div class="container-fliud p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">All Patient Appointment Details</p>

						<c:if test="${ not empty errorMsg }">
							<p class="fs-3 text-center text-danger">${ errorMsg }</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${ not empty successMsg }">
							<p class="fs-3 text-center text-success">${ successMsg }</p>
							<c:remove var="successMsg" scope="session" />
						</c:if>

						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appointment Date</th>
									<th scope="col">Email</th>
									<th scope="col">Mob NO</th>
									<th scope="col">Disease</th>
									<th scope="col">Doctor Name</th>
									<th scope="col">Address</th>
									<th scope="col">Status</th>
								</tr>
							</thead>
							<tbody>
								<%
								AppointmentDAO dao = new AppointmentDAO(DBConnection.getConnection());
								DoctorDAO dao2 = new DoctorDAO(DBConnection.getConnection());
								List<Appointment> list = dao.getAllAppointment();
								for (Appointment ap : list) {
									Doctor d = dao2.getDoctorById(ap.getDoctorId());
								%>
								<tr>
									<td><%=ap.getName()%></td>
									<td><%=ap.getGender()%></td>
									<td><%=ap.getAge()%></td>
									<td><%=ap.getAppointDate()%></td>
									<td><%=ap.getEmail()%></td>
									<td><%=ap.getPhone()%></td>
									<td><%=ap.getDieases()%></td>
									<td><%=d.getName()%></td>
									<td><%=ap.getAddress()%></td>
									<td><%=ap.getStatus()%></td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>