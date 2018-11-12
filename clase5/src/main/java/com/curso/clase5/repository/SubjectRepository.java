package com.curso.clase5.repository;

import org.springframework.data.repository.CrudRepository;

import com.curso.clase5.domain.Employee;
import com.curso.clase5.domain.Subject;

public interface SubjectRepository extends CrudRepository <Subject,Long>{
	
	
	

}
