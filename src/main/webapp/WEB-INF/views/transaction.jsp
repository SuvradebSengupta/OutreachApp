<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Candal|Lora">
<link rel="stylesheet" href="/css/transaction.css">
</head>
<body>
	
		<h1>Transaction Page</h1>
		<div id="transaction">
		<form:form id="donate-form" class="form" action="" method="post"
			modelAttribute="event">
			<div class="form-group">
				<form:label for="donation" class="text-info" path="donation">Enter the Amount to be
				Donated: </form:label><br>
				<br> Rs. <input type="number" class="text-center" style="width:100px;" name="donation" id="donation"
					required class="form-control">
			</div><br>
			<div class="form-group">
				<input type="submit"
					onclick="return validateTransaction()"
					name="submit" value="Pay" class="btn btn-success btn-md">
				&emsp;&emsp;
				<button type="reset" class="btn btn-danger btn-md">Reset</button>
			</div>
		</form:form>
	</div>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="/js/transaction.js"></script>
</body>
</html>