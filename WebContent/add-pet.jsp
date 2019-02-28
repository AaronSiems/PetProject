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
<form action = "addPetServlet" method="post">
	Animal: <input type = "text" name = "animal">
	Breed: <input type = "text" name = "breed">
	Name: <input type = "text" name = "name">
	Purchase date: <input type="text" name="month" placeholder="mm" size="4">, 
	<input type="text" name="day" placeholder="dd" size="4">, 
	<input type="text" name="year" placeholder="yyyy" size="4"><br/>
	Owner: <select name="owner">
	<c:forEach items="${requestScope.allItems}" var="currentowner">
	<option value="${currentowner.id}">${currentowner.fname} ${currentowner.lname}</option>
	</c:forEach>
	</select>
	<input type = "submit" value = "Add Pet">
	</form><br />
	<a href = "viewAllPetsServlet">View all the pets</a><br/>
	<a href = "index.html">Return to home</a><br/>
</body>
</html>