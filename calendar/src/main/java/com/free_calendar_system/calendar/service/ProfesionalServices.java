package com.free_calendar_system.calendar.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.free_calendar_system.calendar.domain.Profesional;
import com.free_calendar_system.calendar.domain.ProfesionalHorarios;
import com.free_calendar_system.calendar.domain.Turno;
import com.free_calendar_system.calendar.repository.ProfesionalHorariosRepository;
import com.free_calendar_system.calendar.repository.ProfesionalRepository;
import com.free_calendar_system.calendar.repository.TurnoRepository;

@Service
public class ProfesionalServices {
	
	@Autowired
	ProfesionalRepository profesionalRepository;
	
	@Autowired
	TurnoRepository turnoRepository;
	
	@Autowired
	ProfesionalHorariosRepository profesionalHorariosRepository; 
	public Profesional getProfesional(Long id)
	{
		Optional<Profesional> p = profesionalRepository.findById(id);
		return p.get();
	}
	
	public ProfesionalHorarios getHorarios(Profesional p)
	{
		return profesionalHorariosRepository.findFirstByProfesional(p);
	
		
	}

	public List<Turno> getTunos(Date week, Profesional p)
	{
		return turnoRepository.findByProfesional(p);
	
		
	}
}
