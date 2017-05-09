<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Job Portal</title>
		<meta name = "viewport" content = "width=device-width, initial-scale = 1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!--     	<link href="css/index.css" rel="stylesheet"> -->
<style>
	.image2 {
	float:right;
}



#login-dp{
    min-width: 300px;
    padding: 15px 50px 15px 50px;
    overflow:hidden;
    background-color:rgba(255,255,255,.8);
}



.youTube_video {
	
	
}

.youTube_video iframe {
	height:100%;
	width:100%;

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

#international_image {
	padding: 10px 10px 10px;
	float: left;
	overflow:hidden;
}

#international_image img {
	height:100%;
	width:100%;

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
</style>

	</head>

	<body>
		<div id = "myNavbar">
			<nav class= "navbar navbar-inverse ">
				<ul class="nav navbar-nav">
            		<li class="active"><a href="#">Home<span class="sr-only">(current)</span></a></li>
					<li class="dropdown">
						<a id="dLabel" class="dropdown-toggle" data-toggle="dropdown" href="#">Co-curricular<span class="caret"></span></a>
							<ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu">
								<li><a href="#">Events</a></li>
								<li class="divider"></li>
							<li class="dropdown-submenu">
							<a tabindex="-1" href="#">Clubs</a>
								<ul class="dropdown-menu">
								<li><a tabindex="-1" href="#">Sports</a></li>
								<li class="divider"></li>
								<li><a href="#">Fashion</a></li>
								<li class="divider"></li>
								<li><a href="#">Outdoor Adventures</a></li>
								</ul>
							</li>
							</ul>
					</li>
            		<li><a href="#">New Student</a></li>
            		<li><a href="#">Your Travel Plan</a></li>
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

	</body>
</html>
    