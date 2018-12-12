package com.free_calendar_system.calendar.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.free_calendar_system.calendar.util.DiasEnum;

@Entity
public class DiaHorario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private DiasEnum dia;
	
	@OneToMany(mappedBy="diaHorario",cascade=CascadeType.ALL)
	private List<Franja> franjaHoraria = new ArrayList<>();
	@ManyToOne
	private ProfesionalHorarios profesionalHorario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DiasEnum getDia() {
		return dia;
	}
	public void setDia(DiasEnum dia) {
		this.dia = dia;
	}
	public List<Franja> getFranjaHoraria() {
		return franjaHoraria;
	}
	public void setFranjaHoraria(List<Franja> franjaHoraria) {
		this.franjaHoraria = franjaHoraria;
	}
	public ProfesionalHorarios getProfesionalHorario() {
		return profesionalHorario;
	}
	public void setProfesionalHorario(ProfesionalHorarios profesionalHorario) {
		this.profesionalHorario = profesionalHorario;
	}
	
	public boolean isBetween(Date date)
	{
		boolean flag=false;
		for (Franja franja : franjaHoraria) {
			flag=  (franja.getFinishDate().equals(date)||franja.getFinishDate().after(date))
					&&(franja.getStartDate().before(date)||franja.getStartDate().equals(date));
			if (flag)
				return true;
		}
		
		return false;
		
	}
	

}
