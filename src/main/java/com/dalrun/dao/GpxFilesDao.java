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
	
	// 다이어리 gpx 파일 정보 삽입
	int insertDiaryGpxFile(GpxFilesDto gpx);	// fileSeq 넘어옴.
	
	// 추천 코스 gpx 파일 정보 삽입
	int insertCourseGpxFile(GpxFilesDto gpx);	// fileSeq 넘어옴.
	
	// 유저 코스 gpx 파일 정보 삽입
	int insertUserGpxFile(GpxFilesDto gpx);	// fileSeq 넘어옴.
	
	// 추천 코스 gpx 파일 정보 조회
	List<GpxFilesDto> selectCourseFiles(int courseSeq);
	
	// 추천 코스 gpx 파일 DB 삭제
	int deleteCourseFiles(int courseSeq);
	
}