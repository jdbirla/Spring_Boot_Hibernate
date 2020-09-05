<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<h2>Student form</h2>
</head>

<body>
	<form:form action="processForm" modelAttribute="student">
   
   FIRST NAME : <form:input path="firstName" />

		<br>
		<br>
   Last NAME : <form:input path="lastName" />
		<br>
		<br>

		<form:select path="country">

			<form:options items="${student.countryOption}" />
		</form:select>
		<br>
		<br>
		Favorite Language :
		Java <form:radiobutton path="fav" value="Java" />
		PHP <form:radiobutton path="fav" value="PHP" />
		Ruby <form:radiobutton path="fav" value="Ruby" />

		<br>
		<br>
		
		Operating System:
		
		  Windows <form:checkbox path="os" value="Windows" />
		  MAC OS  <form:checkbox path="os" value="MAC" />
		  Linux <form:checkbox path="os" value="Linux" />

		<br>
		<br>


		<input type="submit" value="Submit">
	</form:form>

</body>
</html>