<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index</title>
<style>
body, html {
    height: 100%;
    margin: 0;
}

.bg {
    /* The image used */
    background-image: url("library.jpg");

    /* Full height */
    height: 100%; 

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}
</style>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<% session.setAttribute("msg", " "); %>
	<%@ include file="base.jsp" %><br>
	<div class="bg"></div>
	 <!-- <img src="lback.jpg" class="img-rounded" alt="Cinque Terre" width="100%" height="auto" > --> 
</body>
</html>