package com.dhvalente.vilfoursystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.LocalDateType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_grades")
public class Grades  implements Serializable {

   @Id
   @Column(name = "id_grades")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   private LocalDateTime date = LocalDateTime.now();

   //List?
   private Double grade;

   //1 , 2 , 3
   private Integer numberPeriod;

   @ManyToOne
   @JoinColumn(name = "subject_id")
   private Subject subject;


   @ManyToOne
   @JoinColumn(name = "id_student")
   private Student student;


   @ManyToOne
   @JoinColumn(name = "id_teacher")
   private Teacher teacher;
}
