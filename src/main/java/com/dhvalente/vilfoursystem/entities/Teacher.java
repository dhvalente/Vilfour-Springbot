package com.dhvalente.vilfoursystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_teacher")
public class Teacher extends Person implements Serializable {
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "tb_teacher_students", joinColumns = @JoinColumn(name = "teacher_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> studentList = new ArrayList<>();
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "tb_teacher_subjects", joinColumns = @JoinColumn(name = "teacher_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjectList = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private List<Grades> gradesList = new ArrayList<>();

    public Teacher(String name, String email, String cellNumber, String cpf, Address address) {
        super(name, email, cellNumber, cpf, address);
    }

}