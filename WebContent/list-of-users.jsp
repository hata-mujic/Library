
<%@include file="main-page.jsp"%>
<html>
<head>
<body>
	<div class="container">
		<table class="table">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>User Name</th>
				<th>Password</th>
				<th>Date Of Birth</th>
				<th>DELETE</th>
			</tr>
			<c:forEach items="${list}" var="element">
				<tr>
					<td><c:out value="${element.getFirstName()}"></c:out></td>
					<td><c:out value="${element.getLastName()}"></c:out></td>
					<td><c:out value="${element.getUserName()}"></c:out></td>
					<td><c:out value="${element.getPassword()}"></c:out></td>
					<td><c:out value="${element.getDob()}"></c:out></td>
					<td><a
						href="deleteUser?username=<c:out value='${element.getUserName()}'/>">DELETE</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>