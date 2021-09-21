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

<meta charset="ISO-8859-1">
<title>Volunteer | Event Info</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Candal|Lora">
<link rel="stylesheet" type="text/css" href="/css/view-event.css">
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
	<div id="event">
		<h1 class="text-center text-white pt-5">Event Details</h1>
		<br>
		<div class="container">
			<div id="login-box" class="col-md-12">
				<table class="table table-striped">
					<tr>
						<th>Activity</th>
						<th>Event Name</th>
						<th>Description</th>
						<th>Place</th>
						<th>Date</th>
						<th>Contact</th>
						<th>Number of Volunteers</th>
					</tr>
					<tr>
						<td>${event.activity}</td>
						<td>${event.eventName}</td>
						<td>${event.description}</td>
						<td>${event.place}</td>
						<td><fmt:formatDate value="${event.date}" /></td>
						<td>${event.contactNumber}</td>
						<td>${event.noOfVolunteers}</td>
					</tr>
				</table>
				<br>
				<div>
					<span style="color: red">Do's :</span>
					<h6>${event.dos}</h6>
					<br> <span style="color: red">Don'ts :</span>
					<h6>${event.donts}</h6>
				</div>
			</div>
		</div>
	</div>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</body>
<footer class="text-center">
	<br> <br> <a href="/admin-view-event" class="btn btn-success">Go
		back</a>
</footer>
</html>