package com.free_calendar_system.calendar.domain;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class  AbstractPerson {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	protected Long dni;
	protected String nombre;
	protected String apellido;
	@OneToOne(cascade=CascadeType.ALL)
	protected Direccion direccion; 
	private String telefono;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	

}
