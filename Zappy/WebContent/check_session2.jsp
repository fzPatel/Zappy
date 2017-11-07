<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
<title>Zappy</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />



<head>
<%  
 HttpSession adminss=request.getSession();
String adminsession=(String)adminss.getAttribute("session");
 
if(adminsession!=null){
					System.out.println(adminsession);
				response.sendRedirect("AdminHome.jsp");
					}
else if	(adminsession==null){
	
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					request.setAttribute("loginfirst","Please login First");
					rd.forward(request, response);


}%>

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
 