<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>RegisterForm</title>
</head>
<body>

	<div class="container">
		<div class="row justify-content-center">

			<form action="insertUser" method="post">
				<div class="form-group">
					<label for="usr">Username:</label> <input type="text"
						class="form-control" id="usr" placeholder="Enter user name"
						name="uname" required>
				</div>
				<div class="form-group">
					<label for="firstName">First name:</label> <input type="text"
						class="form-control" id="firstName" placeholder="Enter first name"
						name="fname" required>
				</div>
				<div class="form-group">
					<label for="lastName">Last name:</label> <input type="text"
						class="form-control" id="LastName" placeholder="Enter last name"
						name="lname" required>
				</div>
				<div class="form-group">
					<label for="pwd">Password:</label> <input type="password"
						class="form-control" id="pwd" placeholder="Enter password"
						name="pass" required>
				</div>
				<div class="form-group">
					<label for="rpwd"> Confirm password:</label> <input type="password"
						class="form-control" id="rpwd" placeholder="Confirm password"
						name="rpass" required>
				</div>
				<div class="form-group">
					<label for="dob">Date of birth:</label> <input type="date"
						class="form-control" id="dob" name="dob" required>
				</div>
				<button type="submit" class="btn btn-primary">Register</button>
				or <a href="index.jsp">Back</a>
			</form>
		</div>
	</div>

</body>
</html>