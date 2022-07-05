package com.dhvalente.vilfoursystem.controller;

import com.dhvalente.vilfoursystem.exceptions.SubjectNotFoundException;
import com.dhvalente.vilfoursystem.dtos.SubjectDTO;
import com.dhvalente.vilfoursystem.entities.Subject;
import com.dhvalente.vilfoursystem.service.SubjectService;
import com.dhvalente.vilfoursystem.util.ResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> create(@RequestBody SubjectDTO subjectDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subjectService.create(subjectDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {
            subjectService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseModel(HttpStatus.ACCEPTED, HttpStatus.ACCEPTED.value(), "Excluido com sucesso"));
        } catch (SubjectNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(HttpStatus.NOT_FOUND,
                    HttpStatus.NOT_FOUND.value(), e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(subjectService.findById(id));
        } catch (SubjectNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(HttpStatus.NOT_FOUND,
                    HttpStatus.NOT_FOUND.value(), e.getMessage()));
        }
    }


    @GetMapping
    public ResponseEntity<List<Subject>> listAll() {
        List<Subject> list = subjectService.findAll();
        return ResponseEntity.ok().body(list);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody SubjectDTO subjectDto) throws SubjectNotFoundException {
        try {
            subjectDto.setId(id);
            return ResponseEntity.ok().body(modelMapper.map(subjectService.update(subjectDto), SubjectDTO.class));
        } catch (SubjectNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(HttpStatus.NOT_FOUND,
                    HttpStatus.NOT_FOUND.value(), e.getMessage()));
        }

    }


}
