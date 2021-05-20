<%@include file="main-page.jsp"%>
<html>
<head>
</head>
<body>
	<div class="container">
		<div class="row justify-content-left">
			<form action="updateUser">
				<table class="borderless">
					<tr>
						<td>Change first name:</td>
						<td><input type="text"
							value="<c:out value='${user.getFirstName()}'/>" name="fname"></td>
					</tr>
					<tr>
						<td>Change last name:</td>
						<td><input type="text"
							value="<c:out value='${user.getLastName()}'/>" name="lname"></td>
					</tr>
					<tr>
						<td>Change user name:</td>
						<td><input type="text"
							value="<c:out value='${user.getUserName()}'/>" name="uname"
							readonly></td>
					</tr>
					<tr>
						<td>Change password:</td>
						<td><input type="text"
							value="<c:out value='${user.getPassword()}'/>" name="pass"></td>
					</tr>
					<tr>
						<td>Change password:</td>
						<td><input type="text" name="rpass"></td>
					</tr>
					<tr>
						<td>Change date of birth:</td>
						<td><input type="date"
							value="<c:out value='${user.getDob()}'/>" name="dob"></td>
					</tr>
					<tr>
						<td><button type="submit" class="btn btn-primary">Update</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>