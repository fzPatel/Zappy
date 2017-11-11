<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
  <title>zappy</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />


		<!--Ajax code for check Same Name Product if already exist  -->
<%response.setContentType("text/html"); %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		
		$("#mobile").change(function(){
			
			var data = "mobile="+$("#mobile").val();
			
			$.ajax({
				
				url:'CustomerRegistrationControlller',
				data:data,
				type:'get',
			success:function(result)	{
				
				if(result.match(0))
				{
					 $("#mid").html("");

				 $("#submitbtnid").prop('disabled', false);

				}
			else if(result.match(1))
			{
				 $("#mid").html("<font color=Red>Mobile Number already registerd</font>");

				 $("#submitbtnid").prop('disabled', true);

			}
		}
			
				
			});
			
		});
		
	});
	
	
	
	
	
	
	
	
	
	
$(document).ready(function(){
		
		$("#email").change(function(){
			
			var data = "email="+$("#email").val();
			
			$.ajax({
				
				url:'CustomerRegistrationAjaxCode',
				data:data,
				type:'Post',
			success:function(result)	
		{
			
				if(result.match(0))
				{
					 $("#emailmsg").html("");

				 $("#submitbtnid").prop('disabled', false);

				}
			else if(result.match(1))
			{
				 $("#emailmsg").html("<font color=Red>E-MailId already registerd</font>");

				 $("#submitbtnid").prop('disabled', true);

			}
		}
			
				
			});
			
		});
		
	});
</script>




<style type="text/css">

body{
background-image:url('https://imgur.com/rB8a2WY.jpg');
background-size:cover;
height:100%;
}
</style>

 

<%
 
String m=(String)request.getAttribute("Register");
if(m!=null)
	out.println(m);

%>
  </head>
  
  
  

<body >


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
   <a href="ZappyProductsController" ><img src="zappy-logo.png"   width="110px" height="70px" alt="logo" /></a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li><a href="ZappyProductsController">Zappy Home</a></li>
	        <li><a href="check_session.jsp">Customer Login</a></li>
	        <li><a href="CustomerRegistration.jsp">SignUp</a></li>
	     
      </ul>  
    </div>
  </div>
</nav>
  
<h1><font color="Green" >${Registermsg}</font> </h1>


<form action="CustomerRegistrationControlller" method="Post">

<table cellpadding="2" width="30%" bgcolor="99FFFF" align="center"
cellspacing="2"border="1">

<tr>
<td colspan=2>
<center><font size=4><b><h2>Customer  Registration Form<h2></b></font></center>
</td>
</tr>


<tr>
<td>Name</td>

<td><input type="text" name="Cname"  pattern="[A-Za-z-]+" title="only alphabet" placeholder="Enter Your Name"	required/></td>
</tr>

<tr>
<td>EmailId</td>
<td>
<input type="email" id="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" placeholder="Enter Your Emailid" required/>
<div id="emailmsg"></div>
</td>
</tr>

<tr>
<td>Address</td>

<td>
<input type="text" name="address" required/>
</td>
</tr>


<tr>
<td>City</td>
<td>

<input type="text" name="city" pattern="[A-Za-z-]+" title="only alphabet" required/>

</td>
</tr>


<tr>
<td>State</td>
<td>
<input type="text" name="state" pattern="[A-Za-z- ]+" title="only alphabet" required/>
</td>
</tr>


<tr>
<td>MobileNo</td>
<td>
<input type="text" maxlength="10"   pattern="(7|8|9)\d{9}" name="mobile" id="mobile" placeholder="Enter 10 digit mobile" required>
<div id="mid"></div>
</td>
</tr>
<tr>


<tr>
<td>Password</td>
<td>
<input type="password" name="password" required/>
</td>
</tr>
<tr>



<td colspan="2">
<center><input type="reset">

<div >
<input id="submitbtnid" type="submit" value="Submit" /></center></td>
</div>
</tr>



</table>
</form>


  </body>
 
 </html>