package com.dhvalente.vilfoursystem.config;

import com.dhvalente.vilfoursystem.entities.Address;
import com.dhvalente.vilfoursystem.entities.Student;
import com.dhvalente.vilfoursystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration

public class TestConfig implements CommandLineRunner {

    @Autowired
    private StudentService studentService;


    @Override
    public void run(String... args) throws Exception {

    Address address = new Address("Rua Jose Maria" , "11B", "Marialva", "Jardim dos Nobres", "Paraná", "866990000");
    Student student = new Student("Diogo Valente", "diogo@hotmail.com", "4499991154", "08952200011", address, 1231564156456L, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    studentService.createStudent(student);
    }

}