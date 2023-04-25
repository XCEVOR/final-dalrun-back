package com.dalrun.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.CrewBbsDto;

@Mapper
@Repository
public interface CrewBbsDao {
	CrewBbsDto getCrewBbs(int cBbSeq);
	
	int writeCrewBbs(CrewBbsDto crewBbs);

}
