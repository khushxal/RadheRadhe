<%@page import="com.springmvc.model.UserCredentials"%>
<%@page import="com.springmvc.model.UserDetails"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="false"%>
<%@page isELIgnored="false"%>
<%@ include file="./basic.jsp"%>
<!DOCTYPE html>
<%
response.setHeader("Cache-Control", "private , no-cache , no-store");
response.setHeader("Pragma", "no-cache");
HttpSession session = request.getSession(false);
UserDetails details = (UserDetails) session.getAttribute("detail");
UserCredentials credentials = (UserCredentials) session.getAttribute("credential");
%>
<html>
<head>
<link href="resources/css/home.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<div class="landing-content">
			<h1>Welcome to the Food Blog</h1>
			<p>
				${message } Hello, <strong> <%
 out.print(details.getName());
 %></strong>! <br>Your ID is
				<%
 out.print(credentials.getId());
 %>
				Keep it remember while logging in
			</p>
			<a href="file/upload">Uplaod</a> <a href="logout">Logout</a> <a
				href="profile/user/id=<%=credentials.getId()%>">Profile</a>
		</div>
	</div>
</body>
</html>