<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Posted Jobs</title>
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
	
	<H1>View all Posted Jobs</H1>
	<table border = 1 width = "800">
	<tr>
		<th>Job Id</th>
		<th>Job title</th>
		<th>Type</th>
		<th>Job Description</th>
		<th>Status</th>
		<th>Action</th>
		<th>View and Update Application Status</th>
		
	</tr>
	<c:forEach items="${postedJobs}" var="jobDetail"> 
		<tr>
			<td>${jobDetail.jobId}</td>
            <td>${jobDetail.jobTitle}</td>
            <td>${jobDetail.jobType} </td>
            <td>${jobDetail.jobDescription}</td>
            <td id = "${jobDetail.jobId}" >${jobDetail.status}</td>
            <td><input type="button" value = "Disable" onclick="javascript:updateStatus(${jobDetail.jobId})"/></td>
            <td><a href="changeStatus.htm?id=${jobDetail.jobId}">View and Update</a></td>
         </tr>
   </c:forEach>
    </table>
          
 <script type="text/javascript">
 	function updateStatus(jobId){
 		var xmlhttp = new XMLHttpRequest();
 		xmlhttp.onreadystatechange = function(){
 			if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
 				document.getElementById(jobId).innerHTML = xmlhttp.responseText;
 			}
 		}
 		xmlhttp.open("POST", "updateJobStatus.htm", true);
 		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
 		xmlhttp.send("jobId="+jobId);
 	}
 </script>           
</body>
</html>