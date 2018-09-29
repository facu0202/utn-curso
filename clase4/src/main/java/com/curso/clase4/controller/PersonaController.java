package com.curso.clase4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.curso.clase4.domain.Persona;
import com.curso.clase4.repository.PersonaRepository;

@Controller
@RequestMapping(value="personas")
public class PersonaController {

	@Autowired
	PersonaRepository personaRepository; 
	
	@RequestMapping(value="/crear")
	public String crearForm(Model model)
	{
		model.addAttribute("persona", new Persona());
		return "persona/crear"; 
	}
	
	@RequestMapping(value="/modificar/{id}")
	public String modificarForm(Model model,@PathVariable("id") Long id)
	{
		model.addAttribute("persona", personaRepository.findById(id));
		return "persona/modificar"; 
	}
	
	@RequestMapping(value="/modificar",method = RequestMethod.POST)
	public String modificar(Model model,@ModelAttribute Persona persona)
	{
		personaRepository.save(persona);
		
		return "redirect:"; 
	}
	
	@RequestMapping(value="/crear",method = RequestMethod.POST)
	public String crear(Model model,@ModelAttribute Persona persona)
	{
		personaRepository.save(persona);
		
		return "redirect:"; 
	}
		
	@RequestMapping(value="/")
	public String listar(Model model)
	{
		model.addAttribute("personas", personaRepository.findAll());
		return "persona/list";
	}
}
