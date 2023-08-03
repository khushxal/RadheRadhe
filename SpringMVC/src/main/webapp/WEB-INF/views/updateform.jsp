<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./basic.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link href="resources/css/signup.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<h1 class="text-center">Signup</h1>
		<form
			action="${pageContext.request.contextPath}/profile/processform/user/id=${credential.id }"
			method="post" class="needs-validation" novalidate>
			<div class="form-group">
				<label for="email">Email ID</label><br>
				 ${detail.email } <input
					type="hidden" name="email" id="email" class="form-control"
					value="${detail.email }">
				<form:errors path="user_d.email" cssStyle="color: #ff0000;" />
			</div>
			<div class="form-group">
				<label for="name">Name</label> <input type="text" name="name"
					id="name" class="form-control" value="${detail.name }">
				<form:errors path="user_d.name" cssStyle="color: #ff0000;" />
			</div>
			<div class="form-group">
				<label for="mobile">Mobile Number</label> <input type="text"
					name="phone" id="phone" class="form-control"
					value="${detail.phone }">
				<form:errors path="user_d.phone" cssStyle="color: #ff0000;" />
			</div>
			<div class="form-group">
				<label for="dob">Date of Birth</label> <input type="date" name="dob"
					id="dob" class="form-control" placeholder="dd-mm-yyyy"
					max="2005-12-31" value="${detail.dob }">
				<form:errors path="user_d.dob" cssStyle="color: #ff0000;" />
			</div>
			<div class="form-group">
				<label for="gender">Gender</label> <select name="gender" id="gender"
					class="form-control">
					<option value="${detail.gender }">${detail.gender }</option>
					<option value="male">Male</option>
					<option value="female">Female</option>
					<option value="other">Other</option>
				</select>
				<form:errors path="user_d.gender" cssStyle="color: #ff0000;" />
			</div>
			<button type="submit" class="btn btn-primary">Update</button>
		</form>

	</div>
</body>
</html>
