<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="models.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Books</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<%@ include file="studentbase.jsp" %><br>
	<% Integer sid1=(Integer)session.getAttribute("sid");%>
	
	<%StudentModel sm=new StudentModel();%><br>
	<% sm.setSid(sid1); %><br>
	<div class="container">
	<div class="row">
		<div class="cols-md-8">
		<% List l=DispModel.getMyBooks(sm); %><br>
		<% Object obj[]=l.toArray(); %>
		<table class="table table-bordered">
		<tr>
			<td>Book Id</td>
			<td> Book Title</td>
			<td> Issue Date</td>
		</tr>
		<% for(Object o:obj) { %>
		<% IBModel im=(IBModel)o; %>
		<tr>
		<td><%= im.getBId() %></td>
		<td><%= im.getTitle() %></td>
		<td><%= im.getIssueDate()%></td>
		</tr>
		<% } %>
		</table>
	</div>
	</div>
	</div>
</body>
</html>