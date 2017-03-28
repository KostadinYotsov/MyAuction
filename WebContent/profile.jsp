<%@page import="model.dao.UserDAO" %>
<%@page import="model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyAuction</title>
</head>
<body>

	<% if(session == null || session.isNew() || session.getAttribute("logged") == null || (Boolean) session.getAttribute("logged") == false){
		
 			session.invalidate();
	 		response.sendRedirect("main.html");
	 		return;
 		}
 	%>
 	<% 
	 	User user = (User) session.getAttribute("user");
 		
 	%>
 	

</body>
</html>