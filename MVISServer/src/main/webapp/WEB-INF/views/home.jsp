<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<c:choose>
	<c:when test="${users.size() > 0}">
		<c:forEach items="${users}" var="entry">
				<p>User.name = ${entry.key}
		</c:forEach>
	</c:when>
	<c:otherwise>
		<p> No users detected. 
	</c:otherwise> 
</c:choose>
</body>
</html>
