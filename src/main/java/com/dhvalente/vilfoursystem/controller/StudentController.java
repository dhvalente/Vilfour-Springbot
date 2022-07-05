package com.dhvalente.vilfoursystem.controller;

import com.dhvalente.vilfoursystem.dtos.response.StudentForm;
import com.dhvalente.vilfoursystem.entities.Student;
import com.dhvalente.vilfoursystem.exceptions.StudentNotFoundException;
import com.dhvalente.vilfoursystem.service.StudentService;
import com.dhvalente.vilfoursystem.util.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> createStudent(@RequestBody StudentForm studentForm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(studentForm.covert()));
    }

    @GetMapping
    public ResponseEntity<List<Student>> listAll() {
        List<Student> list = studentService.listAll();
        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id));
        } catch (StudentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(HttpStatus.NOT_FOUND,
                    HttpStatus.NOT_FOUND.value(), e.getMessage()));
        }
    }

}
