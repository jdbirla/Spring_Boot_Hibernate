<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
<title>Customer confirmation</title>

</head>
<body>

First Name : ${customer.firstName}
<br>
Last Name  : ${customer.lastName}
<br>
Free Passes : ${customer.freePasses}
<br>
Postal Code : ${customer.postalCode}

<br>
Course Code : ${customer.courseCode}
</body>
</html>