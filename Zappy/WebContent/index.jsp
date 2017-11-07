

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

   <title>Zappy</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 
 <%
String m=(String)request.getAttribute("msg");

%>
</head>

<body bgcolor="#ffe6cc">

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#ZappyProductsController">Zappy Food</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li><a href="ZappyProductsController">Zappy Home</a></li>
        
      </ul>
      
    </div>
  </div>
</nav>
  
 <center>
         <h1>Admin Login Page</h1>
         
  <% if(m!=null)
	out.println(m);
%>
        <h2 align="left">${loginfirst}</h2>
        
  <form action="AdminLoginController" method="post">
            Name:<input type="text" name="uid" required></br>
            Password    <input type="password" name="pwd" required></br>
       
              <button type="submit" value="submit" size="10px">Login</button>
  </form>
         
         

 </center>
         
</body>


</html>