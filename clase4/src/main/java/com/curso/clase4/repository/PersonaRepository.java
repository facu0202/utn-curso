package com.curso.clase4.repository;

import org.springframework.data.repository.CrudRepository;

import com.curso.clase4.domain.Persona;

public interface  PersonaRepository extends CrudRepository<Persona, Long> {

}
