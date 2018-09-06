<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Librarian Login</title>
<link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>
<%@ include file="base.jsp" %><br><br>
	<div class="container"><br>
	<br><%= session.getAttribute("msg") %><br>
		<div class="row">
			<div class="cols-md-4">
			<form action="librarianlogin" method="post">
				<label><b> <h3>Librarian Login </h3></b></label><br>
				<label>Librarian Id</label>
				<input type="text" name="lid" class="form-control" placeholder="enter id" title="id should be numbers only" pattern="[0-9]*" required>
				
				<label>Password</label>
				<input type="password" name="password" class="form-control" placeholder="password" required><br>
				
				<input type="submit" value="Login" class="btn btn-success">
				<input type="reset" value="reset" class="btn btn-warning">
			</form>
			</div>
		</div>
	</div>
	<% session.setAttribute("msg"," "); %>
</body>
</html>