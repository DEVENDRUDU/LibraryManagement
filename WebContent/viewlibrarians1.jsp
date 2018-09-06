<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.ResultSet" %>
    <%@ page import="database.*" %>
    <%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view librarians</title>
<style type="text/css">
body {
background-image:url(l8.jpeg);
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

<% String v=String.valueOf(session.getAttribute("value"));%>
<%	if(v==null) {%>
				<jsp:forward page="index.jsp"></jsp:forward>	
			<%}%> 
			
<jsp:include page="adminbase.jsp"/><br>
<br>
<% ResultSet rs=Dao.getLib(); %><br>
<br>

<div class="container">
<%=session.getAttribute("msg") %><br>
 	 <h3>Librarian List</h3>
	<div class="row" >
		<div class="col-md-10">
	<table class="table table-bordered" >
		<tr>
			<td>Librarina Id</td>
			<td>Name</td>
			<td>Qualification</td>
			<td>Address</td>
			
			<td></td><td></td>
			</tr>
			<tr></tr>
			<% try {
				while (rs.next())
				{%>
					<tr>
						<form action="librarianmodification" method="post">
							<td><input type="text" name="lid" value="<%= rs.getInt(1) %>" style="border:none;background:none" class="form-control"></td>
							<td><input type="text" name="name" value="<%= rs.getString(2) %>" style="border:none;background:none" class="form-control"></td>
							<td><input type="text" name="qualification" value=" <%= rs.getString(3) %>" style="border:none;background:none" class="form-control"></td>
							<td> <input type="text" name="address" value="<%= rs.getString(4) %>" style="border:none;background:none" class="form-control"></td>
							
							<td> <input type="submit" name="delete" value="Delete" style="border:none;background:none" ></td>
							<td><input type="submit" name="update" value="Update"style="border:none;background:none"></td>
						</form>
					</tr>
				<%}
			} catch(SQLException e) {
				
			}%>
	</table>
	</div>
	</div>
</div>
<% session.setAttribute("msg"," "); %>
</body>
</html>