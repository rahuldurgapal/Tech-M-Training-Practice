package com.springproject2.springproject2.service;

import com.springproject2.springproject2.model.Student;
import com.springproject2.springproject2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void removeStudent(int id) {
        studentRepository.delete(id);
        System.out.println("Student remove Successfully.. ");

    }
}
