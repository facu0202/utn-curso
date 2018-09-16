package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Persona;

@Controller
public class PersonaController {

	List<Persona> personas = new ArrayList<>();
	
	
	public PersonaController() {
		super();
		personas.add(new Persona("1", "Facu1", "apellido1"));
		personas.add(new Persona("2", "Facu2", "apellido2"));
		personas.add(new Persona("3", "Facu3", "apellido3"));
		
	}

	
	
	@RequestMapping(value = "/personas", method = RequestMethod.GET)
	@ResponseBody
	public List<Persona> getAlls()
	{
		return personas;
	}
	
	@RequestMapping(value = "/personas/{pDni}", method = RequestMethod.GET)
	@ResponseBody
	public Persona getPersona(@PathVariable String pDni)
	{
		return   personas.stream()
	            .filter(e -> e.getDni().equals(pDni))
	            .findFirst()
	            .get();

	}
	
	@RequestMapping(value = "/personas", method = RequestMethod.POST)
	@ResponseBody
	public String postPersona(@RequestBody Persona p)
	{
		personas.add(p);
		return "OK";
	}
	
	@RequestMapping(value = "/personas/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deletePersona(@PathVariable String id )
	{
		Iterator<Persona> xit = personas.iterator();
		while (xit.hasNext())
		{
			Persona v = xit.next();
			if (v.getDni().equals(id))
			{
				xit.remove();
				break;
			}
		}
		return "OK";
	}
	
}
