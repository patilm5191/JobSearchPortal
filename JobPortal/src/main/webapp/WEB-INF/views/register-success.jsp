<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	User created successfully!!!
	Welcome '${sessionScope.user.username }'
	
	<a href = "index.jsp">Go to Home Page</a>
	<a href = "postnewjob.htm">Post New Job</a>
	
	
</body>
</html>