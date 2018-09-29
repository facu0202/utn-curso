package com.curso.clase2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.curso.clase2.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	public List<Customer> findByFirstname(String firstName);

}
