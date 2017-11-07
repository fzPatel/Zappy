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
String s=(String)ss.getAttribute("session");



response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

 if(s==null)
 { 
	response.sendRedirect("index.jsp");
 }
 %>
 
 
 
 
				<!--Ajax code for check Same Name Product if already exist  -->
<%response.setContentType("text/html"); %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		
		$("#pname").change(function(){
			
			var data = "pname="+$("#pname").val();
			
			$.ajax({
				
				url:'Ajax_onAddproductCheckSameName',
				data:data,
				type:'Get',
				success:function(pid){
				//	alert(eid);
					$("#pid").html(pid);
					if(pid!=0){
					$("#submitbtnid").hide();
					}
				}
				
			});
			
		});
		
	});

</script>
 
 <script type="text/javascript">
function show(input) {
        debugger;
        var validExtensions = ['jpg','png','jpeg']; //array of valid extensions
        var fileName = input.files[0].name;
        var fileNameExt = fileName.substr(fileName.lastIndexOf('.') + 1);
        if ($.inArray(fileNameExt, validExtensions) == -1) {
            input.type = ''
            input.type = 'file'
            $('#user_img').attr('src',"");
            alert("Only these file types are accepted : "+validExtensions.join(', '));
        }
        else
        {
        if (input.files && input.files[0]) {
            var filerdr = new FileReader();
            filerdr.onload = function (e) {
                $('#user_img').attr('src', e.target.result);
            }
            filerdr.readAsDataURL(input.files[0]);
        }
        }
    }

</script>



<script>
function weightConverter(valNum) {
  document.getElementById("outputKilograms").innerHTML=valNum/1000;
}
</script>



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

 
<%
if(s!=null)out.println("Welcome "+s); %>
 
<form action="Logout" method="post" align="right">

   <input type="submit" value="Logout">
</form>

</br>
 <%
String m=(String)request.getAttribute("msg");

if(m!=null)
	out.println("Product Id = "+m);
%>

<%@page import="java.util.ArrayList,bean.Adminbean"%>
<%
ArrayList<Adminbean> ar=(ArrayList<Adminbean>)request.getAttribute("LIST");
for(Adminbean ee:ar)
{

%>
 <form action="UpdateGetContoller" method="post" enctype="multipart/form-data">
 <center>
 <h1>Welcome to Zappy</h1>
 <h2>Update Products</h2>
 
<table cellpadding="2" width="30%" bgcolor="99FFFF" align="center"
cellspacing="2">
 
 <input type="hidden" value="<%=ee.getPid()%>"  name="pid" /> </br>
 

 <tr>
<td>Product Name</td>
 <td>
<input type="text" value="<%=ee.getPname()%>" id="pname" name="pname" pattern="[A-Za-z- ]+" title="only alphabet" required/></td>
	<div id="pid"></div>
${Ajaxmsg}</td>
</tr>


 <tr>
<td>Product Price(INR)</td>
 <td>
<input type="text" value="<%=ee.getPrice()%>"  min="1"  pattern="^\d+(?:\.\d{2})" name="price" required/> 
</td>
</tr>

<tr>
 <tr>
<td> Product Weight(Grams)</td>
 <td>
<input type="text" min="1" value="<%=ee.getWeight()%>" name="weight" oninput="weightConverter(this.value)" onchange="weightConverter(this.value)"required/>
<p>Kilograms: <span id="outputKilograms"></span></p> 

</td>
</tr>

 <tr>
<td>Product Description</td>
<td>
<input type="areatext" value="<%=ee.getDetails() %>" name="details" pattern="^\S+.*?\S+$" required/>
</td></tr>


 <tr>
<td>Product old Image</td>
 <td>
<image src="images/<%=ee.getImage()%>" height="150" width="150"/></td>
</tr>



  <tr id="submitbtnid">
  <td>
  <input  type="submit" value ="Update"/>
  </td>
 </form>
 
</tr>
</table>
<tr>
<td>
---------------------------------------------------------------------
</td>
</tr>
<center><h3>Only image upload</h3></center>
<table cellpadding="2" width="30%" bgcolor="99FFFF" align="center"
cellspacing="2">
 <form action="UpdateImage" method="post" enctype="multipart/form-data">

<tr>
 <td>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<div class="form-group">
 <td>             Upload New Image
                    <div class="col-md-10">
                        
                        <div>
                            <img id="user_img"
                                 height="130"
                                 width="130"
                                 style="border:solid" />
                        </div>
                        <div>
                        </td>
                           
                           <td> 
                           <input type="file" title="search image" id="file" name="file" onchange="show(this)" required/>
                           
                           </td>
                        </div>
                    </div>
                </div>
  </tr>

  <tr>
  <td>
   <input type="hidden" value="<%=ee.getPid()%>"  name="pid" /> </br>
  
  <input type="submit" value ="Update Image"/>
  </td>
 </form>
 
</tr>
<% 
}
%>
</table>
 </center>
 
 

 </table> </body>
 </html>