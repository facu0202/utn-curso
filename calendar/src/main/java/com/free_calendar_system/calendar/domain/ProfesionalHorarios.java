package com.free_calendar_system.calendar.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ProfesionalHorarios {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@OneToOne
	public Profesional profesional;
	@OneToMany(mappedBy="profesionalHorario",cascade=CascadeType.ALL)
	public List<DiaHorario> horarios = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Profesional getProfesional() {
		return profesional;
	}
	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}
	public List<DiaHorario> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<DiaHorario> horarios) {
		this.horarios = horarios;
	}
	


}
