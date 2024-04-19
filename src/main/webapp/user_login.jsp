<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

						<c:if test="${ not empty failMsg  }">
							<p class="text-center text-danger fs-4">${failMsg}</p>
							<c:remove var="failMsg" scope="session" />
						</c:if>

						<c:if test="${ not empty succMsg }">
							<p class="text-center text-success fs-4"">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						
						<p class="fs-4 text-center">User Login</p>

						<form action="PatientLoginServlet" method="post">
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input name="pass"
									type="password" class="form-control" required>
							</div>

							<button type="submit" class="btn bg-success text-white col-md-12">Login</button>
						</form>
						<br> Don't have an account? <a href="signup.jsp"
							class="text-decoration-none">Create Account</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="component/footer.jsp"%>

</body>
</html>