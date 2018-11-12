package com.curso.clase5;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.curso.clase5.domain.School;
import com.curso.clase5.domain.Teacher;
import com.curso.clase5.repository.SchoolRepository;
import com.curso.clase5.repository.TeacherRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestManyToMany {
	
	Logger logger = LoggerFactory.getLogger(TestManyToMany.class);

	
	@Autowired
	SchoolRepository schoolRepository;
	
	@Autowired
	TeacherRepository teacherRepository;

	//@Test
	@Rollback(false)
	public void create() {
		
		  //Create Clas Entity
	      School clas1=new School("1st",null);
	      School clas2=new School("2nd",null);
	      School clas3=new School("3rd",null);

	      schoolRepository.save(clas1);
	      schoolRepository.save(clas2);
	      schoolRepository.save(clas3);
	      
	      Set<School> classSet1 = new HashSet();
	      classSet1.add(clas1);
	      classSet1.add(clas2);
	      classSet1.add(clas3);
	      
	      Teacher teacher1 = new Teacher(0l, "Satish", "Java", classSet1);
	      
	      teacherRepository.save(teacher1);
		
	
	}
	
	@Test
//	@Rollback(false)
	public void read() {
		
		
		teacherRepository.findAll().forEach(x ->logger.info(">>>>>>>>>>>"+x.toString()));
	}
	

}
