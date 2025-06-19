package com.springproject2.springproject2.repository;


import com.springproject2.springproject2.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    @Autowired
    private SessionFactory factory;

    @Override
    public void save(Course course) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.persist(course);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Course findById(int id) {
        Session session = factory.openSession();
        Course course = session.get(Course.class,id);
        session.close();
        return course;
    }

    @Override
    public List<Course> findAll() {
        Session session = factory.openSession();
        Query<Course> query = session.createQuery("from Course",Course.class);
        List<Course> courses = query.getResultList();
        session.close();
        return courses;
    }


}
