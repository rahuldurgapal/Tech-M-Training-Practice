package org.myspringproject.service;

import org.myspringproject.model.Department;
import org.myspringproject.model.Employee;
import org.myspringproject.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repo;

    public void addDepartment(Department dept) {
        repo.save(dept);
    }

    public List<Department> getAllDepartments() {
        return repo.findAll();
    }

    public Department getDepartment(Long id) {
        return repo.findById(id);
    }

    public void addEmployeeToDepartment(Long deptId, Employee emp) {
        Department dept = repo.findById(deptId);
        if (dept != null) {
            dept.addEmployee(emp);
            repo.update(dept);
        }
    }

    public void deleteDepartment(Long id) {
        repo.delete(id);
    }
}
