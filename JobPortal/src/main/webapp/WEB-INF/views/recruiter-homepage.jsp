<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recruiter Home Page</title>
</head>
<body>
	<h1><b>'${sessionScope.recruiter.firstName}&nbsp;${sessionScope.recruiter.lastName}' </b></h1>
	
	
<!-- 	<a style="float: right" href="logout.htm"> Logout </a> -->
	<form method="get" style="float: right">
		<input type="submit"  value="Logout" onclick="form.action='logout.htm';">
	</form>
	<hr><br>
	<nav>
		<ul>
		<li><a href = "goToRecruiterHomePage.htm">Home</a></li>
		<li><a href = "postnewjob.htm">Post New Job</a></li>
		<li><a href = "viewpostedjobs.htm">View Posted Jobs</a></li>
		</ul>
	</nav>
	<hr><br>
</body>
</html>