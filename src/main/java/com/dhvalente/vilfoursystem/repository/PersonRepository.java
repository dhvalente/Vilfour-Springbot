package com.dhvalente.vilfoursystem.repository;

import com.dhvalente.vilfoursystem.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
