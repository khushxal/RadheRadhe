<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.Date"%>
<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="./basic.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link href="resources/css/contact.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<h1 class="text-center">Contact Us</h1>
		<form action="submitcontact" method="post" class="needs-validation"
			novalidate>
			<div class="form-group">
				<label for="name">Name</label> <input type="text" name="name"
					id="name" class="form-control" required>
				<form:errors path="contact.name" cssStyle="color: #ff0000;" />
			</div>
			<div class="form-group">
				<label for="email">Email</label> <input type="email" name="email"
					id="email" class="form-control" required>
				<form:errors path="contact.email" cssStyle="color: #ff0000;" />
			</div>
			<div class="form-group">
				<label for="message">Message</label>
				<textarea name="message" id="message" class="form-control" rows="5"
					required></textarea>
				<form:errors path="contact.message" cssStyle="color: #ff0000;" />
			</div>
			<input type="hidden" name="doq" value="${doq }">
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>
