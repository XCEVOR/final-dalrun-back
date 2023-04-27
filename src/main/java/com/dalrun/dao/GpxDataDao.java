package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.GpxDataDto;

@Mapper
@Repository
public interface GpxDataDao {
	
	List<GpxDataDto> gpxDataList();

}
