<%@page import="model.Advertisement"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
    	ArrayList<Advertisement> advs=(ArrayList)session.getAttribute("advertisements");
 	%>
         <h3>ADVERTISEMENTS</h3>
         <table> 
          <tr>
		    <th>Title</th>
		    <th>Description</th>
		    <th>Category</th>
		    <th>Price</th>
		     <th>Image</th>
		  </tr>
		
         <%          
         	for(Advertisement a : advs){
         %>
         <tr>
         	<td><% out.print(a.getTitle());%></td>
		    <td><%  out.print(a.getDescription());%></td>
		    <td><%  out.print(a.getCategory());%></td>
		    <td><%  out.print(a.getPrice());%></td>
		    <td> <img src="noimage.gif" width="100" height="100"> </td>
		 </tr>         	
         	<%} 
         %>      
          </table>    
</body>
</html>