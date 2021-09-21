<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

<!-- Custom Styling -->
<link rel="stylesheet" type="text/css" href="/css/volunteer-home.css">

<!-- Google Fonts -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Candal|Lora">
<title>Volunteer | Home</title>
</head>
<body>
	<header>
		<div class="logo">
			<h1 class="logo-text">
				<span>Outreach</span>APP
			</h1>
		</div>
		<i class="fa fa-bars menu-toggle"></i>
		<ul class="nav">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#"> <i class="fa fa-user"></i>
					${currentVolunteer.getUsername()} <i class="fa fa-chevron-down"
					style="font-size: .8em;"></i>
			</a>
				<ul>
					<li><a href="#" class="logout">Wah Account</a></li>
					<li><a href="volunteer-logout" class="logout">Logout</a></li>
				</ul></li>
		</ul>
	</header>
	<!-- Volunteer Page Wrapper -->
	<div class="volunteer-wrapper">
		<!-- Left Sidebar-->
		<div class="left-sidebar">
			<h1>Menu</h1>
			<a href="/view-completed-event">Feedback</a> <a
				href="/volunteer-suggestion">Suggestion</a> <a href="/invite">Send
				Invites</a>
		</div>
	</div>
	<!-- // Left Sidebar -->
	<!-- // Volunteer Page Wrapper -->
	<div class="title">
		<h1>Welcome to the outreachAPP</h1>
	</div>
	<div class="button-group">
		<a href="/view-event" class="btn btn-primary">View Events</a> &emsp; <a
			href="/volunteer-myevent" class="btn btn-primary">My Events</a>
	</div>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>