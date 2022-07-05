package com.dhvalente.vilfoursystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SubjectNotFoundException extends Exception{

    public SubjectNotFoundException(Long id) {
        super("Nenhuma matéria encontrada com a id " + id);
    }
}
