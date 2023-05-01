package com.dalrun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.CrewDto;
import com.dalrun.dto.CrewPointDto;
import com.dalrun.dto.MemberDto;
import com.dalrun.service.CrewService;
import com.dalrun.service.MemberService;

@RestController
public class CrewController {

	@Autowired
	CrewService service;
	
	@Autowired
	MemberService Mservice;
	
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
		
		MemberDto mdto = new MemberDto();
		mdto.setPoint(dto.getScore());
		mdto.setMemId(dto.getId());
		
		
		Mservice.MinusPoint(mdto);
		return service.sendDonation(dto);

	}
}
