package com.dhvalente.vilfoursystem.service;

import com.dhvalente.vilfoursystem.entities.Student;
import com.dhvalente.vilfoursystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

}
