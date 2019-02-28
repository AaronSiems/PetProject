<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action = "viewAllOwnersServlet">

	<table>
	<c:forEach items="${requestScope.allItems}" var="currentowner">
	<tr>
		<td><input type="radio" name="id" value="${currentowner.id}"></td>
		<td>${currentowner.fname}</td>
		<td>${currentowner.lname}</td>
		<td>${currentowner.city}</td>
		<td>${currentowner.state}</td>
	</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "edit">
	</form>
<a href="addOwnerServlet">Add a new pet</a>
</body>
</html>