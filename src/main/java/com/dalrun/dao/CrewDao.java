package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.CrewDto;
import com.dalrun.dto.CrewMemberDto;
import com.dalrun.dto.CrewPointDto;

@Mapper
@Repository
public interface CrewDao {
	
	List<CrewDto> getCrewRank();
	CrewDto getMyCrewinfo(int crewSeq);
	int sendDonation(CrewPointDto dto);
	int MinusPoint(CrewPointDto dto);
	int PlusPoint(CrewPointDto dto);
	/*
	 * CrewDto getCrew(int crewSeq); List<CrewMemberDto> getCrewMember(int crewSeq);
	 */
//	int getcrewPoint(int crewSeq);
	int crewUpgrade(int crewSeq);
	
}
