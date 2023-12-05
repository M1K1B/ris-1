<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
	<head>
		<title>Izdavaci</title>
	</head>
	<body>
		<h2>Izdavaci</h2>
		<form method="GET" action="/Biblioteka/knjiga/checkKnjige">
			<select name="izdavac">
				<c:forEach items="${ izdavaci }" var="k">
					<option value="${ k }">${ k }</option>
				</c:forEach>
			</select>
			<input type="submit" value="Proveri">
		</form>
		<br>
		<c:forEach items="${ model }" var ="k">
			${ k.key } za odabranog izdavaca je: ${ k.value } <br>
		</c:forEach>
	</body>
</html>