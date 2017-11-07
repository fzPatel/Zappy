<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
<title>Zappy</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />

<head>



<%
HttpSession ss=request.getSession();
String s=(String)ss.getAttribute("session");
out.println("Welcome "+s);	


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
	      <li><a href="AdminChangePwd.jsp">Change Pwd</a></li>
      </ul>  
    </div>
  </div>
</nav>



	
<center>
<h1>View All Customer Details</h1>


<table border="1">


${msg}

<tr><th>Customer Name</th><th>Customer Email</th><th>Customer Mobile</th><th>Customer Address</th><th>Customer City</th><th>Customer State</th><th>Remove Customer</th></tr>

<%@page import="java.util.ArrayList,bean.Customer"%>
<%
ArrayList<Customer> ar=(ArrayList<Customer>)request.getAttribute("allCustomer");
for(Customer ee:ar)
{

%>
<tr>
<td><%=ee.getCname()%></td>
<td><%=ee.getEmail()%></td>
<td><%=ee.getMobile()%></td>
<td><%=ee.getAddress()%></td>
<td><%=ee.getCity()%></td>
<td><%=ee.getState()%></td>

<td><form action="RemoveCustomer" method="post">
<input type="hidden" value="<%=ee.getMobile()%>" name="Cmobile"/> 
<input type="submit" value="Delete Customer" name="remove" Onclick="return confirm('Are you sure You want to delete')"/></td>
</form>
</tr>
<% 
}
%>
</table>
</center>
</body>
</html>
