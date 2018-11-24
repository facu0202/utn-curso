package com.free_calendar_system.calendar.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Profesional extends AbstractPerson {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Especialidad especialidad;
	
	private Long unidad;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUnidad() {
		return unidad;
	}
	public void setUnidad(Long unidad) {
		this.unidad = unidad;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	
	
	
	
	
}
