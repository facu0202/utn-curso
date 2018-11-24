package com.curso.clase5;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.curso.clase5.domain.Department;
import com.curso.clase5.domain.Employee;
import com.curso.clase5.repository.DepartmentRepository;
import com.curso.clase5.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestManyToOne {
	
	Logger logger = LoggerFactory.getLogger(TestManyToOne.class);
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;

	//@Test
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
		
		for (Employee e : employeeRepository.findAll()) {
			logger.info(e.toString());
			
		}
		// utilizando expressiones lambda
		employeeRepository.findAll().forEach(x ->logger.info(x.toString()));
	}
	

}
