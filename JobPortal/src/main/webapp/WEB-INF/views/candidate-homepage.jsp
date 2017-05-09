<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidate Homepage</title>
</head>
<body>
<%-- 	<c:if test="${empty sessionScope.candidate.firstName}"> --%>
<!-- 		<a href = "index.htm">Session expired, go to home page</a>&emsp; -->
<%--      </c:if> --%>
	<b><i> '${sessionScope.candidate.firstName }&nbsp;${sessionScope.candidate.lastName}' </i></b> <hr>
	<a href = "goToCandidateHomePage.htm">Home</a>&emsp;
	<a href = "viewAppliedJobs.htm">Check Application Status</a>&emsp;
	<a href = "updateCandidatedetails.htm">View and Update details</a>
	<form method="get" style="float: right"><input type="submit"  value="Logout" onclick="form.action='logout.htm';"> </form>
	
	<hr><br>
	
	<form action="searchJob.htm" method="post">
	<table width = "400">
		<tr>
			<th >Job Title</th>
			<td><input type = "text" name = "searchJobTitle"/></td>
		</tr>
		<tr>
		<td></td>
		<br>
		<td><input type = "submit" value = "Search Job" ></td>
		</tr>
	</table>
	</form>
</body>
</html>