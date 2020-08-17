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
<title>LoginSuccess</title>
</head>
<body>

	<form action="book.do" method="post">

		<div class="card text-center"
			style="width: 50rem; margin-top: 20px; margin-left: 200px;">
			<div class="card-header">X-workz</div>
			<div class="card-body">

				<center>
					<h4>${message}</h4>
				</center>


				<a href="booking.do">Book</a> <a href=" ">Search</a>

				<div class="card-footer text-muted">Copy right x-workz</div>
			</div>
	</form>
</body>
</html>