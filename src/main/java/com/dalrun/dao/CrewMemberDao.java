package com.dalrun.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.CrewDto;
import com.dalrun.dto.CrewMemberDto;

@Mapper
@Repository
public interface CrewMemberDao {
	
	CrewDto getUserInfo(int crewSeq);
	
	int getCrewSeq(CrewMemberDto memberdto);
	
	int insertCrewMember(CrewMemberDto memberdto);

}
