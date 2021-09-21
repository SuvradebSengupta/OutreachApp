<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Volunteer Info</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<style>
* {
	font-family: Trebuchet MS;
}

body {
	background-image: url("/images/volunteer-background.png");
	background-size: cover;
	text-align: center;
	padding-top: 70px;
}

h2 {
	text-align: center;
	color: white;
}

.btn {
	border: 1px solid #17a2b8;;
	padding: 5px 20px;
	background-color: #17a2b8;
	color: #fff;
	text-decoration: none;
	transition: 0.6s ease;
	text-align: center;
}
</style>
</head>
<body>
	<h2>Congratulations!! ${firstname} ${lastname}</h2>
	<h2>Your UserName is : ${username}</h2>
	<div class="button-group">
		<a href="/volunteer-login" class="text-center btn btn-primary">Login</a>
	</div>
</body>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</html>