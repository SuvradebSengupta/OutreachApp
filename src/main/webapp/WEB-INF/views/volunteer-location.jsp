<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Volunteer By Activity</title>
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
	<div id="search">
		<form id="login-form" class="form" action="" method="post">
			<label for="place" class="text-info">Search by Location: *</label> <br>&emsp;&emsp;&ensp;
			<input type="text" class="text-center" style="width:200px;height:35px;" name="place" id="place" autocomplete="off"
				class="form-control" required />&ensp; <input type="submit"
				onclick="return validate()" name="submit" value="Search"
				class="text-center btn btn-info btn-md"> &emsp;&emsp;
		</form>
	</div>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</body>
</html>