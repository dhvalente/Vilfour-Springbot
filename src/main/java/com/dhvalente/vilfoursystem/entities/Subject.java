package com.dhvalente.vilfoursystem.entities;

import com.dhvalente.vilfoursystem.enums.PeriodEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
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

    private PeriodEnum period;

    @ManyToMany(mappedBy = "subjectList")
    private List<Teacher> teacherList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Grades> gradesList = new ArrayList<>();

    @ManyToMany(mappedBy = "studentSubjectList")
    private List<Student> subjectStudentList = new ArrayList<>();
}
