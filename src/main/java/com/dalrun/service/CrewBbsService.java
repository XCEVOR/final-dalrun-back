package com.dalrun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalrun.dao.CrewBbsDao;
import com.dalrun.dto.CrewBbsDto;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CrewBbsService {
	@Autowired
	CrewBbsDao dao;
	
	public CrewBbsDto getCrewBbs(int cBbSeq) {
		return dao.getCrewBbs(cBbSeq);
	}
	
	public boolean writeCrewBbs(CrewBbsDto crewBbs) {
		int n=dao.writeCrewBbs(crewBbs);
		return n>0?true:false;
	}

}
