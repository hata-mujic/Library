<%@include file="main-page.jsp"%>
<html>
<head>
</head>
<body>

	<div class="container">
		<div class="text-center">
			<h4>
				Author:
				<c:out value="${author.getFirstName()}" />
				<c:out value="${author.getLastName()}" />
			</h4>
			<p>
				<c:out value="${author.getAboutAuthor()}" />
			</p>
			<c:if test="${admin==1}">
				<td><a
					href="oneAuthor?id=<c:out value='${author.getAuthorId()}'/>">EDIT</a></td>
			</c:if>
		</div>
		<hr>

		<c:forEach items="${arrBook}" var="list">
			<div class="text-center">
				<h4>
					<c:out value="${list.getBookName()}" />
				</h4>
				<p>
					<c:out value="${list.getBookSummary()}" />
				</p>
				<h5>
					URL: <a href="<c:out value="${list.getBookUrl()}"/>"><c:out
							value="${list.getBookUrl()}" /></a>
				</h5>
				<c:if test="${admin==1}">
					<a href="oneBook?id=<c:out value='${list.getBookId()}'/>">EDIT</a>
					<a href="deleteBook?id=<c:out value='${list.getBookId()}'/>">DELETE</a>
				</c:if>
				<hr>
			</div>
		</c:forEach>
	</div>

</body>
</html>