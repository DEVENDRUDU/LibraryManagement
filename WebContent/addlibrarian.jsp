<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add librarian</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	
<% String v=String.valueOf(session.getAttribute("value"));%>
<%	if(v==null) {%>
				<jsp:forward page="index.jsp"></jsp:forward>	
			<%}%>
			 
<%@ include file="adminbase.jsp" %><br>
<br>

	<div class="container"><br>
	<%=session.getAttribute("msg") %><br>
		<div class="row">
			<div class="cols-md-6">
				<form action="addlibrarian" method="post">
					<center><label> <h3>ADD LIBRARIAN</h3></label></center><br>
					
					<label>Librarian Id</label>
					<input type="text" class="form-control" name="id" placeholder="id" title="enter digits only" pattern="[0-9]*" required>
					
					<label>Librarian name</label>
					<input type="text" class="form-control" name="name" placeholder="Name of the Librarian" title="use character only" pattern="[a-zA-Z]*" required>
					
					<label>Librarian Qualification</label>
					<input type="text" class="form-control" name="qualification" placeholder="Qualification" required>
					
					<label>Address</label>
					<input type="text" class="form-control" name="address" placeholder="Address" required>
					
					<label>Password</label>
					<input type="password" class="form-control" name="password1">
					
					<label>Confirm Password</label>
					<input type="password" class="form-control" name="password2">
					<br>
					<input type="submit" value="Add" class="btn-success">
					<input type="reset" value="clear" class="btn-warning">
					
				</form>
			</div>
		</div>
	</div>
	<% session.setAttribute("msg"," ");%>
</body>
</html>