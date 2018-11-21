package com.curso.test_front.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.curso.test_front.domain.Factura;
import com.curso.test_front.repository.FacturaRepository;

@Service
public class FacturaService {

	
	@Autowired
	FacturaRepository  facturaRepository;
	
	
	public Factura save(Factura f)
	{
		return facturaRepository.save(f);
	}
	
	public void delete(Long id)
	{
		Factura fac = new Factura();
		fac.setId(id);
		facturaRepository.delete(fac);
	}
	
	public Iterable<Factura> findAll()
	{
		return facturaRepository.findAll();
	}
	
}
