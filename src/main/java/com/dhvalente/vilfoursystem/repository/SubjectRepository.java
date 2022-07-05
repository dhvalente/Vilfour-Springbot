package com.dhvalente.vilfoursystem.repository;

import com.dhvalente.vilfoursystem.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository <Subject , Long> {
}
