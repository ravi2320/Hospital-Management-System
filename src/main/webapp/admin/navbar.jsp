<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"><i class="fa-regular fa-hospital"></i>
			MEDI HOME</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">

				<li class="nav-item"><a class="nav-link"
					href="index.jsp"> Home</a></li>
				<li class="nav-item"><a class="nav-link"
					href="doctor.jsp">DOCTOR</a></li>
				<li class="nav-item"><a class="nav-link"
					href="view_doctor.jsp">VIEW DOCTOR</a></li>
				<li class="nav-item"><a class="nav-link"
					href="patient.jsp">APPOINTMENT</a></li>

			</ul>
			<form>
				<div class="dropdown">
					<button class="btn btn-light dropdown-toggle" type="button"
						id="dropdownMenuButton1" data-bs-toggle="dropdown"
						area-expanded="false">Admin</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
						<li><a class="dropdown-item" href="../AdminLogoutServlet">Logout</a></li>
					</ul>
				</div>
			</form>
		</div>
	</div>
</nav>