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



<%@page import="java.util.ArrayList,bean.Customer"%>
<%
if(s==null)
	 out.println("<h1>Login First</h1>");	
else{
out.print("</br>Welcome  " +s);
}

%>
<%
ArrayList<Customer> ar=(ArrayList<Customer>)request.getAttribute("accountDetails");

if(!ar.isEmpty())
{
	%>

	<table border="1">
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
else
	out.print("");
%>
</table>
</body>
</html>
