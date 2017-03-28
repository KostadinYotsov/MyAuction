<%@page import="model.dao.UserDAO" %>
<%@page import="model.User" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="profile.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyAuction</title>
</head>
<body>
	<% if(session == null || session.isNew() || session.getAttribute("logged") == null || (Boolean) session.getAttribute("logged") == false){		
 			session.invalidate();
	 		response.sendRedirect("index.html");
	 		return;
 		}
 	%> 	
 	<div class="col-profile">
  <div class="profile-info">
    <div class="BlockTitle">
      <div class="id">
        <span style="margin:0px; margin-right:5px;">Profile <b><span id="idka"></span> </b></span>
      </div>
    </div>  
    <% 
	 	String username = (String)session.getAttribute("username"); 	
    	User user=UserDAO.getInstance().getUser(username);
 	%>
    <div class="BlockCont">
      <div class="udtlb">Username:</div><%user.getUsername();%><div class="udtrb"><b></b></div>
       <div class="udtlb">First name:</div><%user.getFirstname(); %><div class="udtrb"><b></b></div>
        <div class="udtlb">Last name:</div><%user.getLastname(); %><div class="udtrb"><b></b></div>
         <div class="udtlb">Email:</div><%user.getEmail();%><div class="udtrb"><b></b></div>
	</div>

  <div class="profile-info-avatar">
     	<div style="padding:5px"></div>
		<div class="BlockCont">
			<div style="border-bottom: 1px solid rgb(255, 255, 255); border-top: 1px solid rgb(204, 204, 204);"></div>
			<a href="makeAdvertisement.html" class="Smenu_link" title="">Create Advertisement</a>
			
        <div style="border-top:1px solid #ccc; border-bottom:1px solid #fff;"></div>
        <a href="makeAuction.html" class="Smenu_link" title="">Create Auction</a>
		</div>
  </div>
</div>

</body>
</html>