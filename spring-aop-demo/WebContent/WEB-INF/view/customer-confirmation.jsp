<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Confirmation</title>
</head>
<body>
	<p> The customer is confirmed.</p>
	<p><b> ${customer.firstName} ${customer.lastName}</b> </p>
	<p>Free passes: <b></b>${customer.freePasses}</p>
	<p>Postal Code: <b>${cutomer.postalCode}</b></p>
	<p>Course Code: <b>${customer.courseCode}</b></p>
</body>
</html>