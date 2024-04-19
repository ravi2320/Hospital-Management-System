<%@page import="com.model.Doctor"%>
<%@page import="java.util.List"%>
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
<%@ include file="../component/all_css.jsp"%>
</head>
<body>
<%@ include file="../component/navbar.jsp"%>
	<div class="container-fuild backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 p-5">
				<img alt="" src="img/doc-1.png">
			</div>

			<div class="col-md-6">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-3">User Appointment</p>

						<c:if test="${ not empty failMsg  }">
							<p class="text-center text-danger fs-4">${failMsg}</p>
							<c:remove var="failMsg" scope="session" />
						</c:if>

						<c:if test="${ not empty succMsg }">
							<p class="text-center text-success fs-4"">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<form action="AppointmentServlet" method="post" class="row g-3">
							<c:if test="${ not empty patientObj }">
								<input type="hidden" name="userId"
									value="${ patientObj.getPid() }">
							</c:if>

							<div class="col-md-6">
								<label class="form-label">Full Name</label> <input type="text"
									name="name" class="form-control" required>
							</div>

							<div class="col-md-6">
								<label class="form-label">Gender</label> <select
									class="form-control" name="gender" required>
									<option value="male">Male</option>
									<option value="female">Female</option>
								</select>
							</div>

							<div class="col-md-6">
								<label class="form-label">Age</label> <input type="number"
									name="age" class="form-control" required>
							</div>

							<div class="col-md-6">
								<label class="form-label">Appointment Date</label> <input
									type="date" name="appoint_date" class="form-control" required>
							</div>

							<div class="col-md-6">
								<label class="form-label">Email</label> <input type="text"
									name="email" class="form-control" required>
							</div>

							<div class="col-md-6">
								<label class="form-label">Phone No</label> <input type="number"
									maxlength="10" name="phone" class="form-control" required>
							</div>

							<div class="col-md-6">
								<label class="form-label">Dieases</label> <input type="text"
									name="dieases" class="form-control" required>
							</div>

							<div class="col-md-6">
								<label class="form-label">Doctor</label> <select
									class="form-control" name="doctor" required>
									<option value="doctor">Select</option>

									<%
									DoctorDAO dao = new DoctorDAO(DBConnection.getConnection());
									List<Doctor> doctor = dao.getAllRecords();
									for (Doctor doc : doctor) {
									%>
									<option value="<%=doc.getId()%>"><%=doc.getName()%>(<%=doc.getSpecialist()%>)
									</option>
									<%
									}
									%>
								</select>
							</div>

							<div class="col-md-12">
								<label class="form-label">Full Address</label>
								<textarea name="address" class="form-control" rows="3" cols=""
									required></textarea>
							</div>

							<c:if test="${ empty patientObj }">
								<a href="user_login.jsp"
									class="col-md-6 offset-md-3 btn btn-success">Add Appointment</a>
							</c:if>

							<c:if test="${ not empty patientObj }">
								<button type="submit" class="col-md-6 offset-md-3 btn btn-success">Add Appointment</button>
							</c:if>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>