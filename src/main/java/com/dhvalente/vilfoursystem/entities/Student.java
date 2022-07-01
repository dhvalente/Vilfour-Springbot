package com.dhvalente.vilfoursystem.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_student")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id_student")
public class Student extends Person implements Serializable {


    private Long enrrollment;

    @ManyToMany(mappedBy = "studentList")
    private List<Teacher> teacherStudentList;

    @ManyToMany(mappedBy = "studentSubjectList")
    private List<Subject> subjectStudentList;

    @OneToMany
    private List<Grades> gradesStudent;

    public Student(String name, String email, String cellNumber, String cpf, Address address,
                   Long enrrollment, List<Teacher> teacherStudentList,
                   List<Subject> subjectStudentList, List<Grades> gradesStudent) {
        super(name, email, cellNumber, cpf, address);
        this.enrrollment = enrrollment;
        this.teacherStudentList = teacherStudentList;
        this.subjectStudentList = subjectStudentList;
        this.gradesStudent = gradesStudent;
    }
}
