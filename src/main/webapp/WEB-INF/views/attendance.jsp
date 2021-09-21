<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="ISO-8859-1">
<title>Admin | Attendance</title>
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

		<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="/attendance" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>

		<h1 class="text-center text-white pt-5">Attendance</h1>
		<div class="text-center pt-5">
			<label class="text-white">Search for Event:</label> <input
				id="myInput" type="text" placeholder="Search..">
		</div>
		<br>



		<div class="container">
			<div id="login-box" class="col-md-12">
				<table class="table table-striped">

					<tr>
						<th>Volunteer</th>
						<th>Event</th>
						<th></th>
						<th></th>
					</tr>
					<c:forEach items="${pagedListHolder.pageList}" var="joinedevent">
						<tbody id="myTable">
							<tr>
								<td>${joinedevent.username}</td>
								<td>${joinedevent.eventName}</td>
								<td><a href="/accept?id=${joinedevent.id}" class="btn btn-success">Accept</a></td>
								<td><a href="/decline?id=${joinedevent.id}" class="btn btn-danger">Decline</a></td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
				<div class="text-center">
					<tg:paging pagedListHolder="${pagedListHolder}"
						pagedLink="${pagedLink}" />
				</div>
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
<br><footer class="text-center">
	<a href="/admin-home" class="btn btn-success">Go Back</a>
</footer>
</html>
