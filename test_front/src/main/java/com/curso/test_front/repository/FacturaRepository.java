package com.curso.test_front.repository;

import org.springframework.data.repository.CrudRepository;

import com.curso.test_front.domain.Factura;

public interface FacturaRepository extends CrudRepository <Factura, Long> {

}
