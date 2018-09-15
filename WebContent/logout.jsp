<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
	 <% session.setAttribute("msg"," ");%>
	 <% String value=String.valueOf(session.getAttribute("value")); %>	
	 
	 <% if(value=="librarian") { %> 
			 <% session.invalidate();
			session=request.getSession();
			session.setAttribute("msg"," ");
			response.sendRedirect("librarianlogin.jsp");
		 } %>
	
	<% if(value=="admin") { %> 
		<jsp:forward page="adminlogin.jsp" />
	<% } %>
		
	<% if(value=="student") { %> 
	<jsp:forward page="studentlogin.jsp" />
	<% } %>
	
</body>
</html>