<%@include file="main-page.jsp"%>
<html>
<head>
</head>
<body>

	<div class="container">
		<div class="row justify-content-left">
			<form action="updateOneBook">
				<table>
					<tr>
						<td>Book Id</td>
						<td><input type="text"
							value="<c:out value='${book.getBookId()}'/>" name=id readonly></td>
					</tr>
					<tr>
						<td>Change Book Id</td>
						<td><input type="text"
							value="<c:out value='${book.getBookId()}'/>" name=idNew></td>
					</tr>
					<tr>
						<td>Change Book Name</td>
						<td><input type="text"
							value="<c:out value='${book.getBookName()}'/>" name="bookName"></td>
					</tr>
					<tr>
						<td>Change Url Book</td>
						<td><input type="text"
							value="<c:out value='${book.getBookUrl()}'/>" name="bookUrl"></td>
					</tr>
					<tr>
						<td>Change Book Summary</td>
						<td><div class="form-group">
								<textarea class="form-control" rows="10" cols="50"><c:out
										value='${book.getBookSummary()}' />
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