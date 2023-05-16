package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.DiaryDto;
import com.dalrun.dto.GpxDataDto;
import com.dalrun.dto.GpxFilesDto;
import com.dalrun.dto.GpxParam;

@Mapper
@Repository
public interface GpxDataDao {

	// 다이어리 데이터 전체 조회
	List<GpxDataDto> gpxDataList(List<Integer> diarySeqList);
	
	// 다이어리 데이터 삽입
	int insertGpxData(GpxDataDto point);
	
	// 특정 데이터 조회
	List<GpxDataDto> getGPXData(int data);
	
	// 코스 데이터 삽입
	int insertCourseGpxData(GpxDataDto point);
	
	// 코스 데이터 전체 조회
	List<GpxDataDto> courseGpxList();
	
	// 코스 데이터 삭제
	int deleteCourseData(int courseSeq);

}