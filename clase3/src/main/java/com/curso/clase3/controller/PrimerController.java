package com.curso.clase3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.curso.clase3.repository.TeachingStaffRepository;

@Controller
public class PrimerController {

	
	@Autowired
	TeachingStaffRepository teachingStaffRepository; 
	
	@RequestMapping(value = "/hola", method = RequestMethod.GET)
	@ResponseBody
	public String hola( )
	{
		
		teachingStaffRepository.findAll();
		return "hola !!!";
	}
	
	

}
