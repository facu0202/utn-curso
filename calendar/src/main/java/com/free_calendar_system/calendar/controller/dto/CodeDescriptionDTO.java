package com.free_calendar_system.calendar.controller.dto;

import java.util.Arrays;
import java.util.List;

import com.free_calendar_system.calendar.domain.CodeDescriptionAbstract;
import com.free_calendar_system.calendar.domain.Especialidad;
import com.free_calendar_system.calendar.domain.Localidad;
import com.free_calendar_system.calendar.domain.Pais;
import com.free_calendar_system.calendar.domain.Provincia;

public class CodeDescriptionDTO {

	private static final String ESPECIALIDAD = "Especialidad";
	private static final String PROVINCIA = "Provincia";
	private static final String LOCALIDAD = "Localidad";
	private static final String PAIS = "Pais";
	private Long id;
	private String codigo;
	private String descripcion;
	private String tipo;
	public static List<String> TIPOS = Arrays.asList(ESPECIALIDAD, PROVINCIA, LOCALIDAD,PAIS);
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public CodeDescriptionDTO() {
		super();
	}
	public CodeDescriptionDTO(CodeDescriptionAbstract cd) {
		super();
		this.setCodigo(cd.getCodigo());
		this.setDescripcion(cd.getDescripcion());
		this.setId(cd.getId());
		if (cd.isPais())
			this.setTipo(PAIS);
		if (cd.isLocalidad())
			this.setTipo(LOCALIDAD);
		if (cd.isProvincia())
			this.setTipo(PROVINCIA);
		if (cd.isEspecialidad())
			this.setTipo(ESPECIALIDAD);

	}	
	

	public CodeDescriptionAbstract getNativeObject()
	{
		CodeDescriptionAbstract e = new Especialidad();
		if(this.getTipo().equals(ESPECIALIDAD))
		{
			e = new Especialidad();
		}
		if(this.getTipo().equals(LOCALIDAD))
		{
			e = new Localidad();
		}
		if(this.getTipo().equals(PROVINCIA))
		{
			e = new Provincia();
		}
		if(this.getTipo().equals(PAIS))
		{
			e = new Pais();
		}
		e.setCodigo(this.getCodigo());
		e.setDescripcion(this.getDescripcion());
		e.setId(this.getId());
		return e;
		
	}
	
}
