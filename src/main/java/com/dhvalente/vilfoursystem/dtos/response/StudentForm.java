package com.dhvalente.vilfoursystem.dtos.response;


import com.dhvalente.vilfoursystem.entities.Address;
import com.dhvalente.vilfoursystem.entities.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentForm {

    private String name;
    private String email;
    private String cellNumber;
    private String cpf;
    private Address address;

    public Student covert(){
        return new Student(name , email, cellNumber, cpf, address);
    }

}
