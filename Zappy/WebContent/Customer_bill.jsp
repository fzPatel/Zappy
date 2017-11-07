<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
  <title>Store</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />

<%
HttpSession ss=request.getSession();
String s1=(String)ss.getAttribute("CustomerSession");
if(s1!=null)
out.println("Welcome "+s1);	
	


response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

if(s1==null)
 { 
	response.sendRedirect("CustomerLogin.jsp");
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


<%@page import="java.util.ArrayList,bean.Customer"%>
<%
ArrayList<Customer> ar=(ArrayList<Customer>)request.getAttribute("accountDetails");
if(!ar.isEmpty())
{
	%>

	
	
	<table border="1">
<h1>Customer  Details</h1>

<tr><th>Your Name</th><th>Mobile number</th><th>Customer email</th><th>Customer address</th><th>Customer city</th><th>Customer State</th></tr>	



<%

for(Customer ee:ar)
{	

%>
<tr>
<td><%=ee.getCname()%>
<td><%=ee.getMobile()%></td>
<td><%=ee.getEmail()%></td>
<td><%=ee.getAddress()%></td>
<td><%=ee.getCity()%></td>
<td><%=ee.getState()%></td>
</tr>

<% 
}
%>
<%	}
else out.println("<h1>Login First</h1>");	

%>
</table>

<% String s=(String)request.getAttribute("msg");
if(s!=null)
out.print(s);
%>
</br>
</br>




<%@page import="java.util.ArrayList,bean.Adminbean"%>
<%
double total=0;
ArrayList<Adminbean> br=(ArrayList<Adminbean>)request.getAttribute("productdetails");


if(!br.isEmpty())
{
	%>
	<table border="1">
<h1>Products Details</h1>

<tr><th>ProductID</th><th>Product Name</th><th>Product Quantity</th><th>Product Price</th><th>Product IpAddress</th><th>Product Image</th><th>Price</th><th>Order Date</th><th>Status</th></tr>

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
<td><%=ee.getIpAddress()%></td>


<td><img src="images/<%=ee.getImage()%>" heigth="50" width="50" /></td>
<td><%=multi%>Rs</td>
<td><%=ee.getDate()%></td>
<th><%=ee.getStatus()%></th>
<% 

}
%>
</table>
<h2> Total Price: <%=total%>Rs</h2>
</center>

<%	}
else
	out.print("<h1>No Product order</h1>");
%>
</table>
</body>
</html>