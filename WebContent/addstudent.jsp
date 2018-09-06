<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add student</title>
</head>
<body>
<%@ include file="librarianbase.jsp" %>
<br><br>

<div class="container"><br>
<%=session.getAttribute("msg") %>
		<div class="row"><br>
			<div class="cols-md-6"><br>
				<form action="addstudent" method="post">
					<label>ADD STUDENT</label><br>
					
					<label>Student Id</label>
					<input type="text" class="form-control" name="sid" placeholder="Student Id" title="enter id use digits" pattern="[0-9]*" required>
					
					<label>Student Name</label>
					<input type="text" class="form-control" name="sname" placeholder="Name" title="enter student name" pattern="[a-zA-Z]*" required>
					
					<label>Course</label>
					<input type="text" class="form-control" name="course" placeholder="Course" title="enter course name" required>
					
					
					<label>Password</label>
					<input type="password" class="form-control" name="password1" required>
					
					<label>Confirm Password</label>
					<input type="password" class="form-control" name="password2">
					<br>
					<input type="submit" value="Add" class="btn-success">
					<input type="reset" value="clear" class="btn-warning">
					
				</form>
			</div>
		</div>
	</div>
	<% session.setAttribute("msg", " "); %>
</body>
</html>