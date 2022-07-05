package com.dhvalente.vilfoursystem.util;

import com.dhvalente.vilfoursystem.entities.Grades;
import com.dhvalente.vilfoursystem.entities.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AverageCalculatorTest {


    Grades grades1 = new Grades(1, LocalDateTime.now(), 7.0, 4, null, null, null);
    Grades grades2 = new Grades(2, LocalDateTime.now(), 8.0, 4, null, null, null);
    List<Grades> grades = new ArrayList<>();
    Student student = new Student(grades);

    @Test
    void getTotal() {
        grades.add(grades1);
        grades.add(grades2);
        Assertions.assertEquals(15, AverageCalculator.getTotal(student));
    }

    @Test
    void getAverage() {
        grades.add(grades1);
        grades.add(grades2);
        Assertions.assertEquals(7.5, AverageCalculator.getAverage(student));
    }
}