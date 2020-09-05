<!DOCTYPE html>
<html>

<head>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/my-test.css">

<script
	src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
</head>
<body>

	<h2>Spring demo MVC - Home Page</h2>

	
	<a href="hello/showForm">Hello World Form</a>

	<br>
	<br>
	<img
		src="${pageContext.request.contextPath}/resources/images/spring-logo.png"
		width="40" height="40" />

	<input type="button" onclick="doSomeWork()" value="Click Me" />
	
	<br><br>
	<a href="student/showForm">Student Form</a>
	
	<br><br>
	<a href="customer/showForm">Customer Form</a>
</body>

</html>