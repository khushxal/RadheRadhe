<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@ include file="./basic.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link href="resources/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<form class="login-form" action="validate" method="post">
			<h1>Login</h1>
			<input type="text" name="id" placeholder="ID provided after Signup "
				required value="<c:if test="${id != null}">${id }</c:if>"> <input
				type="password" name="password" placeholder="Password" required
				value="<c:if test="${password != null}">${password }</c:if>">
			<button type="submit">Login</button>
			<br> <br>
			<c:if test="${ack != null}">
				<div class="alert alert-danger" role="alert">${ack }</div>
			</c:if>
			<div>
				<a href="signup">Don't having a account</a>
			</div>
		</form>
	</div>
</body>
</html>
