package com.springproject2.springproject2.service;


import com.springproject2.springproject2.model.Course;
import com.springproject2.springproject2.model.Student;
import com.springproject2.springproject2.repository.CourseRepository;
import com.springproject2.springproject2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void addCourseWithStudents(Course course, List<Student> students) {

        if(course==null || course.getTitle().isEmpty()) {
            System.out.println("Course Title is required");
            return;
        }

        Set<String> uniqueEmail = new HashSet<>();
        List<Student> validStudents = new ArrayList<>();

        for(Student s: students) {
            if(s.getEmail()==null || s.getEmail().isEmpty()) {
                System.out.println("Student email must not be null or not be empty");
                return;
            }
            if(!uniqueEmail.add(s.getEmail())) {
                System.out.println("Duplicate Student Email: " +s.getEmail());
                return;
            }
            s.setCourse(course);
            validStudents.add(s);
        }
        course.setStudents(students);
        courseRepository.save(course);

        System.out.println("Course Added: " + course.getTitle() + " (" + course.getDuration() + " weeks) with " + validStudents.size() + " students");


    }

    @Override
    public void enrollStudentToCourse(int studentId, int courseId) {

        Student student = studentRepository.findById(studentId);
        Course course = courseRepository.findById(courseId);

        if(student ==null || course ==null) {
            System.out.println("Student or course not found");
            return;
        }

        if(student.getCourse()!=null) {
            System.out.println("Student already enrolled in a course");
            return;
        }

        student.setCourse(course);
        studentRepository.save(student);

        System.out.println("Student enrolled in course " + course.getTitle());

    }

    @Override
    public void getAllCourseWithStudentCount() {

        List<Course> courses = courseRepository.findAll();
        for(Course c : courses) {
            System.out.println("Course: " + c.getTitle() + " Students: " +c.getStudents().size());
        }
    }

    @Override
    public void getTop3CoursesByEnrollment() {
        List<Course> courses = courseRepository.findAll();
        courses.stream()
                .sorted((a,b) -> Integer.compare(b.getStudents().size(), a.getStudents().size()))
                .limit(3)
                .forEach(c -> System.out.println("Course: " + c.getTitle() + " | " + c.getStudents().size()));
    }
}
