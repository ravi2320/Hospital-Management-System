<%@page import="com.model.Doctor"%>
<%@page import="com.dao.DoctorDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnection"%>
<%@page import="com.dao.SpecialistDAO"%>
<%@page import="com.model.Specialist"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Page</title>
<%@ include file="../component/all_css.jsp"%>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container-fliud p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-paint">
					<div class="card-body">
						<p class="fs-3 text-center">Doctor Details</p>
						
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
									<th scope="col">DOB</th>
									<th scope="col">Qualification</th>
									<th scope="col">Specialist</th>
									<th scope="col">Email</th>
									<th scope="col">Mob NO</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>

								<%
								DoctorDAO Dao = new DoctorDAO(DBConnection.getConnection());
								List<Doctor> Dlist = Dao.getAllRecords();
								for (Doctor d : Dlist) {
								%>
								<tr>
									<td><%=d.getName()%></td>
									<td><%=d.getDob()%></td>
									<td><%=d.getQualification()%></td>
									<td><%=d.getSpecialist()%></td>
									<td><%=d.getEmail()%></td>
									<td><%=d.getMobNo()%></td>
									<td><a href="edit_doctor.jsp?id=<%=d.getId()%>"
										class="btn btn-sm btn-primary">Edit</a> <a
										href="../DeleteDoctorServlet?id=<%=d.getId()%>"
										class="btn btn-sm btn-danger">Delete</a></td>
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