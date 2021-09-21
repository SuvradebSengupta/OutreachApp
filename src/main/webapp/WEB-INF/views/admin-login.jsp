<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin | Login</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" type="text/css" href="/css/login.css">
</head>
<body>
	<div id="login">
		<h3 class="text-center text-white pt-5">Admin Login Form</h3>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form id="login-form" class="form" action="" method="post">
							<h3 class="text-center text-info">Enter Your Details</h3>
							<div class="form-group">
								<label for="username" class="text-info">Username:</label><br>
								<input type="text" autocomplete="off" name="username"
									id="username" required class="form-control">
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Password:</label><br>
								<input type="password" name="password" id="password" required
									class="form-control">
							</div>
							<div class="form-group">
								<span style="color: red;">${errorMessage}</span> <br> <input
									type="submit" name="submit" class="btn btn-info btn-md"
									value="Login">&emsp; <a href="/welcome"
									class="btn btn-success">Back</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
<footer> </footer>
</html>