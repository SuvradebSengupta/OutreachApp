<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin | Create Event</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" type="text/css"
	href="/css/volunteer-register.css">
<link rel="stylesheet" href="/css/navigation.css">
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
	<div id="login">
		<h3 class="text-center text-white pt-5">Create Event</h3>
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						<form:form id="login-form" class="form" action="" method="post"
							modelAttribute="event">
							<h3 class="text-center text-info">Fill Event Details</h3>
							<div>
								<form:label path="activity" for="activity">Choose an activity: *</form:label>
								<select name="activity" id="activity" required>
									<option value="">Select Activity</option>
									<option value="indoor">Indoor</option>
									<option value="seedBallMaking">Seed Ball Making</option>
									<option value="teaching">Teaching</option>
									<option value="beachCleanUp">Beach Clean up</option>
									<option value="treePlantation">Tree Plantation</option>
									<option value="farming">Farming</option>
								</select>
							</div>
							<div class="form-group">
								<form:label for="eventName" class="text-info" path="eventName">Event name: *</form:label>
								<br> <input type="text" name="eventName" id="eventName"
									autocomplete="off" class="form-control" required />
							</div>
							<div class="form-group">
								<form:label for="description" class="text-info"
									path="description">Description: *</form:label>
								<br> <input type="text" name="description" id="description"
									autocomplete="off" class="form-control" required />
							</div>
							<div class="form-group">
								<form:label for="place" class="text-info" path="place">Place: *</form:label>
								<br> <input type="text" name="place" id="place"
									autocomplete="off" class="form-control" required />
							</div>
							<div class="form-group">
								<form:label for="date" class="text-info" path="date">Date: * </form:label>
								<br> <input type="date" name="date" id="date"
									class="form-control" required />
							</div>
							<div class="form-group">
								<form:label for="contactNumber" class="text-info"
									path="contactNumber">Contact
									Number: *</form:label>
								<br> <input type="text" name="contactNumber"
									autocomplete="off" id="contactNumber" class="form-control"
									required />
							</div>
							<div class="form-group">
								<form:label for="noOfVolunteers" class="text-info"
									path="noOfVolunteers">Number of Volunteers: *</form:label>
								<br> <input type="text" name="noOfVolunteers"
									id="noOfVolunteers" autocomplete="off" class="form-control"
									required />
							</div>
							<div class="form-group">
								<form:label for="dos" class="text-info" path="dos">To be done(Do's): *</form:label>
								<br> <input type="text" name="dos" id="dos"
									autocomplete="off" class="form-control" required />
							</div>
							<div class="form-group">
								<form:label for="donts" class="text-info" path="donts">Not to be done(Don'ts): *</form:label>
								<br> <input type="text" name="donts" id="donts"
									autocomplete="off" class="form-control" required />
							</div>
							<div class="form-group">
								<input type="submit" onclick="return validate()" name="submit"
									value="Add+" class="btn btn-info btn-md"> &emsp;&emsp;
								<button type="reset" class="btn btn-info btn-md">Reset</button>
								<span style="color: red">Fields marked with * are
									mandatory</span>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="/js/create-event.js"></script>
</body>
</html>