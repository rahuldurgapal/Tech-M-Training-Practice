<%@ page isELIgnored = "false" %>
<%@page import="java.util.*"  %>
<%@page import="com.springmvc.model.User" %>


<html>
<head></head>
<body>

<%  List<String> list = (List<String>)request.getAttribute("numlist");
User user = (User)request.getAttribute("user");
%>
<h1>This is my home page </h1>
<h1>This is my list <%= list %> </h1>
<h2>this is another list ${numlist} </h2>
<h1>Welcome <%= user.name %> </h1>
<h2>Your email is <%= user.emai %> </h2>



>


</body>

</htmL>