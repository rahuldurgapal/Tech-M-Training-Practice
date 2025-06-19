package com.springproject2.springproject2.runner;

import com.springproject2.springproject2.model.Course;
import com.springproject2.springproject2.model.Student;
import com.springproject2.springproject2.service.CourseService;
import com.springproject2.springproject2.service.StudentService;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class DataLoader {

    private StudentService studentService;
    private CourseService courseService;

    public DataLoader(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    public void run() {

        Scanner sc = new Scanner(System.in);
        int choice;
        do{

            System.out.println("\n1. Add Course With Student");
            System.out.println("2. Enroll Student to Course");
            System.out.println("3. Get All Courses With Students Count");
            System.out.println("4. Get Top 3 Courses by Enrollment");
            System.out.println("5. Remove Student");
            System.out.println("0. Exit");
            System.out.println("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("Enter Course Name");
                    String name = sc.nextLine();
                    System.out.println("Enter Course Duration");
                    int duration= sc.nextInt();
                    Course c = new Course(name, duration);
                    System.out.println("Enter Number of Student to add in this course ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    List<Student> students = new ArrayList<>(n);
                    for(int i=0;i<n;i++) {
                        System.out.println("Enter the Student Name: ");
                        String sname = sc.nextLine();
                        System.out.println("Enter the Student Email: ");
                        String email = sc.nextLine();
                        Student s = new Student(sname, email);
                        students.add(s);
                    }

                    courseService.addCourseWithStudents(c,students);
                    break;

                case 2:
                    System.out.println("Enter Student Id: ");
                    int studentId = sc.nextInt();
                    System.out.println("Enter Course Ic: ");
                    int courseId = sc.nextInt();
                    sc.nextLine();
                    courseService.enrollStudentToCourse(studentId,courseId);
                    break;

                case 3:
                    courseService.getAllCourseWithStudentCount();
                    break;

                case 4:
                    courseService.getTop3CoursesByEnrollment();
                    break;

                case 5:
                    System.out.println("Enter Student Id to remove: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    studentService.removeStudent(id);
                    break;

                case 0:
                    System.out.println("Exiting.....");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again...");
                    break;



                }


        }while(choice!=0);
    }
}
