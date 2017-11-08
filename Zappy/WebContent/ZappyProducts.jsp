<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
  <title>Zappy</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>

input[type=number]{
    width: 40px;
} 
</style>



<script type="text/javascript">

var valueDate = document.getElementById('Date').value;

if(!Date.parse(valueDate)){
  alert('date is invalid');
}
	</script>
	
<%
HttpSession s2=request.getSession();
String s1=(String)s2.getAttribute("CustomerSession");

String adminsession=(String)s2.getAttribute("session");

if(s1!=null)

response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

 %>	


<% String s=(String)request.getAttribute("msg");

if(s!=null)
out.print(s);
%>
<%
 String qnty=(String)request.getAttribute("quantity");
if(qnty!=null)
out.print(qnty);

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
        <%
        if(s1==null&&adminsession==null)
        {
        	
        	%>
        	<li><a href="check_session2.jsp">Admin</a></li>
	        <li><a href="check_session.jsp">Customer Login</a></li>
	     	<li><a href="CustomerRegistration.jsp">SignUp</a></li>
	     		      <li> <a href="AddCartContoller">Show Cart</a></li>
	     		      
	     	
	    
       <%
       }else if(s1!=null)
       {
    	   %>
		       <li><a href="check_session.jsp">My Home</a></li>
		       		      <li> <a href="AddCartContoller">Show Cart</a></li>
		       
		      <li><a align="right" href="Logout">Logout</a></li>
		     
    	   <%
    	   
       }else if(adminsession!=null)
       {
    	   %>
		       <li><a href="check_session2.jsp">My Home</a></li>
		      <li><a align="right" href="Logout">Logout</a></li>
		     
    	   <%
    	   
       }
       %>             
	    
      </ul>  
    </div>
  </div>
</nav>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   	
<%@page import="java.util.ArrayList,bean.Adminbean"%>


<table border="2" align="right"  bgcolor="#ff8566">
<center>
<h2>Welcome to Zappy Food</h2></center>
<%
if(s1!=null){
out.println("<center>Welcome  "+s1+"</center>");	
}
		ArrayList<Adminbean> br=(ArrayList<Adminbean>)request.getAttribute("LIST1");
		if(br!=null)
		{	
			
			double a=0;
		%><%
			for(Adminbean ee:br)
			{
				
			 a=Integer.parseInt(ee.getQnty());
				
				    
				    %>
			
		<tr> <td>Price</b>=<%=a%>INR</td></tr>
			<tr> <td>Quantity</b>=<%=ee.getQnty()%></td></tr>
		
<%}
		}else if(br==null)
		{
		%><td>Empty cart <a href="AddCartContoller">Show Cart</a></td>
<% 
		}
	%>
	</table>
	
	
<!-- <center><h3><font color="green">${cardadded}</font></h3> </center>
<font color="green">
</font>
 -->

<center>


	<%
		ArrayList<Adminbean> ar=(ArrayList<Adminbean>)request.getAttribute("LIST");
		if(ar!=null)
		{	int a=0;
			%><table border="2"><%
			for(Adminbean ee:ar)
			{
					if(a%4==0)
					{
					out.println("<tr>");
				    %>
					<td>
					<form name="frm" action="AddCartContoller" method="post">
					</br>
								<center><h4>Product Name =  <%=ee.getPname()%></h4></center>
								<center><image src="images/<%=ee.getImage()%>" height="150" width="150"/><br/></center>
								<center><b>Price</b>  = <%=ee.getPrice()%> INR<br/></center>
								<center><b>Weight</b> = <%=ee.getWeight()%> Gram.<br/></center>
<center><input type="hidden" value="<%=ee.getPrice()%>" name="price"/><center>
<center><input type="hidden" value="<%=ee.getPid()%>" name="pid"/><center>
<center><input type="hidden" value="<%=ee.getPname()%>" name="pname"/><center>
<center><input type="hidden" value="<%=ee.getImage()%>" name="pimage"/><center>
<center><input type="hidden" value="<%=ee.getWeight()%>" name="pweight"/><center>

<center><input type="Number" min="1" value="1" name="addcartfield" required/></center>
<center><input type="submit" value="Add to cart" name="cartbtn" /></center>
					
						
						</form>
							<form action="viewproductdescription" method="post">
						<center><input type="hidden" value="<%=ee.getPid()%>" name="pid"/><center>
						<center><input type="submit" value="View Product"/><center>
						</form>
				</td>
			<%
					}else{
						%>
						<td>
							<form name="frm" action="AddCartContoller" method="post">									</br>
								<center><h4>Product Name =  <%=ee.getPname()%></h4></center>
								<center><image src="images/<%=ee.getImage()%>" height="150" width="150"/><br/></center>
								<center><b>Price</b>  = <%=ee.getPrice()%> INR<br/></center>
								<center><b>Weight</b> = <%=ee.getWeight()%> Gram<br/></center>
								
<center><input type="hidden" value="<%=ee.getPrice()%>" name="price"/><center>
<center><input type="hidden" value="<%=ee.getPid()%>" name="pid"/><center>
<center><input type="hidden" value="<%=ee.getPname()%>" name="pname"/><center>
<center><input type="hidden" value="<%=ee.getWeight()%>" name="pweight"/><center>
<center><input type="hidden" value="<%=ee.getImage()%>" name="pimage"/><center>
<center><input type="Number" min="1" value="1" name="addcartfield" required/></center>
<center><input type="submit" value="Add to cart" name="cartbtn""/></center>

																								
								</center>
							</form>
							
						<form action="viewproductdescription" method="post">
						<center><input type="hidden" value="<%=ee.getPid()%>" name="pid"/><center>
						<center><input type="submit" value="View Product"/><center>
						</form>
						</td>
						
						<%
					if(a%4==3)
						out.println("</tr>");
					    	
				    }		
					a++;

				}
									
		    
		%>
				</table>				
			<%
		}
	%>
</center>

<!-- Footer -->
<footer class="footer store"> </footer>

<div class="copy-footer container-fluid text-center">Copyright &reg; 2015 Zappyfoods.in All rights reserved.</div>

<style type="text/css">
.copy-footer{ background:#06000c; min-height:40px; color:#fff; font-size:15px; line-height:25px; padding: 15px 0px;}

</style>
</body>

</html>