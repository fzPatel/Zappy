<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
<title>Zappy</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />

<head>

 <%  
String m=(String)request.getAttribute("msg");
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
	         <li><a href="CustomerLogin.jsp">Customer Login</a></li>
	        <li><a href="CustomerRegistration.jsp">SignUp</a></li> 
	         </ul>  
    </div>
  </div>
</nav>
    
        
     <h2 align="left">${loginfirst}</h2>
 <% if(m!=null)
	out.println(m);
%>
        
        <center>
        <table>
       <tr><td>
        <h1>Login Page</h1>
        
            <h2>Customer Login </h2> </td></tr>
            
           <form action="CustomerLoginController" method="post">
        <tr>
        <td>User Mobile or Email:<input type="text" maxlength="10"  pattern="[0-9]{10}" name="Cid" required/></td></tr>
            <tr> <td>Password:<input type="password" name="Cpwd" required></td></tr>
         <tr> <td>  <input type="submit" value="Submit"></td></tr>
            </form>
        </center>
 
</table>
</body>
</html>