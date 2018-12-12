package com.free_calendar_system.calendar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.free_calendar_system.calendar.domain.Paciente;
import com.free_calendar_system.calendar.domain.Profesional;
import com.free_calendar_system.calendar.domain.Turno;
import com.free_calendar_system.calendar.repository.PacienteRepository;
import com.free_calendar_system.calendar.repository.ProfesionalRepository;
import com.free_calendar_system.calendar.repository.TurnoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TurnoTest {
	
	@Autowired
	PacienteRepository pacienteRepository;

	@Autowired
	ProfesionalRepository profesionalRepository;
	
	@Autowired
	TurnoRepository turnoRepository;
	
	@Test
	@Rollback(false)
	public void create() throws Exception{
		
		Optional<Paciente> p = pacienteRepository.findById(200l);
		
		Optional<Profesional> pf = profesionalRepository.findById(249l);
		
		Turno turno = new Turno();
		turno.setPaciente(p.get());
		turno.setProfesional(pf.get());
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date d = df.parse("7/12/2018 10:00");
		turno.setStart(d);
		Date d1 = df.parse("7/12/2018 11:00");
		turno.setEnd(d1);
		
		turnoRepository.save(turno);
		
	
	}
	
	
}
