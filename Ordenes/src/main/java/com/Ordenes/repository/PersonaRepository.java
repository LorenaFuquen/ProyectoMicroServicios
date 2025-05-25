package com.Ordenes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Ordenes.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}