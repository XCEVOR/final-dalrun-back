package com.dalrun.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.CrewDto;
import com.dalrun.dto.CrewMemberDto;

@Mapper
@Repository
public interface CrewMemberDao {
	List<CrewMemberDto> getCrewMemberWait(int crewSeq);
	
	int insertMember(CrewMemberDto dto);
	
    int checkMember(String memId);
    

    int deleteFromList(CrewMemberDto dto);

    int changeMember(CrewMemberDto dto);

    int changeCrew(int crewSeq);

    String getLeader(int crewSeq);

    int getCrewSeq(String memId);


}
