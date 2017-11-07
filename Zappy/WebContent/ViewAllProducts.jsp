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
     
 <li>
  <form action="Logout" method="post">
   <input type="submit" value="Logout">
   </form>
    </li>  
      
      </ul>  
    </div>
  </div>
</nav>




<center>

<% if (s!=null)out.println("Welcome "+s);%>

<%@page import="java.io.PrintWriter"%>
<p align="left"><h1>Products Details</h1></p>
<table border="1">
<tr><th>ProductID</th><th>Product Name</th><th>Product Price</th><th>Product Weight</th><th>Product Details</th><th>Product Image</th><th>Action Perform</th></tr>


<% String d=(String)request.getAttribute("delete");
if(d!=null)
out.print(d);
%>

<%String update=(String)request.getAttribute("update");

if(update!=null)
		out.print("<h2>"+update+"<h2>");
%></center>

<%@page import="java.util.ArrayList,bean.Adminbean"%>
<%
ArrayList<Adminbean> ar=(ArrayList<Adminbean>)request.getAttribute("LIST");
for(Adminbean ee:ar)
{	

%>
<tr>
<td><center><%=ee.getPid()%></center></td>
<td><center><%=ee.getPname()%></center></td>
<td><center><%=ee.getPrice()%>Rs</center></td>
<td><center><%=ee.getWeight()%>Gm</center></td>
<td><%=ee.getDetails()%></td>


<td><img src="images/<%=ee.getImage()%>" heigth="70" width="70" />

 
 <form action="UpdateImage" method="post" enctype="multipart/form-data">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
 <input type="file" title="search image" id="file" name="file" onchange="show(this)" required/>
 <input type="hidden" value="<%=ee.getPid()%>"  name="pid" />
  <input type="submit" value ="Update"/>
  
 </form>


<!-- 
 <form action="UpdateImage" method="post" enctype="multipart/form-data">
<input type="file" id="file" name="file" style="visibility: hidden; width: 1px; height: 1px" multiple /> 
<a href="" onclick="document.getElementById('upload').click(); return false">Upload</a>
 </form>
 -->



</td>
<td><form action="PActionController" method="post">
		<input type="hidden" value="<%=ee.getPid()%>" name="pid"/> 
		<input type="submit" value="Update" name="xyz"/>
		<input type="submit" value="Delete" name="xyz" Onclick="return confirm('Are you sure want to delete')"/></td>
</form>
</tr>
<% 
}
%>
</table>

<!-- Footer -->
<footer class="footer store"> </footer>
<div class="copy-footer container-fluid text-center">Copyright &reg; 2015 Zappyfoods.in All rights reserved.</div>
<style type="text/css">
.copy-footer{ background:#06000c; min-height:40px; color:#fff; font-size:15px; line-height:25px; padding: 15px 0px;}

</style>
</body>

</html>

