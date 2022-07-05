package com.dhvalente.vilfoursystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GradesNotFoundException extends Exception{

    public GradesNotFoundException(Long id) {
        super("Nenhuma nota encontrado com a id " + id);
    }
}
