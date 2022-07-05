package com.dhvalente.vilfoursystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TeacherNotFoundException extends Exception{

    public TeacherNotFoundException(Long id) {
        super("Nenhum professor encontrado com o id " + id);
    }
}
