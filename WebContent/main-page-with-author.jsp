<%@include file="main-page.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="container">
		<table class="table-borderless">
			<c:forEach items="${allAuthor}" var="list">
				<tr>
					<td><a
						href="allBooksFromOneAuthor?id=<c:out value='${list.authorId}'/>"><c:out
								value="${list.firstName}" /> <c:out value="${list.lastName}" /></a></td>
					<td><c:if test="${admin==1}">
							<a
								href="deleteAuthorAndBooks?id=<c:out value='${list.authorId}'/>">DELETE</a>
						</c:if></td>
				</tr>

			</c:forEach>
		</table>
	</div>

</body>
</html>