package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.CrewDto;
import com.dalrun.dto.CrewPointDto;

@Mapper
@Repository
public interface CrewDao {
	
	List<CrewDto> getCrewRank();
	CrewDto getMyCrewinfo(String crewseq);
	int sendDonation(CrewPointDto dto);
	int MinusPoint(CrewPointDto dto);
	int PlusPoint(CrewPointDto dto);

}
