<%@ include file="./basic.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link href="resources/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<h1>Food Blog</h1>
	</header>
	<nav>
		<a href="about">About</a> <a href="contact">Contact</a> <a
			href="login">Login</a> <a href="signup">Signup</a>
	</nav>
	<section>
		<h1>Welcome to our website with whole joy and love</h1>
		<div class="button-container">!! Hope you find the best blogs
			ever !!</div>
		<c:if test="${ack != null}">
			<div class="container" role="alert">${ack }</div>
		</c:if>
	</section>
</body>
</html>
