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
<link rel="stylesheet" type="text/css" href="/css/admin-home.css">

<!-- Google Fonts -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Candal|Lora">
<title>Admin | Home</title>
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
			<li><a href="#"> <i class="fa fa-user"></i> Admin <i
					class="fa fa-chevron-down" style="font-size: .8em;"></i>
			</a>
				<ul>
					<li><a href="/admin-logout" class="logout">Logout</a></li>
				</ul></li>
		</ul>
	</header>
	<!-- Admin Page Wrapper -->
	<div class="admin-wrapper">
		<!-- Left Side bar-->
		<div class="left-sidebar">
			<h1>Menu</h1>
			<a href="/attendance">Attendance</a> <a href="/volunteer-donation-info">Donation</a> <a
				href="/view-feedback">Feedbacks</a> <a href="/view-suggestion">View Suggestions</a>
		</div>
	</div>
	<!-- // Left Sidebar -->

	<!-- // Admin Page Wrapper -->
	<div class="title">
		<h1>Welcome Admin</h1>
	</div>
	<div class="button-group">
		<a href="/create-event" class="btn">Create Event</a> <a href="/volunteer-report"
			class="btn">Volunteer Report</a> <a href="/admin-view-event"
			class="btn">All Events</a>
	</div>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>