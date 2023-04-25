package com.dalrun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.CrewDto;
import com.dalrun.dto.CrewPointDto;
import com.dalrun.service.CrewService;

@RestController
public class CrewController {

	@Autowired
	CrewService service;
	
	@GetMapping("getCrewRank")
	public List<CrewDto>getCrewRank(){
		return service.getCrewRank();
	}
	
	@GetMapping("getMyCrewRank")
	public CrewDto getMyCrewRank(String crewName){
		return service.getMyCrewRank(crewName);
	}
	
	@GetMapping("sendDonation")
	public boolean sendDonation(CrewPointDto dto){
	
		return service.sendDonation(dto);

	}
}
