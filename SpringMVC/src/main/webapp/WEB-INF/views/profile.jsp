<%@ include file="./basic.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link href="resources/css/profile.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<h1 class="text-center">User Profile</h1>
		<div class="form-group">
			<label for="id">ID : </label> ${credential.id }
		</div>
		<div class="form-group">
			<label for="name">Name : </label> ${detail.name }
		</div>
		<div class="form-group">
			<label for="email">Email : </label> ${detail.email }
		</div>
		<div class="form-group">
			<label for="mobile">Mobile Number : </label> ${detail.phone }
		</div>
		<div class="form-group">
			<label for="dob">Date of Birth : </label> ${detail.dob }
		</div>
		<div class="form-group">
			<label for="gender">Gender : </label> ${detail.gender }
		</div>
		<a
			href="${pageContext.request.contextPath}/profile/updateform/user/id=${credential.id}"><button>Update</button></a>
		<%-- <a href="${pageContext.request.contextPath }/"><button>Back</button></a> --%>
		<a href=""></a>
	</div>
</body>
</html>
