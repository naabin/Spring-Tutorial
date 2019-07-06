<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Confirmation</title>
</head>
<body>
	<p>The student is confirmed: <b>${student.firstName } ${student.lastName}</b> from <b>${student.country}</b></p>
	<p>Student's favorite language is <b>${student.favoriteLanguage}</b></p>
	<p>Student chooses following operating systems: </p>
	<ul>
		<c:forEach items="${student.operatingSystems}" var="temp">
			<li><b>${temp}</b></li>
		</c:forEach>
	</ul>
</body>
</html>