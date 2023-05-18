package com.dalrun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.CrewMemberDto;
import com.dalrun.service.CrewMemberService;

@RestController
public class CrewMemberController {
	
	@Autowired
	CrewMemberService service;
	
	@GetMapping("getCrewMemberWait")
	public List<CrewMemberDto> getCrewMemberWait(int crewSeq) {
		System.out.println("CrewController getCrewMemberWait");
		
		return service.getCrewMemberWait(crewSeq);
	}
	
	
//  @PostMapping("/join")
//  public ResponseEntity<String> joinCrew(@RequestBody CrewMemberDto memberdto){
//     int crewSeq = service.getCrewSeq(memberdto);
//     
//  }
	//가입 취소
	@PostMapping("OutCrew")
	  public boolean OutCrew(CrewMemberDto dto) {
	      return service.deleteFromList(dto);
		      
		}
	
	
	@GetMapping("getLeader")
	public String getLeader(int crewSeq) {
		return service.getLeader(crewSeq);
	}
	
	//가입 신청
	@PostMapping("joinCrew")
	   public String joinCrew(CrewMemberDto dto){
	
	      if(service.joinCrew(dto)){
	         return "success";
	      }else{
	         return "failed";
	      }
	   }

//<<<<<<< HEAD
//	//다른 크루 대기 테이블에 있는지
//	   @PostMapping("/checkWaiting")
//	   public boolean checkWaiting(@RequestBody CrewMemberDto dto){
//=======
//	   @GetMapping("checkWaiting")
//	   public boolean checkWaiting(CrewMemberDto dto){
//		   System.out.println("CrewMemberController checkWaiting");
//>>>>>>> branch 'master' of https://github.com/realParkYerin/final-dalrun-back.git
//	      return service.isWaiting(dto);
//	   }

	   //승인
	   @PostMapping("/approve")
	   public String approve(@RequestBody CrewMemberDto dto){
	      if(service.approve(dto)){
	         return "success";
	      }else{
	         return "failed";
	      }
	   }

	   //거절
	   @PostMapping("/reject")
	   public String reject(@RequestBody CrewMemberDto dto){
	      if(service.reject(dto)){
	         return "success";
	      }else{
	         return "failed";
	      }
	   }


}
