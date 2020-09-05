<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>luv2code Company Home Page</title>
</head>
<body>

	<h2>luv2code Company Home Page</h2>
	<hr>
	<p>Welcome to the luv2code Company Home Page!!!</p>

	<hr>
	<!-- Displaying user id	 -->


	<p>
		User:
		<security:authentication property="principal.username" />
		<br> <br> Roles(s) :
		<security:authentication property="principal.authorities" />
	</p>

	<hr>

	<!-- add a link point to leaders managers -->
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders">LeaderShip
				Meeting</a> (Only for managers)
		</p>
		<hr>
	</security:authorize>
	

	<security:authorize access="hasRole('ADMIN')">

		<!-- add a link point to system only for admin-->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT System
				Meeting</a> (Only for Admins)
		</p>
		<hr>
	</security:authorize>
	


	<!-- Add logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="logout" />

	</form:form>

</body>
</html>