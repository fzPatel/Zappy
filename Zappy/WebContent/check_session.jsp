<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
<title>Zappy</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />



<head>



<style type="text/css">

body{
background-image:url('https://imgur.com/rB8a2WY.jpg');
background-size:cover;
height:100%;
}
</style>
<%  
 HttpSession customss=request.getSession();
String customersession=(String)customss.getAttribute("CustomerSession");
 
if(customersession!=null)
		{	
			out.println(customersession);
			response.sendRedirect("Customer_home.jsp");
		}
else if(customersession==null){
			RequestDispatcher rd=request.getRequestDispatcher("CustomerLogin.jsp");
			request.setAttribute("loginfirst","Please login First");
			rd.forward(request, response);
}%>

 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zappy</title>
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
	         <li><a href="check_session2.jsp">Admin Login</a></li>
	        <li><a href="check_session.jsp">Customer Login</a></li>
	        <li><a href="CustomerRegistration.jsp">SignUp</a></li>
	      <li><a href="customerprofile">Profile</a></li>
	       <li><a href="check_session.jsp">My Home</a></li>
	      <li> <a href="AddCartContoller">Show Cart</a></li>
      </ul>  
    </div>
  </div>
</nav>




</body> 
 
 
    
</html>
 