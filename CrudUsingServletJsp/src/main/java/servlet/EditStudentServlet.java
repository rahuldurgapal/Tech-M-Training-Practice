package servlet;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Student;

import java.io.IOException;


@WebServlet("/edit")
public class EditStudentServlet extends HttpServlet {
    private StudentDao dao = new StudentDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student s = dao.getStudentById(id);
        req.setAttribute("student", s);
        req.getRequestDispatcher("edit-student.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        dao.updateStudent(new Student(id, name, email));
        resp.sendRedirect("list");
    }
}

