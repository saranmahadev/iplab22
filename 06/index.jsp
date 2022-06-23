<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
    
    
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping cart</title>

<style>
* { font-size: 12px; font-family: Verdana }
input { border: 1px solid #ccc }
</style>

</head>

<body>
<center> 
    <h1>The shopping cart</h1></center> 
<jsp:declaration>
java.util.Enumeration parms;
java.util.Enumeration values;
</jsp:declaration>

<jsp:scriptlet>
parms = request.getParameterNames();
values = request.getParameterNames();


while(parms.hasMoreElements()) {
    String name = (String) parms.nextElement();
    String value = (String) values.nextElement();
    session.setAttribute(name, value);
}

</jsp:scriptlet>


<img src="add.png" onclick="document.location='index.jsp'">
<img src="remove.png" onclick="document.location='remove.jsp'">
<img src="cart.png" onclick="document.location='cart.jsp'">
<h1>
<%
    String name=(String)session.getAttribute("username"); 
    out.print("<br>");
out.print("WELCOME "+name);  
    %>
</h1>
<h2>Add to shopping cart</h2>

<form method="get" action="index.jsp">

<table>

<tr>
<td><input type="checkbox" <% if (session.getAttribute("scissors") != null) 
out.print("checked"); %> name="scissors"></td>
<td>Scissors</td>
</tr>

<tr>
<td><input type="checkbox" <% if (session.getAttribute("book") != null)
 out.print("checked"); %> name="book"></td>
<td>Book</td>
</tr>

<tr>
<td><input type="checkbox" <% if (session.getAttribute("pen") != null)
 out.print("checked"); %> name="pen"></td>
<td>Pen</td>
</tr>

<tr>
<td><input type="checkbox" <% if (session.getAttribute("bottle") != null)
 out.print("checked"); %> name="bottle"></td>
<td>Bottle</td>
</tr>

<tr>
<td><input type="checkbox" <% if (session.getAttribute("glass") != null)
out.print("checked"); %> name="glass"></td>
<td>Glass</td>
</tr>

</table>

<br><br>
<input type="submit" value="submit">
</form>


</body>
</html>

