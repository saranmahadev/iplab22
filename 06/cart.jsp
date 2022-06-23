<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<img src="add.png" onclick="document.location='index.jsp'">
<img src="remove.png" onclick="document.location='remove.jsp'">
<img src="cart.png" onclick="document.location='cart.jsp'">
<center> 
    <h1>The shopping cart</h1></center> 
<h2>
<%
    String name=(String)session.getAttribute("username"); 
    out.print("<br>");
out.print("WELCOME "+name); 
out.print("<br>");
    %>
</h2>

<jsp:declaration>
java.util.Enumeration parms;
</jsp:declaration>

<%
parms = session.getAttributeNames();
while(parms.hasMoreElements()) {
    String s=(String) parms.nextElement();
    if(!s.equals("username"))
    out.println(s); 
out.println("<br>");

}

%>
</html>