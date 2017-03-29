<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.dao.AdvertisementDAO" %>
    <%@page import="java.util.ArrayList"%>
    <%@page import="model.Advertisement"%>
    <%@page import="model.User" %>
    <%@page import="model.dao.UserDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="advertisement.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>advertisements</title>
</head>
<body>

	<% if(session == null || session.isNew() || session.getAttribute("logged") == null || (Boolean) session.getAttribute("logged") == false){		
 			session.invalidate();
	 		response.sendRedirect("index.html");
	 		return;
 		}
 	%> 
 	
 	<div class="profile-info">
    <div class="BlockTitle">
      <div class="id">
      <a href="profile.jsp">Go to profile</a>
      </div>
    </div>  
    <% 
    	String username = (String)session.getAttribute("username"); 	
		User user=UserDAO.getInstance().getUser(username);
		int userId=user.getId();
    	ArrayList<Advertisement> ads= AdvertisementDAO.getInstance().getAllAdvertisements(userId);
 	%>
         <h3>ALL ADVERTISEMENTS</h3>
         <%          
         	for(Advertisement a : ads){
         	out.println(a); %>
         	<img src="noimage.gif" width="100" height="100">         	
         	<br>
         	<%} 
         %>        
</div>
</body>
</html>