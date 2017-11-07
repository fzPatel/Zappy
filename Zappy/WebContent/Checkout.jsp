        <title>Zappy</title>

<%
HttpSession ss=request.getSession();
String buy=(String)ss.getAttribute("session on buy");
 out.println("Welcome "+buy);
%>