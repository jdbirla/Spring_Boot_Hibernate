<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Access Denied</title>
<style type="text/css">

.err{
  color: red;
  font-style: italic;
}
</style>
</head>
<body>
	<h1 class="err">Access Denied - You are not authorized to access this resource</h1>

  <hr>
  
<a href="${pageContext.request.contextPath}/">Back to Home</a>

</body>
</html>