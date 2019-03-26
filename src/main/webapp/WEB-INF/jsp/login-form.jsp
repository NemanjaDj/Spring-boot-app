<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="login-page">
		<div class="form">
			<form action="/login" 
			class="login-form" method="POST">
				<input type="text" name="username" placeholder="username" />
				 <input type="password" name="password" placeholder="password" />
				<button>login</button>
				<p>
					Not registered? <a href="/registration">Create an account</a>
				</p>
			</form>
		</div>
	</div>
</body>
</html>