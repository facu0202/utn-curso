package com.curso.clase2.dao;

import java.util.List;

import com.curso.clase2.domain.Customer;

public interface CustomerDAO {
 
	Customer findById(Long id);
 
	Customer save(Customer customer);
 
	List<Customer> findAll();
 
	List<Customer> findAll(int page, int pageSize);
	
	List<Customer> findByFirstname(String firstname);
	
}
