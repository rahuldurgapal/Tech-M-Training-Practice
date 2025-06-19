package com.springproject2.springproject2.repository;

import com.springproject2.springproject2.model.Course;

import java.util.List;

public interface CourseRepository {

    public void save(Course course);
    public Course findById(int id);
    public List<Course> findAll();

}
