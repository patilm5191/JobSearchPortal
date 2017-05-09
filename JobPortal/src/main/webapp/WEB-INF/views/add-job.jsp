<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
	<title>Post New Job</title>
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


	<form:form action = "postnewjob.htm" commandName="jobPost" method = "post">
		<table border = 1>
			<tr>
				<td>Job Title:</td>
				<td><form:input  path="jobTitle"/>
					<font color="red"><form:errors path="jobTitle" /></font></td>
			</tr>
			<tr>
				<td>Job Type:</td>
				<td><form:input path="jobType"/>
				<font color="red"><form:errors path="jobType" /></font></td>
			</tr>
			<tr>
				<td>Company Name:</td>
				<td><form:input path="industry" />
				<font color="red"><form:errors path="industry" /></font></td>
			</tr>
			<tr>
				<td>Job Description:</td>
				<td><form:input rows="6" cols="25" path="jobDescription" />
				<font color="red"><form:errors path="jobDescription" /></font></td>
			</tr>
			<tr>
				<td>Number of Openings:</td>
				<td><form:input path="numberOfOpenings"/>
				<font color="red"><form:errors path="numberOfOpenings" /></td>
			</tr>
			<tr>
				<td>Compensation:</td>
				<td><input type="text" name="compensation"/></td>
			</tr>
			<tr>
				<td>Bonus Amount:</td>
				<td><input type="text" name="bonusAmount"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Post Job" /></td>
			</tr>		
		</table>
	</form:form>
	
	
<!-- 	<form action = "postnewjob.htm" method = "post"> -->
<!-- 		<table border = 1> -->
<!-- 			<tr> -->
<!-- 				<td>Job Title:</td> -->
<!-- 				<td><input type="text" name="jobTitle"/></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Job Type:</td> -->
<!-- 				<td><input type="text" name="jobType"/></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Company Name:</td> -->
<!-- 				<td><input type="text" name="industry"/></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Job Description:</td> -->
<!-- 				<td><Textarea rows="6" cols="25" name="jobDescription" ></Textarea></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Number of Openings:</td> -->
<!-- 				<td><input type="text" name="numberOfOpenings"/></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Compensation:</td> -->
<!-- 				<td><input type="text" name="compensation"/></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Bonus Amount:</td> -->
<!-- 				<td><input type="text" name="bonusAmount"/></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td colspan="2"><input type="submit" value="Post Job" /></td> -->
<!-- 			</tr>		 -->
<!-- 		</table> -->
<!-- 	</form> -->
</body>
</html>