package com.free_calendar_system.calendar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.free_calendar_system.calendar.domain.CodeDescriptionAbstract;
import com.free_calendar_system.calendar.repository.CodeDescriptionAbstractRepository;

@Service
public class CodeDescriptionService {
	
	@Autowired
	CodeDescriptionAbstractRepository codeDescriptionAbstractRepository;
	
	public List<CodeDescriptionAbstract> findAll()
	{
		return codeDescriptionAbstractRepository.findAll();
	}
	
	public CodeDescriptionAbstract save(CodeDescriptionAbstract cd)
	{
		return codeDescriptionAbstractRepository.save(cd);
	}
	
	
}
