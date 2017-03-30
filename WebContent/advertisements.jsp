<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.dao.AdvertisementDAO" %>
    <%@page import="java.util.ArrayList"%>
    <%@page import="model.Advertisement"%>
    <%@page import="model.User" %>
    <%@page import="model.dao.UserDAO" %>
    <%@page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>

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
       <a href="profile.jsp"><button>Go to profile</button></a>
      </div>
    </div>  
    <% 
     
    	String username = (String)session.getAttribute("username"); 	
		User user=UserDAO.getInstance().getUser(username);
		int userId=user.getId();
    	ArrayList<Advertisement> ads= AdvertisementDAO.getInstance().getAllAdvertisements(userId);
 	%>
         <h3>ALL ADVERTISEMENTS</h3>
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
                <form action="addToCart" method="get">
                <input type="hidden" name="title" value="<%=a.getTitle() %>">>
    	 		<input type="submit" value="Add to cart">
    		 </form>  
           </td>
		 </tr>         	
         	<%} 
         %>      
          </table>    
</div>
</body>
</html>