package com.free_calendar_system.calendar;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.free_calendar_system.calendar.domain.Direccion;
import com.free_calendar_system.calendar.domain.Localidad;
import com.free_calendar_system.calendar.domain.Paciente;
import com.free_calendar_system.calendar.repository.LocalidadRepository;
import com.free_calendar_system.calendar.repository.PacienteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PacienteTests {
	
	@Autowired
	PacienteRepository pacienteRepository;

	@Autowired
	LocalidadRepository localidadRepository;
	
	@Test
	@Rollback(false)
	public void create() {
		
		Paciente paciente = new Paciente();
		paciente.setApellido("Ferro1");
		paciente.setNombre("Facundo2");
		paciente.setDni(12345L);
		paciente.setTelefono("12344");
		
		
		Direccion direccion = new Direccion();
		direccion.setCalle("465");
		
		Localidad l = localidadRepository.findFirstByDescripcion("La Plata");
		
		
		direccion.setLocalidad(l);
		
		paciente.setDireccion(direccion);
		
		pacienteRepository.save(paciente);
		
		
	}
	
	//@Test
	@Rollback(false)
	public void read() {
			
			Optional<Paciente> paciente =  pacienteRepository.findById(195l);
			
			if (paciente.isPresent())
			{	Paciente p = (paciente.get());
				pacienteRepository.delete(p);
			}
		}
	
	
	//@Test
	@Rollback(false)
	public void delete() {
		
		Paciente paciente =  pacienteRepository.findAll().get(0);
		pacienteRepository.delete(paciente);
	}

}
