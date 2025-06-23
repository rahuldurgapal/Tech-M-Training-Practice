package servlet;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListStudentServlet extends HttpServlet {
    private StudentDao dao = new StudentDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = dao.getAllStudents();
        req.setAttribute("students", list);
        req.getRequestDispatcher("list-students.jsp").forward(req, resp);
    }
}
