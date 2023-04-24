package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.CrewDto;
import com.dalrun.dto.MemberDto;
import com.dalrun.dto.SearchParam;

@Repository
@Mapper
public interface AdminDao {
	
	List<MemberDto> memberlist(SearchParam params);
	
	int getAllMember(SearchParam params);
	
	List<CrewDto> crewlist(SearchParam params);
	
	int getAllCrew(SearchParam params);
}
