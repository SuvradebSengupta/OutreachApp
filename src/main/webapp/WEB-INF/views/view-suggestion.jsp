<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin | View Suggestions</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" type="text/css" href="/css/attendance.css">
<link rel="stylesheet" type="text/css" href="/css/navigation.css">
</head>

<body>
	<header>
		<div class="logo">
			<h1 class="logo-text">
				<span>Outreach</span>APP
			</h1>
		</div>

		<div class="nav">
			<a href="/admin-home" class="btn btn-info">Home</a>&emsp; <a
				href="/admin-logout" class="btn btn-danger">Logout</a>
		</div>
	</header>
	<div id="joinedevent">

		<h1 class="text-center text-white pt-5">Suggestions</h1>
		<br>

		<div class="container">
			<div id="login-box" class="col-md-12">
				<table class="table table-striped">

					<tr>
						<th>Event Details</th>
						<th>Target Audience</th>
						<th>Volunteers Required</th>
						<th>Cost Estimation</th>
						<th>Approve</th>
						<th>Reject</th>
					</tr>
					<c:forEach items="${suggested}" var="suggestion">
						<tr>
							<td>${suggestion.eventDetails}</td>
							<td>${suggestion.targetGroup}</td>
							<td>${suggestion.volunteersRequired}</td>
							<td>${suggestion.approxCost}</td>
							<td><a href="/approve?id=${suggestion.id}"
								class="btn btn-success">Approve</a></td>
							<td><a href="/reject?id=${suggestion.id}"
								class="btn btn-danger">Reject</a></td>
						</tr>
					</c:forEach>
				</table>
				<div class="text-center"></div>
			</div>
		</div>
	</div>



	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<script>
		$(document)
				.ready(
						function() {
							$("#myInput")
									.on(
											"keyup",
											function() {
												var value = $(this).val()
														.toLowerCase();
												$("#myTable tr")
														.filter(
																function() {
																	$(this)
																			.toggle(
																					$(
																							this)
																							.text()
																							.toLowerCase()
																							.indexOf(
																									value) > -1)
																});
											});
						});
	</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</body>
<br>
<footer class="text-center">
	<a href="/admin-home" class="btn btn-success">Go Back</a>
</footer>
</html>