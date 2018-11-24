package com.free_calendar_system.calendar;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.free_calendar_system.calendar.domain.Especialidad;
import com.free_calendar_system.calendar.domain.Paciente;
import com.free_calendar_system.calendar.domain.Pais;
import com.free_calendar_system.calendar.domain.Provincia;
import com.free_calendar_system.calendar.repository.EspecialidadRepository;
import com.free_calendar_system.calendar.repository.PacienteRepository;
import com.free_calendar_system.calendar.repository.PaisRepository;
import com.free_calendar_system.calendar.repository.ProvinciaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CodeDescriptionTests {

	PacienteRepository pacienteRepository ; 
	@Autowired
	PaisRepository paisRepository;

	@Autowired
	ProvinciaRepository provinciaRepository;
	
	@Autowired
	EspecialidadRepository especialidadRepository;
	

	@Test
	@Rollback(false)
	public void create() {
		
		Especialidad especialidad = new Especialidad();
		especialidad.setCodigo("1");
		especialidad.setDescripcion("Especialidad");
		especialidadRepository.save(especialidad);
		
		Pais pais = new Pais();
		pais.setCodigo("ARG");
		pais.setDescripcion("Argentina");
		paisRepository.save(pais);
		
		Provincia provincia = new Provincia();
		provincia.setCodigo("1");
		provincia.setDescripcion("Buenos aires");
		provinciaRepository.save(provincia);
	}
	


}
