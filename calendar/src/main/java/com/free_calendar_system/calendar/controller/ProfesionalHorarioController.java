package com.free_calendar_system.calendar.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.free_calendar_system.calendar.controller.dto.HorarioDTO;
import com.free_calendar_system.calendar.domain.Profesional;
import com.free_calendar_system.calendar.domain.ProfesionalHorarios;
import com.free_calendar_system.calendar.domain.Turno;
import com.free_calendar_system.calendar.service.ProfesionalServices;

@Controller
@RequestMapping(value="ph")
public class ProfesionalHorarioController {
	
	@Autowired
	ProfesionalServices profesionalServices;
	
	@RequestMapping(value="/{id}")
	public String list(Model model,@PathVariable("id") Long id)
	{
		Profesional p = profesionalServices.getProfesional(id);
		ProfesionalHorarios ph = profesionalServices.getHorarios(p);
		List<Turno> turnos = profesionalServices.getTunos(null, p);
		model.addAttribute("turnos", getTurnos());
		model.addAttribute("horarioDTO", new HorarioDTO(ph,turnos));
		return "profesional/horario";
	}
	
	private List<String> getTurnos()
	{
		List<String> turnos = new ArrayList<>();
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR, 9);
		c.set(Calendar.MINUTE, 0);
		c.set( Calendar.AM_PM, Calendar.AM );
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		for(int i=0;i<=24;i++)
		{
			turnos.add(""+df.format(c.getTime()));
			
			c.add(Calendar.MINUTE, 30);
		}
		return turnos;
		
	}

}
