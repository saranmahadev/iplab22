<<!Doctype html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="javax.xml.parsers.DocumentBuilderFactory,javax.xml.parsers.DocumentBuilder,org.w3c.dom.*"%>
<%
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
Document doc = db.parse("C://Users/smile/Documents/NetBeansProjects/shopping/web/users.xml");
NodeList nl= doc.getElementsByTagName("uid");
%>
<html> 
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <title>JSP Page</title>
 </head> 
<body>
 <% String username=request.getParameter("username"); 
String uid=nl.item(0).getFirstChild().getNodeValue();
if(username.equals(uid))  
{ 
    session.setAttribute("username",username);
 response.sendRedirect("index.jsp"); 
} 
else
     out.println("Error");
 %> 
</body>
 </html>




