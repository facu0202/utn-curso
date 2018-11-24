package com.curso.clase4.repository;

import org.springframework.data.repository.CrudRepository;

import com.curso.clase4.domain.Factura;

public interface FacturaRepository extends CrudRepository <Factura, Long> {

}
