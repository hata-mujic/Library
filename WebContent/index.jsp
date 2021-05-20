<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>LogIn</title>
</head>
<body>

	<div class="container">
		<div class="row justify-content-center">
			<form action="loginUser" method="get">
				<div class="form-group">
					<label for="usr">Username:</label> <input type="text"
						class="form-control" id="usr" placeholder="Enter user name"
						name="uname" required>
				</div>
				<div class="form-group">
					<label for="pwd">Password:</label> <input type="password"
						class="form-control" id="pwd" placeholder="Enter password"
						name="pass" required>
				</div>
				<button type="submit" class="btn btn-primary">LogIn</button>
				or <a href="register-form.jsp">Register</a>
			</form>
		</div>
	</div>

</body>
</html>