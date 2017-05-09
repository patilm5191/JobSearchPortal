<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Applied Jobs</title>
</head>
<body>
	<b>'${sessionScope.recruiter.firstName}&nbsp;${sessionScope.recruiter.lastName}' </b>
	<a style="float: right" href="logout.htm"> Logout </a>
	<hr><br>
	<nav>
		<ul>
		<li><a href = "goToRecruiterHomePage.htm">Home</a></li>
		<li><a href = "postnewjob.htm">Post New Job</a></li>
		<li><a href = "viewpostedjobs.htm">View Posted Jobs</a></li>
		</ul>
	</nav>
	<hr><br>
	
<table style="width:100%">
  <tr>
    <th>Job Title</th>
    <th>Position</th> 
    <th>Status</th>
  </tr>
   <c:forEach items="${sessionScope.jobList}" var="job"> 
                           
  <tr>
    <td>${job.title}</td>
    <td>${job.position}</td> 
    <td>${job.status}</td>
  </tr>
 </c:forEach>
</table>

</body>
</html>