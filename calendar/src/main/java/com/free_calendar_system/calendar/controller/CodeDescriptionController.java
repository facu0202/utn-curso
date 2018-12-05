package com.free_calendar_system.calendar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.free_calendar_system.calendar.controller.dto.CodeDescriptionDTO;
import com.free_calendar_system.calendar.domain.CodeDescriptionAbstract;
import com.free_calendar_system.calendar.service.CodeDescriptionService;

@Controller
@RequestMapping(value="cd")
public class CodeDescriptionController {

	@Autowired
	CodeDescriptionService codeDescriptionService;
	
	@RequestMapping(value="/list")
	public String list(Model model)
	{
		
		List<CodeDescriptionAbstract> l = codeDescriptionService.findAll();
		model.addAttribute("lista", getDtos(l));
		return "codedescription/list";
	}
	
	@RequestMapping(value="/crear", method=RequestMethod.GET)
	public String crear(Model model)
	{
		
		model.addAttribute("codeDescription", new CodeDescriptionDTO());
		model.addAttribute("tipos",CodeDescriptionDTO.TIPOS);
		return "codedescription/crear";
	}
	
	@RequestMapping(value="/crear", method=RequestMethod.POST)
	public String crearPost(Model model,@ModelAttribute CodeDescriptionDTO cdDTO)
	{

		//return "codedescription/crear";
		codeDescriptionService.save(cdDTO.getNativeObject());
		return "redirect:list"; 
	}
	
	private List<CodeDescriptionDTO> getDtos(List<CodeDescriptionAbstract> l )
	{
		List<CodeDescriptionDTO> result = new ArrayList<>();
		for (CodeDescriptionAbstract codeDescription : l) {
			result.add(new CodeDescriptionDTO(codeDescription));
		}
		return result;
		
	}
	
	
	
}
