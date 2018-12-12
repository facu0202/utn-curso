package com.free_calendar_system.calendar;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.free_calendar_system.calendar.domain.DiaHorario;
import com.free_calendar_system.calendar.domain.Especialidad;
import com.free_calendar_system.calendar.domain.Franja;
import com.free_calendar_system.calendar.domain.Profesional;
import com.free_calendar_system.calendar.domain.ProfesionalHorarios;
import com.free_calendar_system.calendar.repository.DiaHorarioRepository;
import com.free_calendar_system.calendar.repository.EspecialidadRepository;
import com.free_calendar_system.calendar.repository.ProfesionalHorariosRepository;
import com.free_calendar_system.calendar.repository.ProfesionalRepository;
import com.free_calendar_system.calendar.util.DiasEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProfesionalHorarioTest {
	
	@Autowired
	DiaHorarioRepository diaHorarioRepository;
	
	@Autowired
	ProfesionalHorariosRepository profesionalHorariosRepository;
	
	@Autowired
	ProfesionalRepository profesionalRepository; 
	
	@Autowired
	EspecialidadRepository especialidadRepository; 
	
	//@Test
	@Rollback(false)
	public void testEspecialidad() {
		
		Especialidad e = especialidadRepository.findFirstByDescripcion("Especialidad|");
		System.out.println(e);
	}
		
	
	@Test
	@Rollback(false)
	public void create() {
		
		
		Especialidad e = especialidadRepository.findFirstByDescripcion("Especialidad");
		
		Profesional profesional = new Profesional();
		profesional.setApellido("Ferro");
		profesional.setDni(25720455L);
		profesional.setEspecialidad(e);
		profesionalRepository.save(profesional);
		
		ProfesionalHorarios ph = new ProfesionalHorarios();
		ph.setProfesional(profesional);
		ph.getHorarios().add(getHorario(DiasEnum.LUNES,ph));
		ph.getHorarios().add(getHorario(DiasEnum.VIERNES,ph));
		profesionalHorariosRepository.save(ph);
		


	}
	
	public DiaHorario getHorario(DiasEnum d, ProfesionalHorarios ph)
	{
		DiaHorario diaHorario = new DiaHorario();
		diaHorario.setDia(d);
		diaHorario.setProfesionalHorario(ph);
		Franja franja = new Franja();
		franja.setStart("09:00");
		franja.setFinish("12:00");
		franja.setDiaHorario(diaHorario);
		
		diaHorario.getFranjaHoraria().add(franja);
		Franja franja2 = new Franja();
		franja2.setStart("14:00");
		franja2.setFinish("18:00");
		franja2.setDiaHorario(diaHorario);
		diaHorario.getFranjaHoraria().add(franja2);
		return diaHorario;
	}

}
