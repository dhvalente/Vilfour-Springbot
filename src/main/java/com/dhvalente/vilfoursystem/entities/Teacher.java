package com.dhvalente.vilfoursystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "tb_teacher")
public class Teacher extends Person implements Serializable {
    //to doo
    /*@ManyToMany
    private List<> turma;*/
    @ManyToMany
    @JoinColumn(name = "student_id")
    private List<Student> studentList;

    @ManyToMany
    @JoinColumn(name = "subject_id")
    private List<Subject> subjectList;

    @OneToMany(mappedBy = "teacher")
    private List<Grades> gradesList;

}