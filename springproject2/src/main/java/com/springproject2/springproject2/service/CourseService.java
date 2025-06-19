package com.springproject2.springproject2.service;

import com.springproject2.springproject2.model.Course;
import com.springproject2.springproject2.model.Student;

import java.util.List;

public interface CourseService {

    public void addCourseWithStudents(Course course, List<Student> students);
    public void enrollStudentToCourse(int studentId, int courseId);
    public void getAllCourseWithStudentCount();
    public void getTop3CoursesByEnrollment();
}
