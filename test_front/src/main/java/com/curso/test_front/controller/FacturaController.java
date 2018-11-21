package com.curso.test_front.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.test_front.domain.Factura;
import com.curso.test_front.services.FacturaService;

@Controller
@RequestMapping(value = "/fac")
public class FacturaController {
	
	@Autowired
	FacturaService facturaService;
	
	public Factura save(Factura f)
	{
		return facturaService.save(f);
	}
	

	@RequestMapping(value="/listar")
	public String list(Model model)
	{
		model.addAttribute("facturas", facturaService.findAll());
		return "listApplications" ;
	}
	
	@RequestMapping(value="/create")
	public String crear(Model model)
	{
		model.addAttribute("fac", new Factura());
		return "createApplication" ;
	}
	
	@RequestMapping(value="/guardar")
	public String guardar(Model model,@Valid Factura fac)
	{
		facturaService.save(fac);
		return "redirect:/fac/listar"; 
	}
	
	@RequestMapping(value="/delete/{id}")
	public String guardar(Model model,@PathVariable(value="id") long id)
	{
		facturaService.delete(id);
		return "redirect:/fac/listar"; 
	}
}
