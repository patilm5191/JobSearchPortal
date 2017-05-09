<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Applied Jobs</title>
</head>
<body>
	<b><i> '${sessionScope.candidate.firstName }&nbsp;${sessionScope.candidate.lastName}' </i></b> <hr>
	<a href = "goToCandidateHomePage.htm">Home</a>&emsp;
	<a href = "viewAppliedJobs.htm">Check Application Status</a>
<!-- 	<a style="float: right" href="logout.htm"> Logout </a> -->
	<form method="get" style="float: right">
		<input type="submit"  value="Logout" onclick="form.action='logout.htm';">
	</form>
	<hr><br>
	
	<table border="1" width = "500">
		<tr>
			<th>Application Id</th>
			<th>Job Id</th>
			<th>Job Title</th>
			<th>Company Name</th>
			<th>Application Status</th>
		</tr>
		<c:forEach items="${appliedJobs}" var="application"> 
		<tr>
			<td>${application.applicationId}</td>
			<td>${application.job.jobId}</td>
			<td>${application.job.jobTitle}</td>
			<td>${application.job.industry}</td>
			<td>${application.status}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>