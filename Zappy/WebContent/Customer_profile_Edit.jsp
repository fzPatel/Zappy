<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
  <title>Store</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />




<%
HttpSession ss=request.getSession();
String s=(String)ss.getAttribute("CustomerSession");



response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

 if(s==null)
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

<%if(s!=null)
	out.println("Welcome "+s);
	else out.println("<h1>Login First</h1>");	 %>


<center>


${profileupdatemsg}

<%@page import="java.util.ArrayList,bean.Customer"%>
<%
ArrayList<Customer> ar=(ArrayList<Customer>)request.getAttribute("accountEdit");
if(ar!=null){
	
	%>
	<table border="2" bgcolor="99FFFF">
	<h1>Customer  Details</h1>
	
	<%
	
	for(Object o:ar)
{	
	Customer ee=null;
if(o instanceof Customer)
	ee=(Customer)o;
%>

<form action="Customer_update_profile" method="post">

<tr><td>Name		:<input type="text" value="<%=ee.getCname()%>"  name="Cname" size="25"  pattern="[A-Za-z-]+" title="only alphabet" required/></br></tr></tr>
<tr><td>Mobile		:<input type="text" value="<%=ee.getMobile()%>" name="mobile" size="25"  maxlength="10"  pattern="(7|8|9)\d{9}" name="mobile" readonly="readonly"/></tr></tr>
<tr><td>Email ID 	:<input type="email" value="<%=ee.getEmail()%>"  name="email" size="25"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required/></tr></tr>
<tr><td>Address 	:<input type="areatext" value="<%=ee.getAddress()%>"name="address" size="25"  required/></tr></tr>
<tr><td>City 		:<input type="text" value="<%=ee.getCity()%>" name="city" size="25"  pattern="[A-Za-z-]+" title="only alphabet" required/></tr></tr>
<tr><td>State 	:<input type="text" value="<%=ee.getState()%>" name="state" size="25"  pattern="[A-Za-z- ]+" title="only alphabet" required/></tr></tr>
<tr><td>Password	:<input type="text" value="<%=ee.getCpwd()%>" name="password" size="25" required/></tr></tr>
 
 <tr><td><center><input type="submit" value ="Update"/></center></tr></tr>
  </tr>
  </form>
<% 
%>
<%
}
}
else
{
out.println("Login First");	

}
%>

</table>
</center>

</html>