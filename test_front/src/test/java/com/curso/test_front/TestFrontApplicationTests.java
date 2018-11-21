package com.curso.test_front;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.curso.test_front.domain.Factura;
import com.curso.test_front.repository.FacturaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestFrontApplicationTests {

	@Autowired
	FacturaRepository  facturaRepository;
	
	Long idFactura = 0l;
	
	@org.junit.Before
	public void metodoBefore()
	{
		idFactura = 0l;
	}
	
	@After
	public void metodoAfter()
	{
		int b = 0;
	}
	
	@Test
	@Rollback(false)
	public void  primero() {
		
		Factura f = new Factura();
		f.setCliente("Facundo");
		f.setNumero(123L);
		
		facturaRepository.save(f);
		idFactura = f.getId();
		
		assert(f.getId()!=null);
	}
	
	@Test
	public void segundo() {
		
		facturaRepository.deleteById(idFactura);
	}
	
	

}
