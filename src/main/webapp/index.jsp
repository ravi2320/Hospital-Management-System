<%@page import="com.db.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
<%@ include file="component/all_css.jsp"%>
</head>
<body>
	<%@ include file="component/navbar.jsp"%>
	

	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="3" aria-label="Slide 4"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/slider1.jpeg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/slider-2.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/slider-3.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/slider-4.png" class="d-block w-100" alt="..."
					height="500px">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

	<hr>

	<div class="containaer p-3">
		<p class="text-center fs-2">Key Features of Our Hospital</p>

		<div class="row">
			<div class="col-md-8 p-5">
				<div class="row">
					<div class="col-md-6">
						<div class="card point-card">
							<div class="card-body">
								<p class="fs-5">100% Saftey</p>
								<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
									Aenean commodo ligula eget dolor. Aenean massa. Cum
									pellentesque eu, pretium quis, sem. Nulla consequat massa quis
									enim.</p>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="card point-card">
							<div class="card-body">
								<p class="fs-5">Friendly Doctors</p>
								<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
									Aenean commodo ligula eget dolor. Aenean massa. Cum
									pellentesque eu, pretium quis, sem. Nulla consequat massa quis
									enim.</p>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="card point-card">
							<div class="card-body">
								<p class="fs-5">Clean Enviorment</p>
								<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
									Aenean commodo ligula eget dolor. Aenean massa. Cum
									pellentesque eu, pretium quis, sem. Nulla consequat massa quis
									enim.</p>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="card point-card">
							<div class="card-body">
								<p class="fs-5">Medical Research</p>
								<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
									Aenean commodo ligula eget dolor. Aenean massa. Cum
									pellentesque eu, pretium quis, sem. Nulla consequat massa quis
									enim.</p>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<img alt="" src="img/doc-2.png">
			</div>
		</div>
	</div>

	<hr>

	<div class="container p-2">
		<p class="text-center fs-2">Our Team</p>

		<div class="row">
			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/doc-1.png" height="300px" width="250px">
						<p class="fw-bold fs-5">Saumani Simi</p>
						<p class="fs-7">(CEO & Chairman)</p>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/doc-2.png" height="300px" width="250px">
						<p class="fw-bold fs-5">Dr. Shivani Kumar</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/doc-3.png" height="300px" width="250px">
						<p class="fw-bold fs-5">Dr. Mathue Paule</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/doc-4.png" height="300px" width="250px">
						<p class="fw-bold fs-5">Dr. Nuise Samuel</p>
						<p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<hr>

	<%@ include file="component/footer.jsp"%>
</body>
</html>