<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="models.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Books</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body> 
<%@ include file="studentbase.jsp" %><br><br>

<div class="container">
	<div class="row"><br>
	<div class="col-md-10"><br>
					<% List l=DispModel.getBooks();			
					Object obj[]=l.toArray();%>
					 <table class="table table-bordered" >
					 <tr>
					 	<td>Book Title</td>
					 	<td>Book Author</td>
					 	<td>Total Copies</td>
					 	
					<%for(Object o:obj){										
		 				 BooksModel sm=(BooksModel)o; %>
		 				
		 				<tr><td>
		 				<form action="bookdetails.jsp" method="post"> 
		 				<input type="submit" style="border:none;background:none" value="<%= sm.getTitle() %>"> 
		 				 <input type="hidden" name="title" value="<%= sm.getTitle() %>">&nbsp;</td>
		 				 </form>
		 				   <td><%= sm.getAuthor() %>&nbsp;</td>
		 				   <td><%= sm.getTotalCopies() %>&nbsp;</td>
		 				   
		 				   </tr>
		 				<% } %>
			</table>
		
	</div>
</div>
</div>

</body>
</html>