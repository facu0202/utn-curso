package com.curso.clase3;


import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.curso.clase3.model.NonTeachingStaff;
import com.curso.clase3.model.TeachingStaff;
import com.curso.clase3.repository.NonTeachingStaffRepository;
import com.curso.clase3.repository.TeachingStaffRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestStaffRepository {

	
	TeachingStaff teachingStaff;
	NonTeachingStaff nonTeachingStaff;
	
	@Autowired
	TeachingStaffRepository teachingStaffRepository;
	
	@Autowired
	NonTeachingStaffRepository nonTeachingStaffRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Before
	public void init() {
		teachingStaff = new TeachingStaff(null,"Facundo","Dev","futbol");
		nonTeachingStaff = new NonTeachingStaff(null,"Facu","ninguna");
	}
	
	@Test
	@Rollback(false)
	public void insert() {
		teachingStaffRepository.save(teachingStaff);
		nonTeachingStaffRepository.save(nonTeachingStaff);
		
	}
	
	@Test
	@Rollback(false)
	public void findAll() {
		List<TeachingStaff> list = teachingStaffRepository.findAll();
		assert(!list.isEmpty());
	}
	
	
	@Test
	public void waitTest() {
		
		System.out.println("wait");
	}
	
	

}
