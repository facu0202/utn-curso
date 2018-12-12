package com.free_calendar_system.calendar.controller.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.free_calendar_system.calendar.domain.DiaHorario;
import com.free_calendar_system.calendar.domain.Franja;
import com.free_calendar_system.calendar.domain.ProfesionalHorarios;
import com.free_calendar_system.calendar.domain.Turno;

public class HorarioDTO {

	public HorarioDTO(ProfesionalHorarios pf,List<Turno> turnos) {
		super();
		this.pf = pf;
		this.turnos = turnos;
	}

	private String apellido;
	private String nombre;
	private ProfesionalHorarios pf;
	private List<Turno> turnos;

	public boolean tieneTurno(String day, String hora) 
	{
		Date d = getDate(hora);
		boolean flag=false;
		for (Turno turno : turnos) {
			flag = isBetween(d, turno);
			if (flag)
				return true;
		}
		return false;
	}
	
	public boolean isBetween(Date date,Turno turno)
	{

			return  (turno.getEnd().equals(date)||turno.getEnd().after(date))
					&&(turno.getStart().before(date)||turno.getStart().equals(date));		
			
	}
	public boolean isDay(String day, String hora) {

		Date d = getDate(hora);
		boolean flag = false;
		for (DiaHorario diaHorario : pf.getHorarios()) {

			if (diaHorario.getDia().name().equals(day.toUpperCase())) {
				
				flag = diaHorario.isBetween(d);
				if (flag)
					return tieneTurno(day,hora);
			}

			// System.out.println(diaHorario.getDia().name());
		}
		
		return false;

	}

	private Date getDate(String hora) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("HH:mm");
			return df.parse(hora);
		} catch (Exception e) {
			return null;
		}
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
