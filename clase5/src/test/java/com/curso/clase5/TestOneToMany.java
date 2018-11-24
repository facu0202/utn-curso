package com.curso.clase5;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.curso.clase5.domain.Subject;
import com.curso.clase5.domain.Student;
import com.curso.clase5.repository.SubjectRepository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestOneToMany {
	
	Logger logger = LoggerFactory.getLogger(TestManyToOne.class);
	
	
	@Autowired
	SubjectRepository subjectRepository;

	//@Test
	@Rollback(false)
	public void create() {
		
		
		 //Creo una materia 
	      Subject subject = new Subject();
	      subject.setName("materia");
	      
	      
	      //Creo varios alumnos y les pongo la materia anterior
	      for (int i = 0; i < 5; i++) {
	    	  Student student = new Student();
	    	  student.setSubject(subject);
	    	  student.setName("estudiante "+i);
	    	  subject.getStudents().add(student);

		}
	   subjectRepository.save(subject);
	}
	
	@Test
	@Rollback(false)
	public void read() {
		
		Iterable<Subject> list = subjectRepository.findAll();
		for (Subject subject : list) {
			logger.info(subject.toString());
		}
		
		// Stream 
		subjectRepository.findAll().forEach(x ->logger.info(x.toString()));
	}
	

}
