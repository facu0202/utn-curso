package com.curso.clase5.repository;

import org.springframework.data.repository.CrudRepository;

import com.curso.clase5.domain.Employee;

public interface EmployeeRepository extends CrudRepository <Employee,Long>{
	
	
	

}
