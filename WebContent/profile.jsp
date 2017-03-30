<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.Writer"%>
<%@page import="model.Advertisement"%>
<%@page import="model.Auction"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.UserDAO" %>
<%@page import="model.dao.AdvertisementDAO" %>
<%@page import="model.dao.AuctionDAO" %>
<%@page import="model.User" %>
<%@page errorPage="error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <% %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="profile.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>myauction</title>
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
        <span style="margin:0px; margin-right:5px;">Profile <b><span id="idka"></span> </b></span>
      </div>
    </div>  
    <% 
	 	String username = (String)session.getAttribute("username"); 	
    	User user=UserDAO.getInstance().getUser(username);
    	int userId=user.getId();
    	ArrayList<Advertisement> ads= AdvertisementDAO.getInstance().getAllAdvertisementsByUser(userId);
    	ArrayList<Auction> auctions=AuctionDAO.getInstance().getAllAuctionsByUser(userId) ;
    	
 	%>
    <div class="BlockCont">
      <div class="udtlb">Username: <%out.print(user.getUsername());%></div>
       <div class="udtlb">First name: <%out.print(user.getFirstname()); %></div>
        <div class="udtlb">Last name: <%out.print(user.getLastname()); %></div>
         <div class="udtlb">Email: <%out.print(user.getEmail());%></div>
         <div class="udtlb">All advertisements: </div><%          
         	for(Advertisement a : ads){
         	out.println(a); %>
         	<img src="noimage.gif" width="100" height="100">         	
         	<br>
         	<%} %>       
         	
         	 <div class="udtlb">All auctions: </div>
         	<%      
         	for(Auction a : auctions){
         	out.println(a); %>
         	<img src="noimage.gif" width="100" height="100">         	
         	<br>
         	<%} 
         %>          	
         	  
	</div>

  <div class="profile-info-avatar">
     	<div style="padding:5px"></div>
		<div class="BlockCont">
			<div style="border-bottom: 1px solid rgb(255, 255, 255); border-top: 1px solid rgb(204, 204, 204);"></div>
			 <a href="makeAdvertisement.html"><button>Create Advertisement</button></a>			
        <div style="border-top:1px solid #ccc; border-bottom:1px solid #fff;"></div>
         <a href="makeAuction.html"><button>Create Auction</button></a>
		</div>
		  <a href="cart.jsp"><button>Show Cart</button></a><br>
		   <a href="main.html"><button>Home</button></a>
  </div>
</div>

</body>
</html>