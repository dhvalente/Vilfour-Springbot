package com.dhvalente.vilfoursystem.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
@Entity
@Table(name = "tb_person")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_person")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cellNumber;
    private String cpf;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_endereco")
    private Address address;

    public Person() {}

    public Person(String name, String email, String cellNumber, String cpf, Address address) {
        this.name = name;
        this.email = email;
        this.cellNumber = cellNumber;
        this.cpf = cpf;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person: " + name + " CPF: " + cpf;
    }
}