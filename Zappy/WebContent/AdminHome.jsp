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
	      <li><a href="AdminChangePwd.jsp">Change Pwd</a></li>
      </ul>  
    </div>
  </div>
</nav>


<center>

<h1>Welcome at Zappy Admin Home</h1>

<%
if(s!=null)
out.println("Welcome "+s);

%>
</br>


  <table>
<tr><td><a href="Add_product.jsp">Upload Products</a></td></tr>
<tr><td><a href="ViewProductContoller">View All Products</a></td></tr>

<tr><td><a href="AdminViewPendingforDispachList">Pending Order list</a><br/></td></tr>
<tr><td><a href="orderHistory">Order History</a></td></tr>
<tr><td><a href="Admin_ViewAllCustomer">View All Customer</a></td></tr>
<tr><td><a href="AdminChangePwd.jsp"> Change Password</a></td></tr>


 <tr><td> <form action="Logout" method="post">
    <body align="right">
   <input type="submit" value="Logout">
   </form></td></tr>
</center>
</table>

</body>  