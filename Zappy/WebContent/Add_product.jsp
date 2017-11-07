<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb" dir="ltr">
<head>
<title>Zappy</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<head>


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
				type:'post',
				success:function(pid){
				//	alert(eid);
					$("#pid").html(pid);
					if(pid!=0)
						{
						$("#submitbtnid").hide();
						}

				}
				
			});
			
		});
		
	});

</script>



								<!--Valid  Jpg check code -->

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


<form action="Logout" method="post" align="right">

   <input type="submit" value="Logout">
</form>

 <form action="AddProductController" method="post" enctype="multipart/form-data">
 <center>
 <h1>Welcome to Zappy</h1>
  <%
String m=(String)request.getAttribute("msg");
if(m!=null)
	out.println(m);
%>
 
 
 <h2>Upload Products</h2>
<table cellpadding="2" width="30%" bgcolor="99FFFF" align="center"
cellspacing="2" border="1">
 

 
 <tr>
 <tr>
<td> Product Name</td>
<td>
<input type="text" pattern="[A-Za-z- ]+" title="only alphabet" id="pname" name="pname" required/>
	<div id="pid"></div>
</tr>




 <tr>
 <tr>
<td> Product Price(INR)</td>
 <td>	
<input type="text" min="1" name="price" pattern="^\d+(?:\.\d{2})" required/></td>
</tr>


 <tr>
 <tr>
<td> Product Weight(Grams)</td>
 <td>
<input type="number" min="1" name="weight" oninput="weightConverter(this.value)" onchange="weightConverter(this.value)"required/>
<p>Kilograms: <span id="outputKilograms"></span></p> 

</td>
</tr>


 <tr>
 <tr>
<td> Product Details</td>
 <td>
<input type="areatext" name="details" pattern="^\S+.*?\S+$" required/>
</td>
</tr>

 <tr>
 <td>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<div class="form-group">
 <td>             Upload Your Image
                    <div class="col-md-10">
                        
                        <div>
                            <img id="user_img"
                                 height="130"
                                 width="130"
                                 style="border:solid" />
                        </div>
                        <div>
                      
                           <input type="file" title="search image" id="file" name="file" onchange="show(this)" required="required"/>
                           
                           </td>
                        </div>
                    </div>
                </div>
  </tr>
 

 <tr >

<td>

<input type="reset">
  
   <input  id="submitbtnid" type="submit" values ="Upload"/>

  </td> 
 </tr> 
 	
  </table>
 
 </form>
 </center>
<!-- Footer -->
<footer class="footer store"> </footer>

<div class="copy-footer container-fluid text-center">Copyright &reg; 2015 Zappyfoods.in All rights reserved.</div>

<style type="text/css">
.copy-footer{ background:#06000c; min-height:40px; color:#fff; font-size:15px; line-height:25px; padding: 15px 0px;}

</style>
</body>

</html>

 