package com.dhvalente.vilfoursystem.controller;

import com.dhvalente.vilfoursystem.dtos.GradesDTO;
import com.dhvalente.vilfoursystem.dtos.TeacherDTO;
import com.dhvalente.vilfoursystem.exceptions.GradesNotFoundException;
import com.dhvalente.vilfoursystem.exceptions.SubjectNotFoundException;
import com.dhvalente.vilfoursystem.service.GradesService;
import com.dhvalente.vilfoursystem.service.TeacherService;
import com.dhvalente.vilfoursystem.util.ResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grades")
public class GradesController {

    @Autowired
    private GradesService gradesService;
    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> create(@RequestBody GradesDTO gradesDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gradesService.create(gradesDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(gradesService.findById(id));
        } catch (GradesNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseModel(HttpStatus.NOT_FOUND,
                    HttpStatus.NOT_FOUND.value(), e.getMessage()));
        }
    }
}
