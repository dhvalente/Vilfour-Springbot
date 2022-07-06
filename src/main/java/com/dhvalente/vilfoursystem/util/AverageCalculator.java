package com.dhvalente.vilfoursystem.util;

import com.dhvalente.vilfoursystem.entities.Grades;
import com.dhvalente.vilfoursystem.entities.Student;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class AverageCalculator {

    public static Double getTotal(Student student) {
        List<Grades> grades = student.getGradesStudent();
        Function<Grades, Double> apenasNota = Grades::getGrade;
        BinaryOperator<Double> somatorio = Double::sum;
        Optional<Double> media = grades.parallelStream().map(apenasNota).reduce(somatorio);
        return media.orElseThrow();
    }

    public static Double getAverage(Student student) {
        Double period = (double) student.getGradesStudent().size();
        return getTotal(student) / period;
    }
    
}
