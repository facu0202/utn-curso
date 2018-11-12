package com.curso.clase5.repository;

import org.springframework.data.repository.CrudRepository;

import com.curso.clase5.domain.Employee;
import com.curso.clase5.domain.Subject;
import com.curso.clase5.domain.Teacher;

public interface TeacherRepository extends CrudRepository <Teacher,Long>{
	
	
	

}
