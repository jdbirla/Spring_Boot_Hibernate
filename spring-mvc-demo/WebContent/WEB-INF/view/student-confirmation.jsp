<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>Student confirmation
</head>

<body>
	The student is confirmed : ${student.firstName} ${student.lastName}
	<br>
	<br> Country : ${student.country}
	<br>
	<br> Favorite Language : ${student.fav}

	<br>
	<br> Operating Systems:
	<ul>
		<c:forEach var="abc" items="${student.os}" >
			<li>${abc}</li>
		</c:forEach>
	</ul>

</body>
</html>