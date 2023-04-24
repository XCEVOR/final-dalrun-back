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
	CrewDto getMyCrewRank(String crewName);
	int sendDonation(CrewPointDto dto);

}
