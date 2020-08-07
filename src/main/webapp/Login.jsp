<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>LoginPage</title>
</head>
<body>
	<center>
		<h4>${message}</h4>
	</center>
	<form action="sendDetails.do" method="post">

		<div class="card text-center"
			style="width: 50rem; margin-top: 20px; margin-left: 200px;">
			<div class="card-header">
				X-workz <a href="Register.jsp">Register</a> <a
					href="SendDetails.jsp">ResendDetails</a>
			</div>
			<div class="card-body">

				<div class="form-row">

					<div class="form-group col-md-4"></div>

					<div class="form-group col-md-4">
						<label>Email</label> <input type="email" class="form-control"
							name="email">
					</div>
					<div class="form-group col-md-4"></div>
					<div class="form-group col-md-4"></div>
					<div class="form-group col-md-4">
						<label>Password</label> <input type="password"
							class="form-control" name="password">
					</div>
				</div>

				<input class="btn btn-primary" type="submit" value="Login">
				<a href="GeneratePassword.jsp">FirstTimeLogin</a> <br> <br>

				<div class="card-footer text-muted">Copy right x-workz</div>
			</div>
	</form>
</body>
</html>