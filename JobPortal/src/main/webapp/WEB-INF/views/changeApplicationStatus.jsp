<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Application Status</title>
</head>
<body>
	<b>'${sessionScope.recruiter.firstName}&nbsp;${sessionScope.recruiter.lastName}' </b>
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
	
	<table border="1" width = "500">
	<tr>
			<th>Application Id</th>
			<th>Candidate Name</th>
			<th>Status</th>
			<th>Change Status</th>
			<th>Update</th>
         </tr>
	<c:forEach items="${jobs}" var="job"> 
		
		<tr><form action="updateAppStatus.htm" method = "POST">
			<input type="hidden" name="appId" value="${job.applicationId}"/>
			<input type="hidden" name="jobId" value="${job.job.jobId}"/>
			<td>${job.applicationId}</td>
			<td>${job.candidate.firstName}&nbsp;${job.candidate.lastName}</td>
<%-- 			<td>${job.job.industry}</td> --%>
			<td>${job.status}</td>
            <td><select name="status">
            	<option value="Review">Review</option>
            	<option value="Accept">Accept</option>
            	<option value="Decline">Decline</option>
            	</select>
            </td>
            <td><input type="submit" value="Update" />
            </td>
            </form>
         </tr>
   </c:forEach>
    </table>

</body>
</html>