package com.dalrun.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.CrewBbsDto;
import com.dalrun.service.CrewBbsService;

@RestController
public class CrewBbsController {
	
	@Autowired
	CrewBbsService service;
	
	@GetMapping(value="getCrewBbs")
	public CrewBbsDto getCrewBbs(int cBbSeq) {
		System.out.println("CrewBbsController CrewBbsDto" + new Date());
		
		return service.getCrewBbs(cBbSeq);
	}
	
	@PostMapping(value="crewBbsWrite")
	public String crewBbsWrite(CrewBbsDto crewBbs) {
		System.out.println("CrewBbsController crewBbsWrite" + new Date());
		
		boolean b = service.writeCrewBbs(crewBbs);
		if(b==false) {
			return "NO";
		}
		return "YES";
	}
}
