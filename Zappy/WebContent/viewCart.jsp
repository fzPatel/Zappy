<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
<title>Zappy</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />

<head>

<style>

input[type=number]{
    width: 40px;
} 
</style>

</head>


<body bgcolor="#ffe6cc">

<nav class="navbar navbar-inverse">
  <div id="header" class="container-fluid">
    <div class="navbar-header">
       <a href="ZappyProductsController" ><img src="zappy-logo.png"   width="110px" height="70px" alt="logo" /></a>
        </div>
    <div>
      <ul class="nav navbar-nav">
        <li><a href="ZappyProductsController">Zappy Home</a></li>
        
         <%
        
         HttpSession s2=request.getSession();
         String s1=(String)s2.getAttribute("CustomerSession");
         
        if(s1!=null)
        {
        	
        	%>
        		 <li><a href="Customer_home.jsp">My Home</a></li>
	        <li><a href="Customerprofile_Edit"> Edit Profile</a></li>
	        <li><a href="customerprofile">Profile</a></li>
	      <li><a href="Customer_order_status">My Order Status</a></li>
	       <li><a href="Customer_pending_list">Order Products from cart</a></li>
	      <li><a href="CustomerBill"> View Product bill</a></li>
         <li><a align="right" href="Logout">Logout</a></li>
        	
      
       <%
       }
        
        %>
        
      </ul>  
    </div>
  </div>
</nav>


<h1>Cart Details</h1>

<%HttpSession ss=request.getSession();
String CustomerSession=(String)ss.getAttribute("CustomerSession");%>

<%@page import="java.util.ArrayList,bean.Adminbean"%>

<%
if(CustomerSession!=null)
out.print("<h2>Welcome -  "+ CustomerSession+"  </h2>");
else out.print("<h2>Welcome </h2>");

double total=0;

ArrayList<Adminbean> ar=(ArrayList<Adminbean>)request.getAttribute("LIST");



if(!ar.isEmpty())
{

	%>
	<table border="1">
	<tr><th>ProductID</th><th>Product Name</th><th>Product Weight</th><th>Product Quantity</th><th>Product Price</th><th>Product IpAddress</th><th>Total Price</th><th>Product Image</th><th>Remove Cart</th></tr>
	
	<%

for(Adminbean ee:ar)
{

	
	int x=Integer.parseInt(ee.getQnty());
	double y=ee.getPrice();

	double multi=x*y;
	total=total+multi;
	
	
%>
<tr>

<td><%=ee.getPid()%></td>
<td><%=ee.getPname()%></td>
<td><%=ee.getWeight()%>Gm</td>


<td>
<form action="UpdateCartQuantity" method="post">
 <input type="Number" min="1" value="<%=ee.getQnty()%>" name="pquantity"/>
<input type="hidden" value="<%=ee.getCartid()%>" name="cartid"/> 
<input type="submit" value="update" name="update" />
</form></td>



<td><%=ee.getPrice()%>Rs</td>
<td><%=ee.getIpAddress()%></td>
<td><%=multi%>Rs</td>
<input type="hidden" value="<%=ee.getCartid()%>" name="cartid"/>
<input type="hidden" value="<%=ee.getPid()%>" name="pid"/>
</form>



<td><img src="images/<%=ee.getImage()%>" heigth="50" width="50" /></td>

<td><form action="RemoveCart" method="post">
<input type="hidden" value="<%=ee.getCartid()%>" name="cartid"/> 
<input type="submit" value="Remove Cart" name="remove"  Onclick="return confirm('Are you sure')"/></td>
</form>


</tr>
<% 
}
%></table>
<h2> Total Bill: <%=total%>Rs</h2>

<form action="CheckoutController" method="post">
<input type="submit" value="Checkout" name="Checkout"/></td>
</form>

<%	}
else
	out.print("<h1>Your Shopping Cart is empty</h1>");
%>

