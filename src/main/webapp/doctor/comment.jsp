<%@page import="com.model.Appointment"%>
<%@page import="com.db.DBConnection"%>
<%@page import="com.dao.AppointmentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.backImg {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("../img/slider-4.png");
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
<%@ include file="../component/all_css.jsp"%>
</head>
<body>
	<c:if test="${ empty doctorObj }">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>
	<%@ include file="navbar.jsp"%>

	<div class="container-fuild backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">

			<div class="col-md-6 offset-md-3">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-3">Patient Comment</p>

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						System.out.print(id);
						AppointmentDAO dao = new AppointmentDAO(DBConnection.getConnection());
						Appointment ap = dao.getAppointmentByAppointmentId(id);
						%>

						<form action="../updateStatusServlet" class="row" method="post">
							<div class="col-md-6">
								<label>Patient Name</label> <input type="text" readonly
									value="<%=ap.getName()%>" class="form-control ">
							</div>

							<div class="col-md-6">
								<label>Age</label> <input type="text" readonly
									value="<%=ap.getAge()%>" class="form-control ">
							</div>

							<div class="col-md-6">
								<label></label>Mob No<input type="number" readonly
									value="<%=ap.getPhone()%>" class="form-control ">
							</div>

							<div class="col-md-6">
								<label></label>Dieases<input type="text" readonly
									value="<%=ap.getDieases()%>" class="form-control ">
							</div>

							<div class="col-md-6">
								<label>Comment</label> <input type="text" value=""
									name="comm" class="form-control ">
							</div>

							<input type="hidden" value="<%=ap.getId() %>" name="id"> <input
								type="hidden" value="<%=ap.getDoctorId() %>" name="did">

							<button class="mt-3 btn btn-primary col-md-6 offset-md-3">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>