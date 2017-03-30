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
	 	String username = (String)session.getAttribute("username"); 	
    	User user=UserDAO.getInstance().getUser(username);
    	int userId=user.getId();
    	ArrayList<Advertisement> ads= AdvertisementDAO.getInstance().getAllAdvertisementsByUser(userId);
    	ArrayList<Auction> auctions=AuctionDAO.getInstance().getAllAuctionsByUser(userId) ;
    	
 	%>
         <h3>Profile :</h3>
         <table> 
          <tr>
		    <th>Username</th>
		    <th>First name</th>
		    <th>Last name</th>
		    <th>Email</th>
		  </tr>
		  <tr>
		    <th><%out.print(user.getUsername());%></th>
		    <th><%out.print(user.getFirstname()); %></th>
		    <th><%out.print(user.getLastname()); %></th>
		    <th> <%out.print(user.getEmail());%></th>
		  </tr>
		 </table>
		 <br>
         <br>
         <% if(ads==null || ads.isEmpty()){%>
			<h4>You haven't advertisements!</h4>
		<%	}
			else{
 		%>
        <h4>My Advertisements</h4>
         <table> 
          <tr>
		    <th>Title</th>
		    <th>Description</th>
		    <th>Category</th>
		    <th>Price</th>
		     <th>Image</th>
		  </tr>
		
         <%          
         	for(Advertisement a : ads){
         %>
         <tr>
         	<td><% out.print(a.getTitle());%></td>
		    <td><%  out.print(a.getDescription());%></td>
		    <td><%  out.print(a.getCategory());%></td>
		    <td><%  out.print(a.getPrice());%></td>
		    <td> <img src="noimage.gif" width="100" height="100"> </td>
		     <td>
                <form action="deleteAdvertisement" method="post">
                <input type="hidden" name="id" value="<%=a.getId() %>">
    	 		<input type="submit" value="Delete Advertisement">
    		 </form>  
           </td>
		 </tr>         	
         	<%}
			}
         %>      
          </table>
          <br>
         <br>
          <% if(auctions==null || auctions.isEmpty()){%>
			<h4>You haven't auctions!</h4>
		<%	}
			else{
 		%>
         	   <h4>My Auctions</h4>
		         <table> 
		          <tr>
				    <th>Title</th>
				    <th>Starting price</th>
				    <th>Current price</th>
				    <th>Sell price</th>
				    <th>Image</th>
				  </tr>
		
	         <%          
	         	for(Auction a : auctions){
	         %>
	         <tr>
	         	<td><% out.print(a.getAdvertisementTitle());%></td>
		    	<td><%  out.print(a.getStartingPrice());%></td>
		   	 	<td><%  out.print(a.getCurrentPrice());%></td>
		    	<td><%  out.print(a.getSellPrice());%></td>
			    <td> <img src="noimage.gif" width="100" height="100"> </td>
			     <td>
	                <form action="deleteAuction" method="post">
	                <input type="hidden" name="id" value="<%=a.getId() %>">
	    	 		<input type="submit" value="Delete Auction">
	    		 </form>  
	           </td>
			 </tr>         	
         	<%}
			}
         %>      
          </table>
         <br>
         <br>  
	

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


</body>
</html>