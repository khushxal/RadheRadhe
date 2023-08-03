<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./basic.jsp"%>
<%
HttpSession session = request.getSession();
request.setAttribute("sessionId", session.getId());
%>
<!DOCTYPE html>
<html>
<head>
<link href="resources/css/signup.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<h1 class="text-center">Signup</h1>
		<form action="registration" method="post" class="needs-validation"
			novalidate>
			<div class="form-group">
				<label for="email">Email ID</label> <input type="email" name="email"
					id="email" class="form-control" required>
				<form:errors path="user_d.email" cssStyle="color: #ff0000;" />
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					name="password" id="password" class="form-control" required>
				<form:errors path="user_c.password" cssStyle="color: #ff0000;" />
			</div>
			<div class="form-group">
				<label for="name">Name</label> <input type="text" name="name"
					id="name" class="form-control" required>
				<form:errors path="user_d.name" cssStyle="color: #ff0000;" />
			</div>
			<div class="form-group">
				<label for="mobile">Mobile Number</label> <input type="text"
					name="phone" id="phone" class="form-control" required>
				<form:errors path="user_d.phone" cssStyle="color: #ff0000;" />
			</div>
			<div class="form-group">
				<label for="dob">Date of Birth</label> <input type="date" name="dob"
					id="dob" class="form-control" placeholder="dd-mm-yyyy"
					required="required" max="2005-12-31">
				<form:errors path="user_d.dob" cssStyle="color: #ff0000;" />
			</div>
			<div class="form-group">
				<label for="gender">Gender</label> <select name="gender" id="gender"
					class="form-control" required>
					<option value="">Select Gender</option>
					<option value="male">Male</option>
					<option value="female">Female</option>
					<option value="other">Other</option>
				</select>
				<form:errors path="user_d.gender" cssStyle="color: #ff0000;" />
			</div>
			<input type="hidden" name="session" value="${sessionId }">
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

	</div>
</body>
</html>
