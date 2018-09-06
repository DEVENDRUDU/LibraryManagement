<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<%@ include file="base.jsp" %><br>
	<br><div class="container"><br>
	<br><%= session.getAttribute("msg") %>
		<div class="row">
			<div class="col-md-6"><br>
				<form action="adminlogin" method="post">
					<label for="admin login"><b><h3>Admin Login </h3></b></label><br>
					<label >Admin Id</label>
					<input type="text" name="adminid" class="form-control" pattern="\d+" placeholder="admin id" title="enter admin id use digits only" required >
					
					<label>Password</label>
					<input type="password" name="password" class="form-control" placeholder="password" title="enter password" required><br>
					
					<input type="submit" class="btn btn-success" value="Login">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="Clear" class="btn btn-warning">
				</form>
			</div>
		</div>
		<% session.setAttribute("msg"," "); %>
	</div>
</body>
</html>