package com.curso.clase4.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity

public class Item {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	private Long id;
	private String descripcion;
	private Long importe;
	
	//@ManyToOne
	//private Factura factura;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Long getImporte() {
		return importe;
	}


	public void setImporte(Long importe) {
		this.importe = importe;
	}


	public Item(long id, String descripcion, long importe) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.importe = importe;
	}


	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
}
