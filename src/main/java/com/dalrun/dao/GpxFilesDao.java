package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.GpxFilesDto;

@Mapper
@Repository
public interface GpxFilesDao {

	// gpx 파일 리스트 조회
	List<GpxFilesDto> gpxFilesList();
	
	// gpx 파일 정보 삽입
	int insertGpxFile(GpxFilesDto gpx);	// fileSeq 넘어옴.
	
	
}