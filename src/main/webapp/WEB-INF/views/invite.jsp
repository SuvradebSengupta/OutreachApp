<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Volunteer Invite Link</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="http://youtube.local/assets/dcode.css">
<link rel="shortcut icon" href="http://youtube.local/assets/favicon.ico">

<style>
body {
	background-image: url("/images/volunteer-background.png");
	background-size: cover;
	padding-left: 70px;
	padding-top: 100px;
	font-family: "Comic Sans MS";
}

h2 {
	color: white;
}
</style>
</head>
<body>
	
	<div style="text-align: center">
		<h2>Copy the link to send an invite</h2>
		<input id=myInp type="text"
			value="http://localhost:8080/volunteer-login" readonly>
		<button id="btnCopy" class="btn btn-info btn-md">Copy</button><br><br>
		<a href="/volunteer-home" class="btn btn-success">Go back</a>
	</div>
</body>
<script>
	const myInp = document.getElementById("myInp");
	const btnCopy = document.getElementById("btnCopy");

	btnCopy.onclick = function() {
		myInp.select();
		document.execCommand("Copy")
	};
</script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</html>