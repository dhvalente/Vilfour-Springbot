package com.dhvalente.vilfoursystem.service;

import com.dhvalente.vilfoursystem.entities.Student;
import com.dhvalente.vilfoursystem.entities.Subject;
import com.dhvalente.vilfoursystem.exceptions.StudentNotFoundException;
import com.dhvalente.vilfoursystem.exceptions.SubjectNotFoundException;
import com.dhvalente.vilfoursystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> listAll(){
        return studentRepository.findAll();
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    public Student findById(Long id) throws StudentNotFoundException {
        return verifyIfExists(id);
    }

    private Student verifyIfExists(Long id) throws StudentNotFoundException {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }
}
