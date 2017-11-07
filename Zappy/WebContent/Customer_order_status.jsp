<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
  <title>Zappy</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />

 
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
	         <li><a href="Customer_home.jsp">My Home</a></li>
	        <li><a href="Customerprofile_Edit"> Edit Profile</a></li>
	        <li><a href="customerprofile">Profile</a></li>
	      <li><a href="Customer_order_status">My Order Status</a></li>
	       <li><a href="Customer_pending_list">Order Products from cart</a></li>
	      <li><a href="CustomerBill"> View Product bill</a></li>
	      	       <li><a align="right" href="Logout">Logout</a></li>
	      
      </ul>  
    </div>
  </div>
</nav>


<%@page import="java.util.ArrayList,bean.Adminbean"%>
<%

ArrayList<Adminbean> br=(ArrayList<Adminbean>)request.getAttribute("Customerorderstatus");

if(!br.isEmpty())
{
%>
</br>
<h1>   My Order Status</h1></br></br>
<table border="1">
<tr><th>ProductID</th><th>Product Name</th><th>Product Quantity</th><th>Product Price</th><th>Product IpAddress</th><th>Product Image</th><th>Order Date</th><th>Status</th></tr>
<%
for(Adminbean ee:br)
{	

%>
<tr>
<td><%=ee.getPid()%></td>
<td><%=ee.getPname()%></td>
<td><%=ee.getQnty()%></td>
<td><%=ee.getPrice()%>Rs</td>
<td><%=ee.getIpAddress()%></td>
<td><img src="images/<%=ee.getImage()%>" heigth="50" width="50" /></td>
<td><%=ee.getDate()%></td>
<th><%=ee.getStatus()%></th>

<% 

}
%>
</table>

<%
}
else
{
	out.print("<h1>No order today</h1>");
	
}
%>


</body>
</html>