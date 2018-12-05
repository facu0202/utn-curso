package com.free_calendar_system.calendar.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "discriminador")
@Table(name="CODE_DESCRIPTION")
public class CodeDescriptionAbstract {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String codigo;
	private String descripcion;
	
	
	public boolean isPais()
	{
		return false;
	}
	
	public boolean isProvincia()
	{
		return false;
	}
	public boolean isLocalidad()
	{
		return false;
	}
	public boolean isEspecialidad()
	{
		return false;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
