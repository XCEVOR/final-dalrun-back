package com.dalrun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.CrewMemberDto;
import com.dalrun.service.CrewMemberService;

@RestController
public class CrewMemberController {
	
	@Autowired
	CrewMemberService service;
	
//	@PostMapping("/join")
//	public ResponseEntity<String> joinCrew(@RequestBody CrewMemberDto memberdto){
//		int crewSeq = service.getCrewSeq(memberdto);
//		
//	}

}
