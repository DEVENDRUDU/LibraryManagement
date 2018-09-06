<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="models.LibrarianModel" %>
    <%@ page import="models.*" %>
    <%@ page import="java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Librarians</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<% String v=String.valueOf(session.getAttribute("value"));%>
<%	if(v==null) {%>
				<jsp:forward page="index.jsp"></jsp:forward>	
			<%}%> 
	
<%@ include file="adminbase.jsp" %>
<%@ taglib  uri ="http://java.sun.com/jsp/jstl/core"  prefix = "c"%>

<p> View Librarian
<br><br>
<div class="container">
	<div class="row">
		<div class="cols-md-6">
			
			<%! List l=DispModel.getLibrarians(); %>
			<% Object obj[]=l.toArray(); %>
			<table>
			<% for(Object o:obj){
			LibrarianModel lm=(LibrarianModel)o;%>
				<tr><td>
		 			<form action="librarianmodification" method="post">
		 			
						<input type="text" name="lid" value="<%=lm.getLId() %>" >
						<input type="text" name="name" value="<%= lm.getName() %>" >
						<input type="text" name="qualification" value="<%= lm.getQualification() %>"> 
						<input type="text" name="address" value="<%= lm.getAddress() %>" >
						<input type="submit" style="border:none;background:none" name="up" value="update" >
						<input type="submit" style="border:none;background:none" name="del" value="delete">
					</form></td></tr>
				<%}%>		
				</table>
		</div>
	</div>
</div>
</body>
</html>