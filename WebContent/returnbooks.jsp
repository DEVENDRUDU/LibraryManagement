<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="database.Dao" %>
    <%@ page import="java.sql.ResultSet" %>
    <%@ page import="java.sql.SQLException" %>
   <%--  <%@ page errorPage="exceptions.jsp" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
body {
background-image:url(image2.jpg);
background-size:100%;

}
.table {
font-color:blue;
font-style: bold;
font-size:16px;
}
</style>
<title>Return Books</title>
</head>
<body> 
		<jsp:include page="librarianbase.jsp" /><br>
		<% String sql="select * from IssueBooks"; %><br>
		<%ResultSet rs=Dao. getAllBook(sql); %><br>
			<div class="container"><br>
			<%= session.getAttribute("msg") %>
				<div class="row"><br>
					<div class="col-md-10"><br>
					<table class="table table-bordered">
						<tr>
							<td>Student Id</td>
							<td>Book Id</td>
							<td>Book Title</td>
							<td>Issue Date</td>
							<td>Return Date</td>
							<td></td>
						</tr>
						<% try { %>
						<% while(rs.next()) { %>
						<tr>
							<form action="returnbook" method="post">
								<td><%= rs.getInt(1) %></td>
								<td><%= rs.getInt(2) %></td>
								<input type="hidden" name="bid" value="<%= rs.getInt(2) %>">
								<td><%= rs.getString(3) %></td>
								<td><%= rs.getString(4) %></td>
								<td></td>
								<td> <input type="submit" value="Return"  class="btn btn-success"></td>
							</form>
						</tr>
						<% } %>
						<% } catch(SQLException e) { %>
							<% e.printStackTrace(); %>
						
						<% } %>
						
			</table>		
		</div>
	</div>
</div>
<% session.setAttribute("msg"," "); %>
</body>
</html>