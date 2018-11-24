package com.curso.clase4.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Factura {

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	
	private Long id;
	private Long numero;
	private String cliente;
	
	@OneToMany//( targetEntity=Item.class, mappedBy = "factura", cascade = CascadeType.ALL )
	private List<Item> items= new ArrayList<>();
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getNumero() {
		return numero;
	}



	public void setNumero(Long numero) {
		this.numero = numero;
	}



	public String getCliente() {
		return cliente;
	}



	public void setCliente(String cliente) {
		this.cliente = cliente;
	}



	public List<Item> getItems() {
		return items;
	}



	public void setItems(List<Item> items) {
		this.items = items;
	}



	public Factura(Long id, Long numero, String cliente) {
		super();
		this.id = id;
		this.numero = numero;
		this.cliente = cliente;
	}



	public Factura() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
