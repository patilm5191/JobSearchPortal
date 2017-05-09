<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Candidate Profile</title>
</head>
<body>
	<b><i> '${sessionScope.candidate.firstName }&nbsp;${sessionScope.candidate.lastName}' </i></b> <hr>
	<a href = "goToCandidateHomePage.htm">Home</a>&emsp;
	<a href = "viewAppliedJobs.htm">Check Application Status</a>&emsp;
	<a href = "updateCandidatedetails.htm">View and Update details</a>
	<form method="get" style="float: right"><input type="submit"  value="Logout" onclick="form.action='logout.htm';"> </form>
	<hr>
	
	<form:form id="updateDetails" action="updateCandidatedetails.htm" commandName="c" method="post" >
		<table class ="table">
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" size="30" value="${c.firstName}"  />
					<font color="red"><form:errors path="firstName" /></font></td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" size="30" value="${c.lastName}" />
					<font color="red"><form:errors path="lastName" /></font></td>
			</tr>
				<input name = "userId"  type="hidden" value= "${c.userId}"/>	
				<input name = "emailId"  type="hidden" value= "${c.emailId}"/>			
				<input name = "username"  type="hidden" value= "${c.username}"/>
				<input name = "password"  type="hidden" value= "${c.password}"/>		
				<input name = "userStatus"  type="hidden" value= "${c.userStatus}"/>
			<tr>
				<td>Phone Number</td>
				<td><form:input path="phoneNumber"  maxlength="10" type="number" value="${c.phoneNumber}" />
					<font color="red"><form:errors path="phoneNumber" /></font></td>
			</tr>
			<tr>
				<td><b>Address:</b></td>
				<td></td>
			</tr>
			<tr>
				<td>City</td>
				<td><form:input path="city" size="30" value="${c.city}"  />
					<font color="red"><form:errors path="city" /></font></td>
			</tr>
			<tr>
				<td>State</td>
				<td><form:input path="state" size="30" value="${c.state}"/>
					<font color="red"><form:errors path="state" /></font></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><form:input path="country" size="30" value="${c.country}"  />
					<font color="red"><form:errors path="country" /></font></td>
			</tr>
			<tr>
				<td>ZipCode:</td>
				<td><form:input path="zipCode" size="30" maxlength="6" value="${c.zipCode}" />
					<font color="red"><form:errors path="zipCode" /></font></td>
			</tr>
			<tr><input type="hidden" name = "userType" value = "candidate" /> </tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update Profile" class="btn btn-success"/></td>
			</tr>
		</table>

	</form:form>


</body>
</html>