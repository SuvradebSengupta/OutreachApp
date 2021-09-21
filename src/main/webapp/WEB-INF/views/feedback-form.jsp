<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="/css/volunteer-register.css">
<link rel="stylesheet" href="/css/navigation.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Candal|Lora">

</head>
<body>
	<header>
		<div class="logo">
			<h1 class="logo-text">
				<span>Outreach</span>APP
			</h1>
		</div>
	
		<div class="nav">
			<a href="/volunteer-home" class="btn btn-info">Home</a>&emsp;
			<a href="/volunteer-logout" class="btn btn-danger">Logout</a>
		</div>
	</header>
	<div id="login">
		<h3 class="text-center text-white pt-5">Please give us your
			feedback</h3>
		<br>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">

						<form id="login-form" class="form" action="" method="post">
							<br>
							<h5 class="text-center text-info">Please answer all the
								questions</h5>
							<br>
							<div class="form-group">
								<label for="ans1" class="text-info">1. Were
									you able to complete the event? *</label> <br> <input type="radio"
									name="ans1" value="Yes" /> Yes &emsp; <input
									type="radio" name="ans1" value="No" /> No <br />
							</div>
							<br>
							<div class="form-group">
								<label for="ans2" class="text-info">2. Did
									everyone follow the safety protocols? *</label> <br> <input
									type="radio" name="ans2" value="Yes" /> Yes &emsp;
								<input type="radio" name="ans2" value="No" /> No <br />
							</div>
							<br>
							<div class="form-group">
								<label for="ans3" class="text-info">3. Was the
									venue environment friendly? *</label> <br> <input type="radio"
									name="ans3" value="Yes" /> Yes &emsp; <input
									type="radio" name="ans3" value="No" /> No <br />
							</div>
							<br>
							<div class="form-group">
								<label for="ans4" class="text-info">4. Was the food
									quality above average? *</label> <br> <input type="radio"
									name="ans4" value="Yes" /> Yes &emsp; <input type="radio"
									name="ans4" value="No" /> No <br />
							</div>
							<br>
							<div class="form-group">
								<label for="ans5" class="text-info">5. Did you face
									any difficulty with the higher authority at the venue? *</label> <br>
								<input type="radio" name="ans5" value="Yes" /> Yes &emsp;
								<input type="radio" name="ans5" value="No" /> No <br />
							</div>
							<br>
							<div class="form-group">
								<input type="submit"
									onclick="alert('Thank you for your Feedback!')" name="submit"
									value="Submit" class="btn btn-info btn-md">
								&emsp;&emsp;
								<button type="reset" class="btn btn-info btn-md">Reset</button>
								<span style="color: red">Fields marked with * are
									mandatory</span>
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
</html>