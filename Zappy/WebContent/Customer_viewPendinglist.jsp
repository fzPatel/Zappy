<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
  <title>Store</title>
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
double total=0;
ArrayList<Adminbean> br=(ArrayList<Adminbean>)request.getAttribute("CustomerPendinglist");

if(!br.isEmpty())
{
%>

</br>
<h1> Order Product from cart</h1></br></br>

<table border="1">
<tr><th>ProductID</th><th>Product Name</th><th>Product Quantity</th><th>Product Price</th><th>Product Weight</th><th>Total Price</th><th>Product IpAddress</th><th>Product Image</th><th>Order Date</th><th>Status</th></tr>
<%
for(Adminbean ee:br)
{	

	
	
	int x=Integer.parseInt(ee.getQnty());
	double y=ee.getPrice();

	double multi=x*y;
	total=total+multi;
%>
<tr>
<td><%=ee.getPid()%></td>
<td><%=ee.getPname()%></td>
<td><%=ee.getQnty()%></td>
<td><%=ee.getPrice()%>Rs</td>
<td><%=ee.getWeight() %> Gram</td>
<td><%=multi%>Rs</td>

<td><%=ee.getIpAddress()%></td>
<td><img src="images/<%=ee.getImage()%>" heigth="50" width="50" /></td>
<td><%=ee.getDate()%></td>
<th><%=ee.getStatus()%></th>

<td><form action="OrderProduct" method="post">
<input type="hidden" value="<%=ee.getPid()%>" name="pid"/> 
<input type="hidden" value="<%=ee.getPname()%>" name="pname"/> 
<input type="hidden" value="<%=ee.getQnty()%>" name="pqntity"/> 
<input type="hidden" value="<%=ee.getPrice()%>" name="pprice"/> 
<input type="hidden" value="<%=ee.getIpAddress()%>" name="ipaddr"/> 
<input type="hidden" value="<%=ee.getImage()%>" name="pimage"/> 
<input type="hidden" value="<%=ee.getDate()%>" name="orderdate"/> 
<input type="hidden" value="<%=ee.getStatus()%>" name="pstatus"/> 
<input type="hidden" value="<%=ee.getWeight()%>" name="pweight"/> 
<input type="hidden" value="<%=ee.getCartid()%>" name="cartid"/> 

<input type="submit" value="Buy Now" name="btn"/>
</form>

<td><form action="RemoveCart" method="post">
<input type="hidden" value="<%=ee.getCartid()%>" name="cartid"/> 
<!-- <input type="submit" value="Remove Cart" name="remove"  Onclick="return confirm('Are you sure')"/></td>
 -->
</form>
<% 

}
%>
</table>

</body>
</html>
<%
}
else
{
	out.print("<h1>No Product into cart</h1>");
	
}
%>

