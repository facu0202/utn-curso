package com.free_calendar_system.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.free_calendar_system.calendar.domain.Profesional;
import com.free_calendar_system.calendar.domain.ProfesionalHorarios;

public interface ProfesionalHorariosRepository extends JpaRepository<ProfesionalHorarios, Long>{

	
	
	public ProfesionalHorarios findFirstByProfesional(Profesional p);
}
