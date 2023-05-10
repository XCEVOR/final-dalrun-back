package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.dalrun.dto.DotMapDto;


@Mapper
@Repository
public interface DotMapDao {

	 List<DotMapDto> getAllDotMap();
	 int crew_buydotMap(DotMapDto dto);
	 int my_buydotMap(DotMapDto dto);
	 int crewOutChangeDotmap(DotMapDto dto);
	 int crewInChangeDotmap(DotMapDto dto);
	
	
}
