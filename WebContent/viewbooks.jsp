<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="models.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
background-image:url(l9.jpeg);
background-size:100%;

}
.table {
font-color:blue;
font-style: bold;
font-size:16px;
}
</style>

<meta charset="ISO-8859-1">
<title>View Books</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<% String v=String.valueOf(session.getAttribute("value"));%>
<%	if(v==null) {%>
				<jsp:forward page="index.jsp"></jsp:forward>	
			<%}%> 
			
 <% if(session.getAttribute("value").equals("admin")) { %>
 
<%@ include file="adminbase.jsp" %><br>
<br> <br>
<div class="container">
<p><br>View Books</p><br>
	<div class="row">
	<div class="col-md-10">
					<% List l=DispModel.getBooks();			
					Object obj[]=l.toArray();%>
					 <table class="table table-bordered">
					 <tr>
					 <td>Book Title</td>
					 <td>Author</td>
					 <td>No of Copies</td>
					 </tr>
					<%for(Object o:obj){										
		 				 BooksModel sm=(BooksModel)o; %>
		 				
		 			<tr>
		 				<%-- <form action="bookdetails.jsp" method="post"> 
		 				<td><input type="submit" style="border:none;background:none" value="<%= sm.getTitle() %>"> 
		 				<input type="hidden" name="title" value="<%= sm.getTitle() %>">&nbsp;</td>
		 				 </form> --%>
		 				 <td><%=sm.getTitle() %></td>
		 				   <td><%= sm.getAuthor() %>&nbsp;</td>
		 				   <td><%= sm.getTotalCopies() %>&nbsp;</td></tr>
		 				<% } %>
			</table>
		
	</div>
</div>
</div>
<% }  %>
 <% if(session.getAttribute("value").equals("student")) { %>
 
<%@ include file="studentbase.jsp" %><br><br>
<p> View Books</p><br><br>
<div class="container">
	<div class="row">
	<div class="col-md-10">
					<% List l=DispModel.getBooks();			
					Object obj[]=l.toArray();%>
					 <table>
					<%for(Object o:obj){										
		 				 BooksModel sm=(BooksModel)o; %>
		 				
		 				<tr><td>
		 				<form action="bookdetails.jsp" method="post"> 
		 				<input type="submit" style="border:none;background:none" value="<%= sm.getTitle() %>"> 
		 				 <input type="hidden" name="title" value="<%= sm.getTitle() %>">&nbsp;</td>
		 				 </form>
		 				   <td><%= sm.getAuthor() %>&nbsp;</td>
		 				   <td><%= sm.getTotalCopies() %>&nbsp;</td></tr>
		 				<% } %>
			</table>
		
	</div>
</div>
</div>
<% }  %>
<% session.setAttribute("msg", " "); %>

</body>
</html>