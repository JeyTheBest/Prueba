package com.Login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Login.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
