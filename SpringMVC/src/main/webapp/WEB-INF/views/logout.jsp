<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./basic.jsp"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%
	response.setHeader("Cache-Control", "private , no-cache , no-store , must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.sendRedirect("login");
	%>
</body>
</html>