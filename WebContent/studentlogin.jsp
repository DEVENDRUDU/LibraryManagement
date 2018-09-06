<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<%@ include file="base.jsp" %><br>


	<br><div class="container"><br>
		<h5><%=session.getAttribute("msg") %></h5><br>
		<div class="row">
			<div class="cols-md-6">
				<form action="studentlogin" method="post">
					<h3><label><b> Student Login</b></label><br></h3>
					<label>Student id</label>
					<input type="text" name="sid" class="form-control" placeholder="student id" title="id should be numbers only" pattern="[0-9]*" required>
					
					<label>Password</label>
					<input type="password" name="password" class="form-control" placeholder="password" required><br>
					
					<input type="submit" value="Login" class="btn btn-success">
					<input type="reset" value="Clear" class="btn btn-warning">
				</form>
			</div>
		</div>
	</div>
	<% session.setAttribute("msg"," "); %>
</body>
</html>