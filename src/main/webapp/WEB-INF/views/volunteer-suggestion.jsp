<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Volunteer | Suggestion</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" type="text/css"
	href="/css/volunteer-register.css">
	<link rel="stylesheet" type="text/css"
	href="/css/navigation.css">
</head>
<body>
	<header>
		<div class="logo">
			<h1 class="logo-text">
				<span>Outreach</span>APP
			</h1>
		</div>

		<div class="nav">
			<a href="/volunteer-home" class="btn btn-info">Home</a>&emsp; <a
				href="/volunteer-logout" class="btn btn-danger">Logout</a>
		</div>
	</header>
	<div id="login">
		<h3 class="text-center text-white pt-5">Volunteer Suggestions</h3>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form id="login-form" class="form" action="" method="post">
							<h3 class="text-center text-info">Fill In Your Suggestions</h3>
							<div class="form-group">
								<label for="eventDetails" class="text-info">Event
									Details:</label><br> <input type="text" autocomplete="off"
									name="eventDetails" id="eventDetails" required
									class="form-control">
							</div>
							<div class="form-group">
								<label for="targetGroup" class="text-info">Target
									Audience:</label><br> <input type="text" autocomplete="off"
									name="targetGroup" id="targetGroup" required
									class="form-control" />
							</div>
							<div class="form-group">
								<label for="volunteersRequired" class="text-info">Volunteers
									Required:</label><br> <input type="number"
									name="volunteersRequired" id="volunteersRequired" required
									class="form-control">
							</div>
							<div class="form-group">
								<label for="approxCost" class="text-info">Cost Estimate:</label><br>
								<input type="text" name="approxCost" id="approxCost"
									autocomplete="off" required class="form-control">
							</div>
							<div class="form-group">
								<input type="submit" name="submit" value="Submit"
									class="btn btn-info btn-md"> &emsp;&emsp;
								<button type="reset" class="btn btn-info btn-md">Reset</button>
								<span style="color: red">Please fill in all the Fields</span>
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