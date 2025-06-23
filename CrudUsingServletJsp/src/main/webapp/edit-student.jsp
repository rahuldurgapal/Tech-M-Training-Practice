<%@ page import="model.Student" %>
<%
    Student student = (Student) request.getAttribute("student");
%>
<form method="post" action="edit">
    <input type="hidden" name="id" value="<%= student.getId() %>" />
    Name: <input type="text" name="name" value="<%= student.getName() %>" /><br/>
    Email: <input type="text" name="email" value="<%= student.getEmail() %>" /><br/>
    <input type="submit" value="Update" />
</form>
