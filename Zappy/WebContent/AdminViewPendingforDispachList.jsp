<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
<title>Zappy</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />

<%
HttpSession ss=request.getSession();
String s=(String)ss.getAttribute("session");


response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

 if(s==null)
 { 
	response.sendRedirect("index.jsp");
 }
 %>
 	</head>
<body bgcolor="#ffe6cc">

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
   <a href="ZappyProductsController" ><img src="zappy-logo.png"   width="110px" height="70px" alt="logo" /></a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li><a href="ZappyProductsController">Zappy Home</a></li>
	         <li><a href="AdminHome.jsp">Admin Home</a></li>
	        <li><a href="Add_product.jsp">Upload Products</a></li>
	        <li><a href="ViewProductContoller">View All Products</a></li>
	      <li><a href="orderHistory">Order History</a></li>
	       <li><a href="AdminViewPendingforDispachList">Pending list Order</a></li>
     	       <li><a href="Logout">Logout</a></li>
     
  
      
      </ul>  
    </div>
  </div>
</nav>
 
 

<center>

<% if (s!=null)out.println("Welcome "+s);

%>
<h1>Pending Order Details</h1>

<%@page import="java.util.ArrayList,bean.Adminbean"%>
<%

ArrayList<Adminbean> br=(ArrayList<Adminbean>)request.getAttribute("dipachedPendinglist");

if(!br.isEmpty())
{
	%>
	<table border="1">
<tr><th>ProductID</th><th>Product Name</th><th>Product Quantity</th><th>Product Price</th><th>Product Weight</th><th>Customer ID</th><th>Customer IpAddress</th><th>Product Image</th><th>Order Date</th><th>Status</th><td>Action</td></tr>
	<%


for(Adminbean ee:br)
{	

%>
<tr>
<td><%=ee.getPid()%></td>
<td><%=ee.getPname()%></td>
<td><%=ee.getQnty()%></td>
<td><%=ee.getPrice()%>Rs</td>
<td><%=ee.getWeight()%> Gram</td>
<td><%=ee.getCustomerId()%></td>
<td><%=ee.getIpAddress()%></td>

<td><img src="images/<%=ee.getImage()%>" heigth="50" width="50" /></td>
<td><%=ee.getDate()%></td>
<th> <%= ee.getStatus() %> </th>
<td>


<form action="AdminOrderAction" method="post">

<input type="hidden" value="<%=ee.getPid()%>" name="pid"/> 
<input type="hidden" value="<%=ee.getPname()%>" name="pname"/> 
<input type="hidden" value="<%=ee.getQnty()%>" name="pqntity"/> 
<input type="hidden" value="<%=ee.getPrice()%>" name="pprice"/> 
<input type="hidden" value="<%=ee.getIpAddress()%>" name="ipaddr"/> 
<input type="hidden" value="<%=ee.getImage()%>" name="pimage"/> 
<input type="hidden" value="<%=ee.getDate()%>" name="orderdate"/> 
<input type="hidden" value="<%=ee.getStatus()%>" name="status"/> 
<input type="hidden" value="<%=ee.getWeight()%>" name="pweight"/> 
<input type="hidden" value="<%=ee.getStatus()%>" name="status"/> 
<input type="hidden" value="<%=ee.getCustomerId()%>" name="Customerid"/> 
<input type="hidden" value="<%=ee.getOrderid()%>" name="orderid"/> 


<input type="submit" value="Dispatch" name="btn"/>
<input type="submit" value="Not Available" name="btn"/>
</form>


<% 

}
%>
<%	}
else
	out.print("<center><h1>No Pending Orders</h1></center>");
%>
</table>

</body>
</html>