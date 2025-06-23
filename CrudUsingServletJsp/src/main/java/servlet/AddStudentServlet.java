package servlet;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Student;

import java.io.IOException;

@WebServlet("/add")
public class AddStudentServlet extends HttpServlet {
    private StudentDao dao = new StudentDao();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        dao.addStudent(new Student(0, name, email));
        resp.sendRedirect("list");
    }
}

