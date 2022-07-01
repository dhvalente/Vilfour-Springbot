package com.dhvalente.vilfoursystem.repository;

import com.dhvalente.vilfoursystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
