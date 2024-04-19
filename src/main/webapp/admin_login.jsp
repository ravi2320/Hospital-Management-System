<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="component/all_css.jsp"%>
</head>
<body>
	<%@ include file="component/navbar.jsp"%>

	<div class="conatiner p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Admin Login</p>

						<c:if test="${ not empty failMsg  }">
							<p class="text-center text-danger fs-4">${failMsg}</p>
							<c:remove var="failMsg" scope="session"/>
						</c:if>
						
						<c:if test="${ not empty succMsg }">
							<p class="text-center text-success fs-4"">${succMsg}</p>
							<c:remove var="succMsg" scope="session"/>
						</c:if>
						
						<form action="AdminLoginServlet" method="post">
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
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="component/footer.jsp"%>

</body>
</html>