package com.dhvalente.vilfoursystem.repository;

import com.dhvalente.vilfoursystem.entities.Grades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradesRepository extends JpaRepository<Grades, Long> {
}
