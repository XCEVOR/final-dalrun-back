package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.AdminDao;
import com.dalrun.dto.CrewDto;
import com.dalrun.dto.MemberDto;
import com.dalrun.dto.SearchParam;

@Service
@Transactional
public class AdminService {
	@Autowired
	AdminDao dao;
	
	public List<MemberDto> memberlist(SearchParam params) {
		return dao.memberlist(params);
	}
	
	public int getAllMember(SearchParam params) {
		return dao.getAllMember(params);
	}
	
	public List<CrewDto> crewlist(SearchParam params) {
		return dao.crewlist(params);
	}
	
	public int getAllCrew(SearchParam params) {
		return dao.getAllCrew(params);
	}
}
