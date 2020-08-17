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
<title>Insert title here</title>
</head>
<body>
	<center>
		<h4>${message}</h4>
	</center>
	<form action="bookingVisit.do" method="post">

		<div class="card text-center"
			style="width: 50rem; margin-top: 20px; margin-left: 200px;">
			<div class="card-header">X-workz</div>
			<div class="card-body">

				




					<div class="form-row">

						<div class="form-group col-md-6">
							<label>Special Entrance</label> <select class="form-control"
								name="specialEntrance">
								<c:forEach items="${SElist}" var="item">
									<option value="${item.propValue}">${item.propName}</option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group col-md-6">
							<label>Date</label> <input type="date" class="form-control"
								name="date">
						</div>
						<div class="form-group col-md-6">
							<label>No Of People</label> <input type="number"
								class="form-control" name="noOfPeople">
						</div>

						<div class="form-group col-md-6">
							<label>Prasada</label> <input type="text" class="form-control"
								name="prasada">
						</div>

						<div class="form-group col-md-6">
							<label>ID Card</label> <select class="form-control" name="idCard">
								<c:forEach items="${IDlist}" var="item">
									<option value="${item.propValue}">${item.propName}</option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group col-md-6">
							<label>ID Number</label> <input type="number"
								class="form-control" name="idNumber">
						</div>

						<div class="form-group col-md-2"></div>

						<div class="form-group col-md-8">
							<label>Pooja Type</label> <input type="text" class="form-control"
								name="poojaType">
						</div>
					</div>
					<input class="btn btn-primary" type="submit" value="Book">



					<a href=" ">Search</a> <br> <br>

					<div class="card-footer text-muted">Copy right x-workz</div>
				</div>
	</form>

</body>
</html>