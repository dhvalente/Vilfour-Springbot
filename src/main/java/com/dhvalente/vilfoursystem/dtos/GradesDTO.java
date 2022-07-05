package com.dhvalente.vilfoursystem.dtos;

import com.dhvalente.vilfoursystem.entities.Student;
import com.dhvalente.vilfoursystem.entities.Subject;
import com.dhvalente.vilfoursystem.entities.Teacher;
import com.dhvalente.vilfoursystem.enums.PeriodEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GradesDTO {

    private Long id;
    private Double grade;
    private Integer numberPeriod;
    private Subject subject;
    private Student student;
    private Teacher teacher;

}
