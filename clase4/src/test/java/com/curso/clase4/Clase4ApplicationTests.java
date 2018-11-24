package com.curso.clase4;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.curso.clase4.domain.Factura;
import com.curso.clase4.domain.Item;
import com.curso.clase4.repository.FacturaRepository;

@RunWith(SpringRunner.class) //levanta el contexto de spring
@SpringBootTest // indica que es un test
@Transactional
public class Clase4ApplicationTests {
	
	@Autowired
	FacturaRepository facturaRepository; 

	//@Test
	@Rollback(false)
	public void testFacutra() {
		
		Factura fac = new Factura(); 
		fac.setCliente("Facundo");
		fac.setNumero(1L);
		for (int i = 0; i < 5; i++) {
			
			Item item = new Item();
			item.setDescripcion("item "+i);
			//item.setFactura(fac);
			item.setImporte(10L);
			fac.getItems().add(item);
		}
		
		facturaRepository.save(fac);
		
		
	}
	
	@Test
	@Rollback(false)
	public void getFactura() {
		
		Iterable<Factura> list = facturaRepository.findAll();
		for (Factura factura : list) {
			System.out.println(factura);
		}
	}
	

}
