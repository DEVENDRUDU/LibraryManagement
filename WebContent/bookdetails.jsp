<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="models.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Details</title>
<style type="text/css">
body {
background-image:url(pink.jpg);
background-size:100%;

}
.table {
font-color:blue;
font-style: bold;
font-size:16px;
}
</style>

<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>


<% if(session.getAttribute("value").equals("admin"))  {%>
<div class="container">
	<a href="viewbooks.jsp">Return To View Books Page</a><br><br>
	
	<% String title=request.getParameter("title"); %>
	<%= title %>&nbsp;book Ids<br>
	<% List l=DispModel.getBookDetails(title);	%><br>
	<% Object obj[]=l.toArray(); %><br>book id<br>
	<% for(Object o:obj)
		{%>
		<% BookIdModel b=(BookIdModel)o; %>
		<%= b.getBId() %>
		<br>
		<%} %>
	<%}%>
	
	<%if(session.getAttribute("value").equals("librarian")) { %>	
		<a href="viewbooksinlibrarian.jsp">return view books page</a><br><br>
	
	<% String title=request.getParameter("title"); %>
	<%= title %>&nbsp;book Ids<br>
	<% List l=DispModel.getBookDetails(title);	%><br>
	<% Object obj[]=l.toArray(); %><br>book id<br>
	<% for(Object o:obj)
		{%>
		<% BookIdModel b=(BookIdModel)o; %>
		<%= b.getBId() %>
		<br>
		<% } %>
	<%}%>
	
	
	<%	if(session.getAttribute("value").equals("student")) {%>
	<a href="viewbooksinstudent.jsp">return view books page</a><br><br>
	
	<% String title=request.getParameter("title"); %>
	<%= title %>&nbsp;book Ids<br>
	<% List l=DispModel.getBookDetails(title);	%><br>
	<% Object obj[]=l.toArray(); %><br>book id<br>
	<% for(Object o:obj)
		{%>
		<% BookIdModel b=(BookIdModel)o; %>
		<%= b.getBId() %>
		<br>
		<% } %>
	<% } %>
	
</div>
</body>
</html>