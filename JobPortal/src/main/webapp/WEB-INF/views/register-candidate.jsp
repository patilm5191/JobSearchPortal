<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Register Candidate</title>
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
	
	<h1>Welcome to Candidate registration page</h1>
	
	<h2>Register a New User</h2>
	
	<form:form id="registercandidate" action="registerCandidate.htm" commandName="candidate" method="post" novalidate="novalidate">
		<table class ="table">
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" size="30"  />
					<font color="red"><form:errors path="firstName" /></font></td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" size="30"  />
					<font color="red"><form:errors path="lastName" /></font></td>
			</tr>

			<tr>
				<td>Email Id</td>
				<td><form:input path = "emailId" size = "30" type="email" />
				<font color = "red"><form:errors path ="emailId" /></font>
				</td>
			</tr>
			<tr>
				<td>Username</td>
				<td><form:input path = "username" size = "30" />
				<font color = "red"><form:errors path ="username" /></font>
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path = "password" size = "30" type="password" />
				<font color = "red"><form:errors path ="password" /></font>
				</td>
			</tr>
			
			<tr>
				<td>Phone Number</td>
				<td><form:input path="phoneNumber"  maxlength="10" type="number" />
					<font color="red"><form:errors path="phoneNumber" /></font></td>
			</tr>
			<tr>
				<td><b>Address:</b></td>
				<td></td>
			</tr>
			<tr>
				<td>City</td>
				<td><form:input path="city" size="30"  />
					<font color="red"><form:errors path="city" /></font></td>
			</tr>
			<tr>
				<td>State</td>
				<td><form:input path="state" size="30" />
					<font color="red"><form:errors path="state" /></font></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><form:input path="country" size="30"  />
					<font color="red"><form:errors path="country" /></font></td>
			</tr>
			<tr>
				<td>ZipCode:</td>
				<td><form:input path="zipCode" size="30" maxlength="6" />
					<font color="red"><form:errors path="zipCode" /></font></td>
			</tr>
			<tr><input type="hidden" name = "userType" value = "candidate" /> </tr>
<!-- 			<tr> -->
<!-- 				<td>Sign up as:</td> -->
<%-- 				<td><form:select path = "userType" > --%>
<%-- 					<form:option value = "candidate">Candidate</form:option> --%>
<%-- 					<form:option value = "recruiter">Recruiter</form:option> --%>
<%-- 					</form:select> --%>
<!-- 				</td> -->
<!-- 			</tr> -->
			<tr>
				<td colspan="2"><input type="submit" value="Register User" class="btn btn-success"/></td>
			</tr>
		</table>

	</form:form>

<%-- 	<form name = "register_candidate_form" action = "registerCandidate.htm" method = "post"> --%>
<!-- 		<table> -->
<!-- 			<tr> -->
<!-- 				<td>Firstname :</td> -->
<!-- 				<td><input type="text" name= "firstName"/> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Lastname :</td> -->
<!-- 				<td><input type="text" name= "lastName"/> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Email Address :</td> -->
<!-- 				<td><input type="text" name= "emailId"/> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Username :</td> -->
<!-- 				<td><input type="text" name= "username"/> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Password :</td> -->
<!-- 				<td><input type="text" name= "password"/> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Sign Up as:</td> -->
<!-- 				<td><select name = "userType"> -->
<!-- 	                <option value = "candidate">Candidate</option> -->
<!-- 	                <option value = "recruiter">Recruiter</option> -->
<!-- 	                <option value = "admin">Admin</option> -->
<!-- 	            </select> -->
<!-- 	            </td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 			<td colspan="2"><input type="submit" value="Register User" /></td>  -->
<!-- 			</tr> -->
<!-- 		</table> -->
<%-- 	</form> --%>
<script>
$().ready(function(){
	
	$("#registercandidate").validate(
		{
			rules:{
				firstName : {
 					required : true,
 					lettersonly : true
 				},
 				lastName : {
 					required : true,
 					lettersonly : true
 				},
 				emailId : {
 					required : true,
 					email : true
 				},
 				phoneNumber : {
 					required : true,
 					validatePhoneNumber : true
 				},
 				zipcode : {
 					required : true,
 					digits : true,
 					minlength : 6,
 					maxlength : 6
 				}
			},
			messages: {
 				firstName : {
 					required : "Please enter yout first name",
 					lettersonly : "Please enter letters only"
 				},
 				lastName : {
 					required : "Please enter yout Last name",
 					lettersonly : "Please enter letters only"
 				},

 				emailId : {
 					required : "Please enter Email Id",
 					email : "Please enter Valid email address"
 				},

 				phoneNumber : {
 					required : "Please enter Phone Number"
 				},
 				
 				zipcode : {
 					required : "Please enter ZipCode",
 					digits : "Please enter digits only",
 					minlength : "zipcode must contain 6 digits",
 					maxlength : "zipcode must contain 6 digits"
 				}
			}
		});
	)
	
})

</script>
</body>
</html>