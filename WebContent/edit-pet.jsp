<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit pets</title>
</head>
<body>
	<form action = "editPetServlet" method="post">
		Name: <input type = "text" name = "name" value = "${petToEdit.name}">
		Animal: <input type = "text" name = "animal" value = "${petToEdit.animal}">
		Breed: <input type = "text" name = "breed" value = "${petToEdit.breed}">
		Purchase date: <input type="text" name="month" placeholder="mm" size="4" value="${petToEdit.purchaseDate.getMonthValue()}">, 
		<input type="text" name="day" placeholder="dd" size="4" value="${petToEdit.purchaseDate.getDayOfMonth()}">, 
		<input type="text" name="year" placeholder="yyyy" size="4" value="${petToEdit.purchaseDate.getYear()}"><br/>
		
		<input type = "hidden" name = "id" value = "${petToEdit.id}">
		<input type = "submit" value = "Save Edited Pet">		
	</form>
</body>
</html>