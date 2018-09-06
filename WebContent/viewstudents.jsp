<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="models.*" %>
    <%@ page import="database.*" %>
    <%@ page import="java.util.*" %>
    <%@ page import="java.sql.ResultSet" %>
    <%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
background-image:url(l7.jpg);
background-size:100%;

}
.table {
font-color:blue;
font-style: bold;
font-size:16px;
}
</style>

<meta charset="ISO-8859-1">
<title>view students</title>
</head>
<body>

<% String v=String.valueOf(session.getAttribute("value"));%>
<%	if(v==null) {%>
				<jsp:forward page="index.jsp"></jsp:forward>	
			<%}%> 
			
 	<% if(session.getAttribute("value").equals("admin")) { %>
<%@ include file="adminbase.jsp" %><br>
<br><br>

<div class="container"><br>
	<div class="row">
	<div class="col-md-10">
	<center><h2> Students List </h2></center><br>
					<% List l=DispModel.getStudent();			
					Object obj[]=l.toArray();%>
					 <table class="table table-bordered">
					 <tr>
					 	<td>Student Id</td>
					 	<td>Student Name</td>
					 	<td>Course</td>
					 </tr>
					 
					<%for(Object o:obj){										
		 				 StudentModel sm=(StudentModel)o; %>
		 				
		 				<tr><td><%= sm.getSid() %>&nbsp;</td>
		 				<td>  <%= sm.getSname() %>&nbsp;</td>
		 				   <td><%= sm.getCourse() %>&nbsp;</td></tr>
		 				   				
			<% } %>
			</table>
		
	</div>
</div>
</div>
<% } %>

 	<% if(session.getAttribute("value").equals("librarian")) { %>
<%@ include file="librarianbase.jsp" %>
<br><br>
<% String sql="select * from Students"; %>
<% ResultSet rs=Dao.getStudents(sql); %><br>
<br>

<div class="container"><br>
<%=session.getAttribute("msg") %><br>
 	 <h3>Student List</h3>
	<div class="row" >
		<div class="col-md-10">
			<table class="table table-bordered" >
				<tr>
					<td>Student Id</td>
					<td>Name</td>
					<td>Course</td>
					<td>Address</td>
					
					<td></td><td></td>
					</tr>
					<tr></tr>
			<% try {
				while (rs.next())
				{%>
					<tr>
						<form action="studentmodifications" method="post">
							<td><input type="text" name="sid" value="<%= rs.getInt(1) %>" style="border:none;background:none" class="form-control"></td>
							<td><input type="text" name="sname" value="<%= rs.getString(2) %>" style="border:none;background:none" class="form-control"></td>
							<td><input type="text" name="course" value=" <%= rs.getString(3) %>" style="border:none;background:none" class="form-control"></td>
							<td> <input type="text" name="password" value="<%= rs.getString(4) %>" style="border:none;background:none" class="form-control"></td>
							
							<td> <input type="submit" name="delete" value="Delete" style="border:none;background:none" ></td>
							<!-- <td><input type="submit" name="update" value="Update"style="border:none;background:none"></td> -->
						</form>
					</tr>
				<%}
			} catch(SQLException e) {
				
			}%>
	</table>
	</div>
	</div>
</div>

<%} %>
<% session.setAttribute("msg", " "); %>
</body>
</html>