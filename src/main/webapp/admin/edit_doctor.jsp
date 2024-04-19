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
<title>Edit Doctor</title>
<%@ include file="../component/all_css.jsp"%>
</head>
<body>
	<%@ include file="navbar.jsp"%>

	<div class="container-fliud p-3">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Doctor</p>
						<c:if test="${ not empty errorMsg }">
							<p class="fs-3 text-center text-danger">${ errorMsg }</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${ not empty successMsg }">
							<p class="fs-3 text-center text-success">${ successMsg }</p>
							<c:remove var="successMsg" scope="session" />
						</c:if>

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						DoctorDAO Dao = new DoctorDAO(DBConnection.getConnection());
						Doctor d = Dao.getDoctorById(id);
						%>
						<form action="../EditDoctorServlet" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									name="name" class="form-control" value="<%=d.getName()%>"
									required>
							</div>
							<div class="mb-3">
								<label class="form-label">DOB</label> <input type="date"
									name="dob" class="form-control" value="<%=d.getDob()%>"
									required>
							</div>
							<div class="mb-3">
								<label class="form-label">Qualification</label> <input
									type="text" name="quali" class="form-control"
									value="<%=d.getQualification()%>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Specialist</label> <select name="spec"
									class="form-control" required>
									<option><%=d.getSpecialist() %></option>
									<%
									SpecialistDAO dao = new SpecialistDAO(DBConnection.getConnection());
									List<Specialist> list = dao.getSpecialist();
									for (Specialist spec : list) {
									%>
									<option><%=spec.getSpec_name()%></option>
									<%
									}
									%>
								</select>
							</div>
							<div class="mb-3">
								<label class="form-label">E-Mail</label> <input type="email"
									name="email" class="form-control" value="<%=d.getEmail()%>"
									required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mob No</label> <input type="text"
									name="mobno" class="form-control" value="<%=d.getMobNo()%>"
									required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									type="text" name="pass" class="form-control"
									value="<%=d.getPassword()%>" required>
							</div>
							<input type="text" value="<%=id%>" name="id" hidden>
							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>