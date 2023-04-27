package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalrun.dao.CrewDao;
import com.dalrun.dto.CrewDto;
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
	
	public CrewDto getMyCrewRank(String crewName) {
		return dao.getMyCrewRank(crewName);
	}
	
	public boolean sendDonation(CrewPointDto dto) {
		return dao.sendDonation(dto)>0;
	}
	
}
