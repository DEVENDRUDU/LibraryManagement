<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
background-image:url(l2.jpg);
background-size:100%;

}
.table {
font-color:blue;
font-style: bold;
font-size:16px;
}
</style>

<meta charset="ISO-8859-1">
<title>Admin Home</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<% session.setAttribute("msg"," "); %>
	<% String v=String.valueOf(session.getAttribute("value"));%>
<%	if(v==null) {%>
				<jsp:forward page="index.jsp"></jsp:forward>	
			<%} else  {%> 
			
	<%@ include file="adminbase.jsp" %>
	<%} %>
</body>
</html>