package com.curso.clase2;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.curso.clase2.domain.Customer;
import com.curso.clase2.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestWithDAO {

	
	Customer customer;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Before
	public void init() {
		customer = new Customer();
		customer.setEmail("facundo@gmail.com");
		customer.setFirstname("Facundo");
		customer.setLastname("Ferro");
	}
	
	@Test
	@Rollback(false)
	public void insert() {
		customerRepository.save(customer);
	}
	
	@Test
	@Rollback(false)
	public void findAll() {
		List<Customer> list = new ArrayList<>();
		customerRepository.findAll().forEach(list::add);
		assert(!list.isEmpty());
	}
	
	@Test
	@Rollback(false)
	public void findByFirstName() {
		List<Customer> list = customerRepository.findByFirstname("Facundo");
		assert(!list.isEmpty());
	}
	

}
