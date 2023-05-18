package com.dalrun.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.CrewDto;
import com.dalrun.dto.CrewMemberDto;
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
	public CrewDto getMyCrewinfo(int crewSeq){
		System.out.println("CrewController getMyCrewinfo");
		
		CrewDto dto= service.getMyCrewinfo(crewSeq);
		if(dto.getCrewLevel()==1) {
			dto.setCrewTotalScore(Math.round(dto.getCrewTotalScore()*1.1));
		}else if(dto.getCrewLevel()==2) {
			dto.setCrewTotalScore(Math.round(dto.getCrewTotalScore()*1.2));
		}else if(dto.getCrewLevel()==3) {
			dto.setCrewTotalScore(Math.round(dto.getCrewTotalScore()*1.3));
		}else if(dto.getCrewLevel()==4) {
			dto.setCrewTotalScore(Math.round(dto.getCrewTotalScore()*1.4));
		}else if(dto.getCrewLevel()==5) {
			dto.setCrewTotalScore(Math.round(dto.getCrewTotalScore()*1.5));
		}
		
		return dto;
	}
	
	@GetMapping("sendDonation")
	public boolean sendDonation(CrewPointDto dto){
		service.PlusPoint(dto);
		
		MemberDto mdto = new MemberDto();
		mdto.setPoint(dto.getScore());
		mdto.setMemId(dto.getId());
		
		Mservice.MemberMinusPoint(mdto);
		
		return service.sendDonation(dto);

	}
	
	/*
	 * @PostMapping(value = "getcrew") public CrewDto
	 * getCrew(@RequestParam("target") int crewSeq) {
	 * System.out.println("CrewController getCrew " + new Date()); return
	 * service.getCrew(crewSeq); }
	 * 
	 * @PostMapping(value = "getCrewMember") public List<CrewMemberDto>
	 * getCrewMember(int crewSeq) {
	 * System.out.println("CrewController getCrewMember " + new Date()); return
	 * service.getCrewMember(crewSeq); }
	 */
	
	/*
	 * @GetMapping(value = "getcrewPoint") public int getcrewPoint(int crewSeq) {
	 * return service.getcrewPoint(crewSeq); }
	 */
	
	@GetMapping(value="crewUpgrade")
	public boolean crewUpgrade(int crewSeq,int score) {
		System.out.println("CrewController crewUpgrade");
		
//		CrewPointDto pdto=new CrewPointDto();
//		pdto.setCrewSeq(crewSeq);
//		pdto.setScore(score);
//		System.out.println(pdto.toString());
//		service.MinusPoint(pdto);
		return service.crewUpgrade(crewSeq);
		
	}
	
}
