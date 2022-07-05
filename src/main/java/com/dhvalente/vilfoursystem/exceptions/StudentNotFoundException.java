package com.dhvalente.vilfoursystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends Exception{

    public StudentNotFoundException(Long id) {
        super("Nenhum aluno encontrado com o id " + id);
    }
}
