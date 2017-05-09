<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Recruiter</title>
		<meta name = "viewport" content = "width=device-width, initial-scale = 1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="https://code.jquery.com/jquery-1.9.1.js"></script>
	 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  		<script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
  		<script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/additional-methods.min.js"></script>
		<script src="https://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script> 

<style>



#login-dp{
    min-width: 300px;
    padding: 15px 50px 15px 50px;
    overflow:hidden;
    background-color:rgba(255,255,255,.8);
}



#content1 {
	padding: 20px 20px 20px 20px;
	text-align: justify;

}

#content2 {
	padding: 10px 10px 10px;
}


.row {

	background-size: 100% 100%;
	background-color: #ECEFF1;
	border: 1px solid #B0BEC5;
	border-radius: 5px;
}
@media screen and (max-width:700px) {

.hide-this{

display:none;

}

}


.dropdown-submenu {
    position: relative;
}

.dropdown-submenu>.dropdown-menu {
    top: 0;
    left: 100%;
    margin-top: -6px;
    margin-left: -1px;
    -webkit-border-radius: 0 6px 6px 6px;
    -moz-border-radius: 0 6px 6px;
    border-radius: 0 6px 6px 6px;
}

.dropdown-submenu:hover>.dropdown-menu {
    display: block;
}

.dropdown-submenu>a:after {
    display: block;
    content: " ";
    float: right;
    width: 0;
    height: 0;
    border-color: transparent;
    border-style: solid;
    border-width: 5px 0 5px 5px;
    border-left-color: #ccc;
    margin-top: 5px;
    margin-right: -10px;
}

.dropdown-submenu:hover>a:after {
    border-left-color: #fff;
}

.dropdown-submenu.pull-left {
    float: none;
}

.dropdown-submenu.pull-left>.dropdown-menu {
    left: -100%;
    margin-left: 10px;
    -webkit-border-radius: 6px 0 6px 6px;
    -moz-border-radius: 6px 0 6px 6px;
    border-radius: 6px 0 6px 6px;
}
.btn-success {
	margin-left : 500px;
}

</style>		
		

	
		
</head>
<body>
<div id = "myNavbar">
			<nav class= "navbar navbar-inverse ">
				<ul class="nav navbar-nav">
            		<li class="active"><a href="index.htm">Home<span class="sr-only">(current)</span></a></li>
            		<li><a href="#">New Student</a></li>
            		<li><a href="#">Recruiter</a></li>
            		<li><a href="#">About Us</a></li>
            	</ul>
           	
            	<ul class="nav navbar-nav navbar-right">
			        <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
						<ul id="login-dp" class="dropdown-menu">
							<li>
								 <div class="row">
									<form class="form" role="form" method="post" action="userlogin.htm" accept-charset="UTF-8" id="login-nav">
										<input type="text" class="form-control" id="exampleInputEmail2" placeholder="Username" name = "username" required>
											<label class="sr-only" for="exampleInputPassword2">Password</label>
											<br>
											<input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" name="password" required><br>
											<button type="submit" class="btn btn-primary btn-block">Login</button>
									</form>
								 </div>
							</li>

						</ul>
			        </li>
			      </ul>
			      <ul class="nav navbar-nav navbar-right">
			        <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Register</b> <span class="caret"></span></a>
						<ul id="login-dp" class="dropdown-menu">
							<li>
								 <div class="row">
									Are you seeking for job?<br><br>
									<input type="button" class="btn btn-primary btn-block" onclick="window.location.href='registerCandidate.htm'" value="Register here as Job Seeker"/><br>
									Ready to Hire and Don't Have Account?<br><br>									<input type="button" class = "btn btn-primary btn-block" onclick="window.location.href='registerRecruiter.htm'" value="Register here as Recruiter"/>
								 </div>
							</li>
						</ul>
			        </li>
			      </ul>
			</nav>
		</div>
<!-- 	<a href = "index.htm">Go to Home Page</a> -->
	<hr>

		<h1>Welcome to Recruiter Registration page</h1>
