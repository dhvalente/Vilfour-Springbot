package com.dhvalente.vilfoursystem;

import com.dhvalente.vilfoursystem.entities.*;
import com.dhvalente.vilfoursystem.repository.StudentRepository;
import com.dhvalente.vilfoursystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class VilfourSystemApplication {

    private static final StudentService studentService = new StudentService();

    public static void main(String[] args) {
        SpringApplication.run(VilfourSystemApplication.class, args);

    }



}
