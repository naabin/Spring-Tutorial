<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h2>Hello Home page | this is secured app</h2>
	<p>
		User: <security:authentication property="principal.username"/>
		<br>
		Role(s): <security:authentication property="principal.authorities"/>
		<security:csrfMetaTags/>
	</p>
	<hr>
	<security:authorize access="hasRole('MANAGER')">
	<p>
		<a href="${pageContext.request.contextPath }/leaders">LeaderShip Meeting</a>
		(Only for Manager peeps)
	</p>
	</security:authorize>
	<security:authorize access="hasRole('admin')">
	<p>
		<a href="${pageContext.request.contextPath}/systems">Administration Meeting</a>
	</p>
	</security:authorize>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>