package org.myspringproject.service;

import org.myspringproject.model.Department;
import org.myspringproject.model.Employee;

import java.util.List;


public interface DepartmentService {
    void addDepartment(Department dept);
    List<Department> getAllDepartments();
    Department getDepartment(Long id);
    void addEmployeeToDepartment(Long deptId, Employee emp);
    void deleteDepartment(Long id);
}
