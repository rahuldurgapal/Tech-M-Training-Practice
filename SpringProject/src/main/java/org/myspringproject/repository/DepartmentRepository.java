package org.myspringproject.repository;

import org.myspringproject.model.Department;

import java.util.List;


public interface DepartmentRepository {
    void save(Department dept);
    Department findById(Long id);
    List<Department> findAll();
    void update(Department dept);
    void delete(Long id);
}