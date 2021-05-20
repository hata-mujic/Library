<%@include file="main-page.jsp"%>

<html>
<head>
</head>
<body>
	<div class="container">
		<div class="row justify-content-left">
			<form action="printOneForUpdateUser">
				<table class="borderless">
					<tr>
						<td>First name:</td>
						<td><c:out value='${user.getFirstName()}' /></td>
					</tr>
					<tr>
						<td>Last name:</td>
						<td><c:out value='${user.getLastName()}' /></td>
					</tr>
					<tr>
						<td>User name:</td>
						<td><c:out value='${user.getUserName()}' />"</td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><c:out value='${user.getPassword()}' /></td>
					</tr>

					<tr>
						<td>Date of birth:</td>
						<td><c:out value='${user.getDob()}' /></td>
					</tr>
					<tr>
						<td><button type="submit" class="btn btn-primary">Edit</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>