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
import com.free_calendar_system.calendar.service.EmailService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestEmail {
	
	@Autowired
	EmailService emailService;

	
	@Test
	@Rollback(false)
	public void create() {
		
	emailService.sendSimpleMessage();
		
		
	}
	
}
