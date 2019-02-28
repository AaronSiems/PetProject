<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of pets</title>
</head>
<body>
<form method = "post" action = "petNavServlet">

	<table>
	<c:forEach items="${requestScope.allItems}" var="currentpet">
	<tr>
		<td><input type="radio" name="id" value="${currentpet.id}"></td>
		<td>${currentpet.name}</td>
		<td>${currentpet.animal}</td>
		<td>${currentpet.breed}</td>
		<td>${currentpet.purchaseDate}</td>
	</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "edit" name = "doThisToItem">
	<input type = "submit" value = "delete" name = "doThisToItem">
	</form>
<a href="addPetServlet">Add a new pet</a><br/>
<a href = "index.html">Return home</a><br/>
</body>
</html>