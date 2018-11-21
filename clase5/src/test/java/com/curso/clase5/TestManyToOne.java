package com.curso.clase5;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.curso.clase5.domain.Department;
import com.curso.clase5.domain.Employee;
import com.curso.clase5.repository.DepartmentRepository;
import com.curso.clase5.repository.EmployeeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestOneToMany {
	
	Logger logger = LoggerFactory.getLogger(TestManytoOne.class);
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;

	@Test
	@Rollback(false)
	public void create() {
		
		
		 //Creo un departamento con nombre Develpment
	      Department department = new Department();
	      department.setName("Development");
	      departmentRepository.save(department);
	      
	      //Creo varios departementos y les pongo el repositorio anterior
	      for (int i = 0; i < 5; i++) {
	    	  Employee employee = new Employee();
	    	  employee.setDepartment(department);
	    	  employee.setEname("empleado "+i);
	    	  employeeRepository.save(employee);
		}
	}
	
	@Test
	@Rollback(false)
	public void read() {
		
		
		employeeRepository.findAll().forEach(x ->logger.info(x.toString()));
	}
	

}
