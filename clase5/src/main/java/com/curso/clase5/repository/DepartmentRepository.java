package com.curso.clase5.repository;

import org.springframework.data.repository.CrudRepository;

import com.curso.clase5.domain.Department;

public interface DepartmentRepository extends CrudRepository <Department,Long>{
	
	
	
}
