package com.free_calendar_system.calendar.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Franja {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String start;
	private String finish;
	@ManyToOne
	private DiaHorario diaHorario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getFinish() {
		return finish;
	}
	public void setFinish(String finish) {
		this.finish = finish;
	}
	public DiaHorario getDiaHorario() {
		return diaHorario;
	}
	public void setDiaHorario(DiaHorario diaHorario) {
		this.diaHorario = diaHorario;
	}
	
	public Date getFinishDate()
	{
		return getDate(getFinish());
	}
	
	public Date getStartDate()
	{
		return getDate(getStart());
	}
	private Date getDate(String hora) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("HH:mm");
			return df.parse(hora);
		} catch (Exception e) {
			return null;
		}
	}
	

}
