package com.free_calendar_system.calendar;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.free_calendar_system.calendar.domain.Direccion;
import com.free_calendar_system.calendar.domain.Paciente;
import com.free_calendar_system.calendar.repository.PacienteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PacienteTests {
	
	@Autowired
	PacienteRepository pacienteRepository;

	@Test
	@Rollback(false)
	public void create() {
		
		Paciente paciente = new Paciente();
		paciente.setApellido("Ferro");
		paciente.setNombre("Facundo");
		paciente.setDni(1234L);
		paciente.setTelefono("1234");
		
		
		Direccion direccion = new Direccion();
		direccion.setCalle("46");
		
		paciente.setDireccion(direccion);
		
		pacienteRepository.save(paciente);
		
		
	}
	
	@Test
	@Rollback(false)
	public void delete() {
		
		Paciente paciente =  pacienteRepository.findAll().get(0);
		pacienteRepository.delete(paciente);
	}

}
