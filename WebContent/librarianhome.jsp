<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
body {
background-image:url(im.jpg);
background-size:100%;

}
.table {
font-color:blue;
font-style: bold;
font-size:16px;
}
</style>

<title>Librarian Home</title>
</head>
<body>
<% session.setAttribute("msg", " "); %>
	<%@ include file="librarianbase.jsp" %><br><br>
	 <%  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  	if(session.getAttribute("value")==null)
	 	{
	 		response.sendRedirect("/LibraryManagement/adminlogin.jsp");
	 	}
  	 %>   <br>
</body>
</html>