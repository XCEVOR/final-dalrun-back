package com.dalrun.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalrun.dao.CrewMemberDao;
import com.dalrun.dto.CrewDto;
import com.dalrun.dto.CrewMemberDto;

@Service
public class CrewMemberService {
	@Autowired
	private CrewMemberDao dao;
	
//	//유저가 다른 크루나 대기열에 있는지
//	 public boolean isWaiting(String memId){
//	      return dao.checkMember(memId)!=null;
//	   }
//
//	 //실제 가입 
//	   public boolean joinCrew(CrewMemberDto dto){
//		   //이미 대기열에 있으면 false
//	      if(isWaiting(dto.getMemId())){
//	         return false;
//	      }
//	      int res = dao.insertMember(dto);
//	      //한가지 행에 대해서만 change(crewSeq)
//	      if(res==1){
//	         return true;
//	      }
//	      return false;
//	   }
//
//	   //승인												요청자의 memId
//	   public boolean approve(CrewMemberDto dto, String requestMemId){
//		   //리더 정보 가져옴 만약 리더가 아니라면
//	      if(dao.getLeader(dto.getCrewSeq())!=requestMemId){
//	    	  //false
//	         return false;
//	      }
//	      try{
//	         dao.changeMember(dto);
//	         dao.changeCrew(dto.getCrewSeq());
//	         dao.deleteFromList(dto); //crewMember table에서 삭제
//	      }catch(Exception e){
//	         return false;
//	      }
//	      return true;
//	   }
//
//	   //거절
//	   public boolean reject(CrewMemberDto dto, String requestMemId){
//	      if(dao.getLeader(dto.getCrewSeq())!=requestMemId){
//	         return false;
//	      }
//	      try{
//	         dao.deleteFromList(dto);
//	      }catch(Exception e){
//	         return false;
//	      }
//	      return true;
//	   }

		//유저가 다른 크루대기테이블에 있는지 체크
		public boolean isWaiting(CrewMemberDto dto){
		      return dao.checkMember(dto.getMemId())!=null;
		   }
	
		//가입버튼 클릭 시 
	   public boolean joinCrew(CrewMemberDto dto){
		   //가입버튼 클릭한 user가 다른 크루대기테이블에 있다면
	      if(isWaiting(dto)){
	    	  //false
	         return false;
	      }
	      //없다면 크루대기테이블에 insert
	      int res = dao.insertMember(dto);
	      //결과값이 1이면
	      if(res==1){
	         return true;
	      }
	      return false;
	   }
	
	   //승인버튼 클릭 시
	   public boolean approve(CrewMemberDto dto){
		   //리더 체크
	      if(dao.getLeader(dao.getCrewSeq(dto.getMemId()))!=dto.getReqMemId()){
	         return false;
	      }
	      try{
	    	  //멤버테이블 update
	         dao.changeMember(dto);
	         //crew테이블 update
	         dao.changeCrew(dto.getCrewSeq());
	         //대기테이블(crewMember table)에서 삭제
	         dao.deleteFromList(dto);
	      }catch(Exception e){
	         return false;
	      }
	      return true;
	   }
	
	   //거절
	   public boolean reject(CrewMemberDto dto){
	      if(dao.getLeader(dao.getCrewSeq(dto.getMemId()))!=dto.getReqMemId()){
	         return false;
	      }
	      try{
	         dao.deleteFromList(dto);
	      }catch(Exception e){
	         return false;
	      }
	      return true;
	   }

}
