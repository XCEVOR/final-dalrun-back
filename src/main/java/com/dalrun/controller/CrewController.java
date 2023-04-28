package com.dalrun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("getMyCrewinfo")
	public CrewDto getMyCrewinfo(String crewseq){
		System.out.println("CrewController getMyCrewinfo");
		return service.getMyCrewinfo(crewseq);
	}
	
	@GetMapping("sendDonation")
	public boolean sendDonation(CrewPointDto dto){
		service.PlusPoint(dto);
		return service.sendDonation(dto);

	}
	
	@PostMapping(value = "getcrew")
	public CrewDto getCrew(@RequestParam("target") int crewSeq) {
		System.out.println("CrewController getCrew");
		return service.getCrew(crewSeq);
	}
}
