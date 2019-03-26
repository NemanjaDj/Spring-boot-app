<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="/css/login.css" rel="stylesheet">
</head>
<body>

	<div class="login-page">
		<div class="form">
			<form action="/saveUser" method="POST" class="login-form">
				<input type="text" name="username" placeholder="username" />
				<input type="password" name="password" placeholder="password" />
				<button>create</button>
				<p>
					Already registered? <a href="/login">Sign In</a>
				</p>
			</form>
		</div>
	</div>
</body>

</html>