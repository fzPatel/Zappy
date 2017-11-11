<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
<title>Zappy</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />

<head>


		<!--Ajax code for check Same Name Product if already exist  -->
<%response.setContentType("text/html"); %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		
		$("#oldpassword").change(function(){
			
			var data = "oldpassword="+$("#oldpassword").val();
			
			$.ajax({
				
				url:'AdminChangePwdServlet',
				data:data,
				type:'Get',
				success:function(result)	{
					
					if(result.match(1))
					{
						 $("#mid").html("");

					 $("#submitbtnid").prop('disabled', false);

					}
				else if(result.match(0))
				{
					 $("#mid").html("<font color=Red>Old Password Not match</font>");

					 $("#submitbtnid").prop('disabled', true);

				}
			}
				
			});
			
		});
		
	});

</script>




<%
HttpSession ss=request.getSession();
String s=(String)ss.getAttribute("session");



response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

 if(s==null)
 { 
	response.sendRedirect("index.jsp");
 }else if(s!=null)
 {
	 out.print("Welocome  " +s);
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
	         <li><a href="AdminHome.jsp">Admin Home</a></li>
	        <li><a href="Add_product.jsp">Upload Products</a></li>
	        <li><a href="ViewProductContoller">View All Products</a></li>
	      <li><a href="orderHistory">Order History</a></li>
	       <li><a href="AdminViewPendingforDispachList">Pending list Order</a></li>
	      <li><a href="AdminChangePwd.jsp">Change Pwd</a></li>
      </ul>  
    </div>
  </div>
</nav>


 <center>
<h2>Admin Change password</h2>

<table cellpadding="2" width="30%" bgcolor="99FFFF" align="center"
cellspacing="2" border="1">

${ChnagepwdMsgSucces}

<script type="text/javascript">  
function matchpass(){  
var firstpassword=document.f1.password.value;  
var secondpassword=document.f1.password2.value;  
  
if(firstpassword==secondpassword){  
return true;  
}  
else{  
alert("password must be same!");  
return false;  
}  
}  
</script>  
  
<form name="f1" action="AdminChangePwdServlet" onsubmit="return matchpass()" method="post">
<tr id="oldpasswordId"><td>Old Password:  <input type="password" id="oldpassword" name="oldpassword" placeholder="Enter Old Password" required/>
	<div id="mid"></div>
</td>
</tr>
 
<tr id="newpassword">
<td>New Password:<input type="password" name="password" id="newpassword" placeholder="Enter New Password" required/></td></tr>  
<tr><td>Conform Password:<input type="password" name="password2"  placeholder="Conform Password" required/></td></tr>

<tr><td>
<center>
<input type="reset">
<input id="submitbtnid" type="submit" value="submit"></center>
</td></tr>

</form> 
</center>
</table>



</body>
</html>