package com.dhvalente.vilfoursystem.controller;

import com.dhvalente.vilfoursystem.dtos.SubjectDTO;
import com.dhvalente.vilfoursystem.dtos.TeacherDTO;
import com.dhvalente.vilfoursystem.entities.Teacher;
import com.dhvalente.vilfoursystem.exceptions.SubjectNotFoundException;
import com.dhvalente.vilfoursystem.exceptions.TeacherNotFoundException;
import com.dhvalente.vilfoursystem.service.TeacherService;
import com.dhvalente.vilfoursystem.util.ResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> create(@RequestBody TeacherDTO teacherDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.create(teacherDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {
            teacherService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseModel(HttpStatus.ACCEPTED, HttpStatus.ACCEPTED.value(), "Excluido com sucesso"));
        } catch (TeacherNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(HttpStatus.NOT_FOUND,
                    HttpStatus.NOT_FOUND.value(), e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(teacherService.findById(id));
        } catch (TeacherNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(HttpStatus.NOT_FOUND,
                    HttpStatus.NOT_FOUND.value(), e.getMessage()));
        }
    }


    @GetMapping
    public ResponseEntity<List<Teacher>> listAll() {
        List<Teacher> list = teacherService.findAll();
        return ResponseEntity.ok().body(list);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody TeacherDTO teacherDTO) throws SubjectNotFoundException {
        try {
            teacherDTO.setId(id);
            return ResponseEntity.ok().body(modelMapper.map(teacherService.update(teacherDTO), SubjectDTO.class));
        } catch (TeacherNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(HttpStatus.NOT_FOUND,
                    HttpStatus.NOT_FOUND.value(), e.getMessage()));
        }

    }


}
