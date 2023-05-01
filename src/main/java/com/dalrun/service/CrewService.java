package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalrun.dao.CrewDao;
import com.dalrun.dto.CrewDto;
import com.dalrun.dto.CrewMemberDto;
import com.dalrun.dto.CrewPointDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CrewService {

	
	@Autowired
	CrewDao dao;
	
	public List<CrewDto> getCrewRank() {
		return dao.getCrewRank();
	}
	
	public CrewDto getMyCrewinfo(String crewseq) {
		return dao.getMyCrewinfo(crewseq);
	}
	
	public boolean sendDonation(CrewPointDto dto) {
		return dao.sendDonation(dto)>0;
	}
	public boolean MinusPoint(CrewPointDto dto) {
		return dao.MinusPoint(dto)>0;
	}
	public boolean PlusPoint(CrewPointDto dto) {
		return dao.PlusPoint(dto)>0;
	}
	public CrewDto getCrew(int crewSeq) {
		return dao.getCrew(crewSeq);
	}
	public List<CrewMemberDto> getCrewMember(int crewSeq) {
		return dao.getCrewMember(crewSeq);
	}
}
