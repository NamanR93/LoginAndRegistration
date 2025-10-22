 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>

<%
   in.sp.models.Users  u = (in.sp.models.Users) session.getAttribute("session_user");
%>

		<h2>Welcome</h2>
		
		<h3> Name:<%= u.getName() %></h3>
		<p>Your City: <%= u.getCity() %></p>	
		<p>Your Email: <%= u.getEmail() %></p>
		
		<a href="Logout">Logout</a>

</body>
</html>