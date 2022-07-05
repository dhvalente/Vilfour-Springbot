package com.dhvalente.vilfoursystem.dtos;

import com.dhvalente.vilfoursystem.entities.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {

    private Long id;
    private String name;
    private String email;
    private String cellNumber;
    private String cpf;
    private Address address;


}
