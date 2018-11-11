package com.curso.clase4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.curso.clase4.domain.Domicilio;
import com.curso.clase4.repository.DomiclioRepository;
import com.curso.clase4.servicio.ServicioEjemplo;

@Controller
@RequestMapping(value="domicilio")
public class DomicilioController {
	
	
	@Autowired
	DomiclioRepository domiclioRepository; 
	
	@Autowired
	ServicioEjemplo servicioEjemplo1; 
	
	@RequestMapping(value="/")
	@ResponseBody
	public Domicilio test()
	{
		
		Domicilio prueba = new Domicilio();
		prueba.setDireccion("direccion de prueba");
		domiclioRepository.save(prueba);
		return prueba;
	}
	
	@RequestMapping(value="/list")
	public String list(Model model)
	{
		
		model.addAttribute("domicilios", domiclioRepository.findAll());
		return "domicilio/list";
	}
	@RequestMapping(value="/crear")
	public String crear(Model model)
	{
		
		model.addAttribute("domicilio", new Domicilio());
		return "domicilio/crear";
	}
	
	@RequestMapping(value="/crear",method = RequestMethod.POST)
	public String crearFinal(Model model,@ModelAttribute Domicilio domicilio)
	{
		

		domiclioRepository.save(domicilio);
		
		return "redirect:list"; 
	}

}
