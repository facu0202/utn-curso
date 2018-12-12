package com.free_calendar_system.calendar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.free_calendar_system.calendar.domain.Profesional;
import com.free_calendar_system.calendar.domain.Turno;

public interface TurnoRepository extends JpaRepository<Turno, Long> {

	public List<Turno> findByProfesional(Profesional p);
}
