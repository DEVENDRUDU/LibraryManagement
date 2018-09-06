<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="models.*" %>
    <%@ page import="java.util.*" %>
    <%@ page import="database.Dao" %>
    <%@ page import="java.sql.SQLException" %>
    <%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
body {
background-image:url(image5.jpg);
background-size:100%;

}
.table {
font-color:blue;
font-style: bold;
font-size:16px;
}
</style>
<title>View Books</title>
<!-- <link rel="stylesheet" href="css/bootstrap.min.css"> -->
</head>
<body>
<%@ include file="librarianbase.jsp" %><br><br>
<br>
<div class="container"><br>
	<div class="row"><br>
	<div class="col-md-10">
				
					<% List l=DispModel.getBooks();			
					Object obj[]=l.toArray();%>
					 <table class="table table-bordered">
					 	<tr> 
					 		<td>Book Title</td>
					 		<td>Book Author</td>
					 		<td>Total Copies</td>
					 		<td>Available Copies</td>
					 </tr>
					<%for(Object o:obj){										
		 				 BooksModel sm=(BooksModel)o; %>
		 				
		 				<tr><td>
		 				<form action="bookdetails.jsp" method="post"> 
		 				<input type="submit" style="border:none;background:none" value="<%= sm.getTitle() %>"> 
		 				 <input type="hidden" name="title" value="<%= sm.getTitle() %>">&nbsp;</td>
		 				 </form>
		 				   <td><%= sm.getAuthor() %>&nbsp;</td>
		 				   <td><%= sm.getTotalCopies() %>&nbsp;</td>
		 				   <% String title=sm.getTitle(); %>
		 				   <% String sql="select title from IssueBooks where title='"+title+"'"; %>
		 				   		<% int count=0; %>
		 				   		<% ResultSet rs=Dao.getAllBook(sql); %>
		 				   		<% try { %>
						<% while(rs.next()) { %>
							<% count++; %>
						<% } %>
						<% int t=sm.getTotalCopies(); %>
						
						<% t=t-count;  %>
							 <td><%=t %> </td>
						<% } catch(SQLException e) { %>
							<% e.printStackTrace(); %>
						
						<% } %>
		 				   
		 				   
		 				   </tr>
		 				<% } %>
			</table>
		
	</div>
</div>
</div>
<% session.setAttribute("msg", " "); %>
</body>
</html>