package com.springproject2.springproject2.repository;

import com.springproject2.springproject2.model.Student;

public interface StudentRepository {

    public void save(Student s);
    public Student findById(int id);
    public boolean existById(int id);
    public void delete(int id);
    public Student findByEmail(String email);
}
