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
@Table(name = "tb_student")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id_student")
public class Student extends Person implements Serializable {
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "tb_student_subjects",joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> studentSubjectList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Grades> gradesStudent = new ArrayList<>();

    public Student(String name, String email, String cellNumber, String cpf, Address address) {
        super(name, email, cellNumber, cpf, address);
    }
}
