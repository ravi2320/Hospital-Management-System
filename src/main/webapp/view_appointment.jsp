<%@page import="com.model.Patient"%>
<%@page import="com.dao.DoctorDAO"%>
<%@page import="com.model.Doctor"%>
<%@page import="com.model.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnection"%>
<%@page import="com.dao.AppointmentDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment Page</title>
<style type="text/css">
.backImg {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("img/slider-4.png");
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
<%@ include file="component/all_css.jsp"%>
</head>
<body>
	<%@ include file="component/navbar.jsp"%>

	<div class="container-fuild backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-9">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-success">Appointment
							List</p>

						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appoint Date</th>
									<th scope="col">Dieases</th>
									<th scope="col">Doctor Name</th>
									<th scope="col">Staus</th>
								</tr>
							</thead>
							<tbody>
								<%
								Patient p = (Patient) session.getAttribute("patientObj");
								AppointmentDAO dao = new AppointmentDAO(DBConnection.getConnection());
								DoctorDAO dao2 = new DoctorDAO(DBConnection.getConnection());
								List<Appointment> list = dao.getAllAppointmentById(p.getPid());
								for (Appointment lst : list) {
									Doctor d = dao2.getDoctorById(lst.getDoctorId());
								%>
								<tr>
									<td><%=lst.getName()%></td>
									<td><%=lst.getGender()%></td>
									<td><%=lst.getAge()%></td>
									<td><%=lst.getAppointDate()%></td>
									<td><%=lst.getDieases()%></td>
									<td><%=d.getName()%></td>
									<td>
										<%
										if ("Pending".equals(lst.getStatus())) {
										%> <a href="#"
										class="btn btn-sm btn-warning">Pending</a> 
 										<%} else {%> 
 											<%=lst.getStatus()%>
										<%
										}
										%>

									</td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="col-md-3 p-3">
				<img alt="" src="img/doc-4.png">
			</div>
		</div>
	</div>

</body>
</html>