package com.free_calendar_system.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.free_calendar_system.calendar.domain.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
