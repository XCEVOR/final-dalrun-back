package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.GpxDataDao;
import com.dalrun.dto.DiaryDto;
import com.dalrun.dto.GpxDataDto;
import com.dalrun.dto.GpxFilesDto;
import com.dalrun.dto.GpxParam;

@Service
@Transactional
public class GpxDataService {

	@Autowired
	GpxDataDao dao;

	// 다이어리 데이터 전체 조회
	public List<GpxDataDto> gpxDataList(List<Integer> diarySeqList) {
		return dao.gpxDataList(diarySeqList);
	}
	
	// 다이어리 데이터 삽입
	public boolean insertGpxData(GpxDataDto point) {
		int n = dao.insertGpxData(point);
		return n>0? true:false;
	}
	
	// 특정 데이터 조회
	public List<GpxDataDto> getGPXData(int data) {
		return dao.getGPXData(data);
	}
	
	// 코스 데이터 삽입
	public boolean insertCourseGpxData(GpxDataDto point) {
		int n = dao.insertCourseGpxData(point);
		return n>0? true:false;
	}
	
	// 코스 전체 데이터 조회
	public List<GpxDataDto> courseGpxList(){
		return dao.courseGpxList();
	}
	
	// 코스 데이터 삭제
	public boolean deleteCourseData(int courseSeq) {
		int n = dao.deleteCourseData(courseSeq);
		return n>0? true:false;
	}

}