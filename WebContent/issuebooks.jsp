<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>issue books</title>
</head>
<body>
<%@ include file="librarianbase.jsp" %><br>
<br>
	<div class="container"><br>
	<br><%= session.getAttribute("msg") %><br>
		<div class="row">
			<div class="cols-md-6">
				
				<form action="issuebooks" method="post">
					<label for="Issue Books"><h4>Issue Books Form</h4></label><br>
					
					<label>Student Id</label>
					<input type="text" name="sid" class="form-control" placeholder="Student SId" title="enter Student id" pattern="[0-9]*" required>
					
					<label> Book Id </label>
					<input type="text" name="bid" class="form-control"placeholder="Book SId" title="enter Book id" pattern="[0-9]*" required>
					
					<label> Book Title</label>
					<input type="text" name="title" class="form-control" placeholder="Book Title" tilte="Enter book Title" required><br>
					
					<input type="submit"  name="action" value="issue" class="btn btn-success">
					<input type="reset" value="clear" class="btn btn-warning">
					
				</form>
			</div>
		</div>
	</div>
	<% session.setAttribute("msg", " "); %>
</body>
</html>