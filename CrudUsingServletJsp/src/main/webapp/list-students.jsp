<%@ page import="java.util.*, model.Student" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
    <h2>Student List</h2>
    <a href="add-student.jsp">Add New</a>
    <br/><br/>
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>

        <%
            List<Student> students = (List<Student>) request.getAttribute("students");
            if (students != null) {
                for (Student s : students) {
        %>
                    <tr>
                        <td><%= s.getId() %></td>
                        <td><%= s.getName() %></td>
                        <td><%= s.getEmail() %></td>
                        <td>
                            <a href="edit?id=<%= s.getId() %>">Edit</a>
                            <a href="delete?id=<%= s.getId() %>">Delete</a>
                        </td>
                    </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
