<%@include file="main-page.jsp"%>
<html>
<head>
</head>
<body>

	<div class="container">
		<div class="row justify-content-left">
			<form action="updateOneAuthor">
				<table>
					<tr>
						<td>Author Id</td>
						<td><input type="text"
							value="<c:out value='${author.getAuthorId()}'/>" name=id readonly></td>
					</tr>
					<tr>
						<td>Change Author Id</td>
						<td><input type="text"
							value="<c:out value='${author.getAuthorId()}'/>" name=idNew></td>
					</tr>
					<tr>
						<td>Change Author First Name</td>
						<td><input type="text"
							value="<c:out value='${author.getFirstName()}'/>"
							name="firstName"></td>
					</tr>
					<tr>
						<td>Change Author Last Name</td>
						<td><input type="text"
							value="<c:out value='${author.getLastName()}'/>" name="lastName"></td>
					</tr>
					<tr>
						<td>Change About Author</td>
						<td><div class="form-group">
								<textarea class="form-control" rows="10" cols="50"><c:out
										value='${author.getAboutAuthor()}' />
								</textarea>
							</div></td>
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