<%-- 		<form name="recruiter-registration-form" id ="myForm" action="registerRecruiter.htm" method="post" novalidate="novalidate" > --%>
		
<!-- 		<input type = "hidden" name="userType" value ="recruiter" > -->
<!-- 		<table border = 1 width = 400> -->
<!-- 			<tr> -->
<!-- 				<td>Username</td> -->
<!-- 				<td><input type="text" name="username"></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Password</td> -->
<!-- 				<td><input type = "password" name = "password"></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>First Name</td> -->
<!-- 				<td><input type = "text" name = "firstName"></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Last Name</td> -->
<!-- 				<td><input type = "text" name = "lastName" ></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Designation</td> -->
<!-- 				<td><input type = "text" name= "designation"></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Phone Number</td> -->
<!-- 				<td><input type="number" name="phoneNumber" maxlength="10" ></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Email Address</td> -->
<!-- 				<td><input type = "email" name = "emailId" ></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td><b>Company Details</b></td> -->
<!-- 				<td></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Company Name</td> -->
<!-- 				<td><input type = "text" name = "companyName" ></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>City</td> -->
<!-- 				<td><input type = "text" name = "city" ></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>State</td> -->
<!-- 				<td><input type = "text" name = "state" ></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Country</td> -->
<!-- 				<td><input type = "text" name ="country"></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Zipcode</td> -->
<!-- 				<td><input type = "number" name = "zipcode" maxlength="6"></td> -->
<!-- 			</tr> -->
<!-- 			</table> -->
<!-- 		<input type = "submit" value = "Create Account"> -->
<%-- 	</form> --%>
	
	
	<form:form name="recruiter-registration-form" action="registerRecruiter.htm" method="post" commandName = "recruiter">
		<form:input type = "hidden" path="userType" value ="recruiter" />
		<table class="table">
			<tr>
				<td>User Name:</td>
				<td><form:input path="username" size = "30"/>
				<font color ="red"> <form:errors path ="username"/></font></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input path="password" type="password" size = "30"/>
				<font color ="red"> <form:errors path ="password"/></font></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" size = "30"/>
				<font color ="red"> <form:errors path ="firstName"/></font></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" size = "30"/>
				<font color ="red"> <form:errors path ="lastName"/></font></td>
			</tr>
			<tr>
				<td>Designation:</td>
				<td><form:input path="designation" size = "30"/>
				<font color ="red"> <form:errors path ="designation"/></font></td>
			</tr>
			<tr>
				<td>Phone Number:</td>
				<td><form:input path="phoneNumber" type="number" maxlength="10" size = "30"/>
				<font color ="red"> <form:errors path ="phoneNumber"/></font></td>
			</tr>
			<tr>
				<td>Email Address:</td>
				<td><form:input path="emailId" type="email" size="30"/>
				<font color ="red"> <form:errors path ="emailId"/></font></td>
			</tr>
			<tr>
				<td><b>Company Details:</b></td>
				<td></td>
			</tr>
			<tr>
				<td>Company Name:</td>
				<td><form:input path="companyDetails.companyName" size = "30"/>
				<font color ="red"> <form:errors path ="companyDetails.companyName"/></font></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><form:input path="companyDetails.city" size = "30"/>
				<font color ="red"> <form:errors path ="companyDetails.city"/></font></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><form:input path="companyDetails.state" size = "30"/>
				<font color ="red"> <form:errors path ="companyDetails.state"/></font></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><form:input path="companyDetails.country" size = "30"/>
				<font color ="red"> <form:errors path ="companyDetails.country"/></font></td>
			</tr>
			<tr>
				<td>Zip Code:</td>
				<td><form:input path="companyDetails.zipCode" maxlength="6" size = "30"/>
				<font color ="red"> <form:errors path ="companyDetails.zipCode"/></font></td>
			</tr>			
			<tr>
				<td colspan="2"><input type="submit" value="Create Account" class="btn btn-success" /></td>
			</tr>		
		</table>
	</form:form>
	
<script>
$().ready(function(){
	
	
	
});


</script>
</body>
</html>