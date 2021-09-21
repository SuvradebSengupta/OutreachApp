<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Volunteer | Registration</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" type="text/css"
	href="/css/volunteer-register.css">
</head>
<body>
	<div id="login">
		<h3 class="text-center text-white pt-5">Volunteer Registration</h3>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form id="login-form" class="form" action="" method="post">
							<h3 class="text-center text-info">Fill Your Details</h3>
							<div class="form-group">
								<label for="firstname" class="text-info">First Name: *</label><br>
								<input type="text" autocomplete="off" name="firstname" id="firstname" required
									class="form-control">
							</div>
							<div class="form-group">
								<label for="lastname" class="text-info">Last Name: *</label><br>
								<input type="text" autocomplete="off" name="lastname" id="lastname" required
									class="form-control" />
							</div>
							<div class="form-group">
								<label for="age" class="text-info">Age: *</label><br> <input
									type="number" name="age" id="age" required class="form-control">
							</div>
							<div class="form-group">
								<label for="gender" class="text-info">Gender: *</label>&ensp; <label
									class="radio-inline"> <input type="radio"
									name="gender" value="MALE" required> MALE
								</label>&ensp; <label class="radio-inline"> <input type="radio"
									name="gender" value="FEMALE"> FEMALE
								</label>&ensp; <label class="radio-inline"> <input type="radio"
									name="gender" value="OTHERS"> OTHERS
								</label>
							</div>
							<div class="form-group">
								<label for="contactnumber" class="text-info">Contact
									Number: *</label><br> <input type="text" name="contactnumber"
									id="contactnumber" autocomplete="off" required class="form-control">
							</div>
							<div class="form-group">
								<label for="password" class="text-info">Password: *</label><br>
								<input type="password" name="password" required id="password"
									class="form-control">
							</div>
							<div class="form-group">
								<input type="submit" onclick="return validate()" name="submit"
									value="Submit" class="btn btn-info btn-md">
								&emsp;&emsp;
								<button type="reset" class="btn btn-info btn-md">Reset</button>
								<span style="color:red">Fields marked with * are mandatory</span>
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
	<script src="/js/register.js"></script>
</body>
</html>