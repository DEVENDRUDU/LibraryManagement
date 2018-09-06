<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Books</title>
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
		<br><%=session.getAttribute("msg") %><br>
		<br><div class="row">
			<div class="cols-md-6">
				<form action="addbooks" method="post">
					<label>ADD BOOKS</label><br>
					
					<label>Book Title</label>
					<input type="text" class="form-control" name="title" required>
					
					<label>Book Author</label>
					<input type="text" class="form-control" name="author" required>
					
					<label>Total no of copies</label>
					<input type="text" class="form-control" name="total" >
				
					<br>
					<input type="submit" value="Add" class="btn-success">
					<input type="reset" value="clear" class="btn-warning">
					
				</form>
			</div>
		</div>
	</div>
	<%session.setAttribute("msg"," "); %>
</body>
</html>