<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.ArrayList"%>
      <%@page import="model.Auction"%>
       <%@page import="model.dao.AuctionDAO"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>auctions</title>
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
    	ArrayList<Auction> auctions=AuctionDAO.getInstance().getAllAuctions() ;
 	%>
         <h3>ALL ADVERTISEMENTS</h3>
         <%      
         //override toString before test!!!!
         	for(Auction a : auctions){
         	out.println(a); %>
         	<img src="noimage.gif" width="100" height="100">         	
         	<br>
         	<%} 
         %>        
</div>
</body>
</html>