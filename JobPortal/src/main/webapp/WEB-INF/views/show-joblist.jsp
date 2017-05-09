<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Search Result</title>
</head>
<body>

	<c:if test="${empty sessionScope.candidate.firstName}">
		<a href = "index.htm">Session expired, go to home page</a>&emsp;
     </c:if>

	<b><i> '${sessionScope.candidate.firstName }&nbsp;${sessionScope.candidate.lastName}' </i></b> <hr>
	<a href = "goToCandidateHomePage.htm">Home</a>&emsp;
	<a href = "viewAppliedJobs.htm">Check Application Status</a>
<!-- 	<a style="float: right" href="logout.htm"> Logout </a> -->
	<form method="get" style="float: right">
		<input type="submit"  value="Logout" onclick="form.action='logout.htm';">
	</form>
	<hr><br>
	
	<h1>Search Result for  '${sessionScope.jobSearchTitle}' </h1> <hr>
	
	<table border="1" width = "600" >
	<tr>
			<th>Check Box</th>
			<th>Job ID</th>
			<th>Job Title</th>
			<th>Job Type</th>
			<th>Company Name</th>
			<th>Apply</th>
         </tr>
	<c:forEach items="${jobList}" var="jobDetail"> 
		<tr>
			<td><input type="checkbox"/></td>
			<td>${jobDetail.jobId}</td>
            <td>${jobDetail.jobTitle}</td>
            <td>${jobDetail.jobType} </td>
            <td>${jobDetail.industry}</td>
            <td><a href="applyForJob.htm?jobid=${jobDetail.jobId}">Apply</a></td>
         </tr>
   </c:forEach>
    </table>
	
	
</body>
</html>