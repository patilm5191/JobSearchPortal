<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apply to the Job</title>
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
	
	<form:form action="applyForJob.htm?jobid=${job.jobId}" modelAttribute="submitApplication" method = "post" enctype="multipart/form-data">
		<table border=1 width = "400">
			<tr>
				<td>Company Name</td>
				<td>${job.industry}</td>
		 	</tr>
			<tr>
				<td>Job Id</td>
				<td>${job.jobId}</td>
		 	</tr>
			<tr>
				<td>Title</td>
				<td>${job.jobTitle}</td>
			</tr>
			<tr>
				<td>Job Type</td>
				<td>${job.jobType}</td>
			</tr>
			<tr>
				<td>Job Description</td>
				<td>${job.jobDescription}</td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td>File Name</td> -->
<!-- 				<td><input type="text" name="filename" /></td> -->
<!-- 			</tr> -->
			<tr>
				<td>Upload Resume</td>
				<td><input type="file" name="resume" /></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Apply" />
	</form:form>

	
<%-- 	<form action="applyForJob.htm?jobid=${job.jobId}" method = "post" enctype="multipart/form-data"> --%>
<!-- 		<table border=1 width = "400"> -->
<!-- 			<tr> -->
<!-- 				<td>Company Name</td> -->
<%-- 				<td>${job.industry}</td> --%>
<!-- 		 	</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Job Id</td> -->
<%-- 				<td>${job.jobId}</td> --%>
<!-- 		 	</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Title</td> -->
<%-- 				<td>${job.jobTitle}</td> --%>
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Job Type</td> -->
<%-- 				<td>${job.jobType}</td> --%>
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Job Description</td> -->
<%-- 				<td>${job.jobDescription}</td> --%>
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td><input type="text" name="filename" /></td> -->
<!-- 				<td><input type="file" name="resume" /></td> -->
<!-- 			</tr> -->
			
<!-- 		</table> -->
<!-- 		<br> -->
<!-- 		<input type="submit" value="Apply" /> -->
<!-- 	</form> -->

</body>
</html>