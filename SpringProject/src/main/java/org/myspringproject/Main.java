package org.myspringproject;


import org.myspringproject.config.AppConfig;
import org.myspringproject.model.Department;
import org.myspringproject.model.Employee;
import org.myspringproject.service.DepartmentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DepartmentServiceImpl service = context.getBean(DepartmentServiceImpl.class);
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Department");
            System.out.println("2. View All Departments");
            System.out.println("3. Add Employee to Department");
            System.out.println("4. Delete Department");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Department Name: ");
                    String dname = sc.next();
                    Department dept = new Department(dname);

                    System.out.print("Number of Employees: ");
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Emp Name: ");
                        String ename = sc.next();
                        System.out.print("Salary: ");
                        double sal = sc.nextDouble();
                        dept.addEmployee(new Employee(ename, sal));
                    }
                    service.addDepartment(dept);
                    System.out.println("Department Add Succesfully");
                }
                case 2 -> {
                    for (Department d : service.getAllDepartments()) {
                        System.out.println(d);
                        for (Employee e : d.getEmployees()) {
                            System.out.println("   " + e);
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Enter Department ID: ");
                    Long did = sc.nextLong();
                    System.out.print("Emp Name: ");
                    String name = sc.next();
                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();
                    service.addEmployeeToDepartment(did, new Employee(name, salary));
                    System.out.println("Employee add Succesfully");
                }
                case 4 -> {
                    System.out.print("Enter Department ID to delete: ");
                    Long id = sc.nextLong();
                    service.deleteDepartment(id);
                    System.out.println("Department Delete Successfully");
                }
            }

        } while (choice != 0);
    }
}