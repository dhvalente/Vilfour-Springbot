package com.dhvalente.vilfoursystem.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_subject")
public class Subject implements Serializable {

    @Id
    @Column(name = "id_grades")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    //Bimestre, Trimestre, Semestre
    private Enum period;

    @ManyToMany(mappedBy = "subjectList")
    private List<Teacher> teacherList;

    @OneToMany(mappedBy = "subject")
    private List<Grades> gradesList;
    @JoinColumn(name = "student_subject_id")
    @ManyToMany
    private List<Student> studentSubjectList;
}
