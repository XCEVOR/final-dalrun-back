package com.dalrun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalrun.dao.CrewMemberDao;
import com.dalrun.dto.CrewDto;
import com.dalrun.dto.CrewMemberDto;

@Service
public class CrewMemberService {
	@Autowired
	private CrewMemberDao dao;
	
	public CrewDto getUserInfo(int crewSeq) {
		return dao.getUserInfo(crewSeq);
	}
	
	public boolean insertCrewMember(CrewMemberDto memberdto) {
		int n = dao.insertCrewMember(memberdto);
		return n>0?true:false;
	}

}
