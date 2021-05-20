<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="include-session.jsp"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Library</title>
</head>
<body>
	<div class="container">
		<ul class="nav nav-tabs">
			<c:if test="${admin==1}">
				<li class="nav-item"><a class="nav-link" href="printUsers">List
						Of Users</a></li>
			</c:if>
			<li class="nav-item"><a class="nav-link" href="printOneUser">My
					Profile</a></li>
			<li class="nav-item"><a class="nav-link" href="allAuthor">Books</a>
			</li>
			<c:if test="${admin==1}">
				<li class="nav-item"><a class="nav-link" href="add-book.jsp">Add
						Book</a></li>
			</c:if>
			<li class="nav-item"><a class="nav-link" href="logoutUser">LogOut</a>
			</li>
		</ul>
	</div>
</body>
</html>