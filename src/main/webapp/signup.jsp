<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<%@ include file="component/all_css.jsp"%>
</head>
<body>
	<%@ include file="component/navbar.jsp"%>

	<div class="conatiner p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Patient SignUp</p>

						<c:if test="${ not empty sucMsg }">
							<p class="text-center text-success fs-2">${sucMsg}</p>
							<c:remove var="sucMsg" scope="session" />
						</c:if>

						<c:if test="${ not empty failMsg }">
							<p class="text-center text-danger fs-3">${failMsg}</p>
							<c:remove var="failMsg" scope="session" />
						</c:if>

						<form action="PatientSignUpServlet" method="post">
							<div class="mb-3">
								<label class="form-label">Enter Name</label> <input name="pname"
									type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input name="pass"
									type="password" class="form-control" required>
							</div>

							<button type="submit" class="btn bg-success text-white col-md-12">SignUp</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="component/footer.jsp"%>

</body>
</html>