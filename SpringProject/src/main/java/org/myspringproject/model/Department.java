package org.myspringproject.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    public Department() {}
    public Department(String name) {
        this.name = name;
    }

    public void addEmployee(Employee emp) {
        emp.setDepartment(this);
        employees.add(emp);
    }

    public void removeEmployee(Employee emp) {
        emp.setDepartment(null);
        employees.remove(emp);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dept[" + id + ", " + name + ", Employees=" + employees.size() + "]";
    }
}