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
  <div class="container">
  <div class="row">
    <div class="col-sm-2">
    <div class="navbar-header">
   <a href="ZappyProductsController" ><img src="zappy-logo.png"   width="110px" height="70px" alt="logo" /></a>
   </div>
    </div>
    
     <div class="row">
    <div col-sm="10">
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
    </div></div>
    </div>
    </div> 
  </div>
</nav>

<center>

<table><tr>
<td>

<h2>Customer Home</h2></td></tr>

<% 
out.print("</br>Welcome  " +s);

%>

<tr><td><a href="customerprofile">Profile</a> <td></tr></br></br>
<tr><td><a href="Customerprofile_Edit"> Edit Profile</a></td></tr>
<tr><td><a href="CustomerBill"> View Product bill</a></td></tr>
<tr><td><a href="Customer_pending_list">Order Products from cart</a><br/></td></tr>
<tr><td><a href="Customer_order_status">My Order Status</a></td></tr>
<tr><td><form action="Logout" method="Get">
  
  <body align="right">
   <input type="submit" value="Logout">
 </form>
 

 </td></tr>
   </table>
</center>


</body>
</html>