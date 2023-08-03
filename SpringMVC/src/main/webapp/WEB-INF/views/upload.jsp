<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./basic.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload Photo</title>
</head>
<body>
	<form action="savefile" enctype="multipart/form-data">
		<input type="file" placeholder="Upload File here" name="d" id="d">
		<button type="submit">save</button>
	</form>
</body>
</html>