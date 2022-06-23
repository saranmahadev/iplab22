
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping cart</title>
<style>
* { font-size: 12px; font-family: Verdana }
</style>
</head>
<body>

<center> 
    <h1>The shopping cart</h1></center> 
<img src="add.png" onclick="document.location='index.jsp'">
<img src="remove.png" onclick="document.location='remove.jsp'">
<img src="cart.png" onclick="document.location='cart.jsp'">
<h2>

<%
    String name1=(String)session.getAttribute("username");
    out.print("<br>");
out.print("WELCOME "+name1);  
    %>
</h2>

<jsp:declaration>
java.util.Enumeration parms;
</jsp:declaration>

<jsp:scriptlet>
parms = request.getParameterNames();

while(parms.hasMoreElements()) {
String name = (String) parms.nextElement();
session.removeAttribute(name);
}

</jsp:scriptlet>
<h2>Remove items from cart</h2>
<form method="get" action="remove.jsp">
<table>
<% if (session.getAttribute("scissors") != null) { %>
<tr>
<td><input type="checkbox" name="scissors"></td><td>Scissors</td></td>
</tr>
<% } %>
<% if (session.getAttribute("book") != null) { %>
<tr>
<td><input type="checkbox" name="book"></td><td>Book</td></td>
</tr>
<% } %>
<% if (session.getAttribute("pen") != null) { %>
<tr>
<td><input type="checkbox" name="pen"></td><td>Pen</td></td>
</tr>
<% } %>
<% if (session.getAttribute("bottle") != null) { %>
<tr>
<td><input type="checkbox" name="bottle"></td><td>Bottle</td></td>
</tr>
<% } %>
<% if (session.getAttribute("glass") != null) { %>
<tr>
<td><input type="checkbox" name="glass"></td><td>Glass</td></td>
</tr>
<% } %>
</table>
<br><br>
<input type="submit" value="submit">
</form>
</body>
</html>


