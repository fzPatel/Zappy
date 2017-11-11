<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
<title>Zappy</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />


	
<%
HttpSession s2=request.getSession();
String s1=(String)s2.getAttribute("CustomerSession");
%>


<head>


<body bgcolor="#ffe6cc">


<style>

input[type=number]{
    width: 40px;
    background-color:#dee9f2;
} 

.button {
    color: white;

 background-color: #325182;
 }


</style>

</head>


<body bgcolor="#ffe6cc">


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
   <a href="ZappyProductsController" ><img src="zappy-logo.png"   width="110px" height="70px" alt="logo" /></a>
    </div>
    <div>
      <ul class="nav navbar-nav">
       <%
        if(s1==null)
        {
        	
        	%>
        	<li><a href="check_session2.jsp">Admin</a></li>
	        <li><a href="check_session.jsp">Customer Login</a></li>
	     	<li><a href="CustomerRegistration.jsp">SignUp</a></li>
	     		      <li> <a href="AddCartContoller">Show Cart</a></li>
	     	
	   <%
       }
        else if(s1!=null)
        {
        	%>
        	   <li><a href="check_session.jsp">My Home</a></li>
	      <li> <a href="AddCartContoller">Show Cart</a></li>
	      	       <li><a align="right" href="Logout">Logout</a></li>
     
     <%} %>
     
      </ul>  
    </div>
  </div>
</nav>

<h1>Product Details</h1>




<%@page import="java.util.ArrayList,bean.Adminbean"%>
<%
ArrayList<Adminbean> ar=(ArrayList<Adminbean>)request.getAttribute("productDescription");

if(!ar.isEmpty())
{
	%>
	<center>	<table >
	<th><center>Product</center></th></br>
	
	<%

for(Adminbean ee:ar)
{

%>
<tr>
<center>
<td><img src="images/<%=     ee.getImage()%>" heigth="350" width="500" />
</center></br><center>
<Strong> Product Id =</Strong><%=ee.getPid()%></br>
<Strong> Product name = </Strong><%=ee.getPname()%></br>
<Strong> Product Price =</Strong><%=ee.getPrice()%>Rs.</br>
<Strong>Product weight =</Strong><%=ee.getWeight()%>Gm.</br></br>
<Strong>Product Detals =</Strong> Sweet and delicious, the Zappy Ganne Ka Ras is something that you will</br> enjoy till the last drop. Made with real sugarcane, 
you won’t believe it until you try it!
<%=ee.getDetails()%></center>


<form name="frm" action="AddCartContoller" method="post">									</br>
<center><input type="hidden" value="<%=ee.getPrice()%>" name="price"/><center>
<center><input type="hidden" value="<%=ee.getPid()%>" name="pid"/><center>
<center><input type="hidden" value="<%=ee.getPname()%>" name="pname"/><center>
<center><input type="hidden" value="<%=ee.getWeight()%>" name="pweight"/><center>
<center><input type="hidden" value="<%=ee.getImage()%>" name="pimage"/><center>
<center><input type="Number" min="1" value="1" name="addcartfield" required/></center>
<center><input type="submit" value="Add to cart" class="button" name="cartbtn""/></center>
</br>
																								
								</center>
							</form>
							
</center>
</td>
</tr>
<% 
}
%>

<%	}
else
	out.print("Cart is Empty");
%>
</table>



</body>
</html>