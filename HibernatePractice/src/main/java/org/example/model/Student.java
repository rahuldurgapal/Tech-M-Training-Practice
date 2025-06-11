package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {

    @Column(name = "student_id")
    @Id
    private int id;

    @Column(name = "student_name")
    private String name;

    @Column(name = "student_email")
    private String email;


}
