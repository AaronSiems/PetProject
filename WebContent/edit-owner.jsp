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
<form action = "editOwnerServlet" method="post">
		Firstname: <input type = "text" name = "fname" value = "${ownerToEdit.fname}">
		Lastname: <input type = "text" name = "lanme" value = "${ownerToEdit.lname}">
		City: <input type = "text" name = "city" value = "${ownerToEdit.city}">
		State: <input type="text" name="state" size="2" value="${ownerToEdit.state}">, 
		
		
		<input type = "hidden" name = "id" value = "${ownerToEdit.id}">
		<input type = "submit" value = "Save Edited Owner">		
	</form>
</body>
</html>