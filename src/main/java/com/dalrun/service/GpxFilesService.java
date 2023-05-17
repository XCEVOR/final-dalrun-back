package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.GpxFilesDao;
import com.dalrun.dto.GpxFilesDto;

@Service
@Transactional
public class GpxFilesService {

	@Autowired
	GpxFilesDao dao;

	// gpx 파일 리스트 조회
	public List<GpxFilesDto> gpxFilesList() {
		return dao.gpxFilesList();
	}
	
	// diary gpx 파일 입력 후 fileSeq 넘겨줌
	public boolean insertDiaryGpxFile(GpxFilesDto gpx) {
		int n = dao.insertDiaryGpxFile(gpx);
		return n>0? true:false;
	}
	
	// course gpx 파일 입력 후 fileSeq 넘겨줌
	public boolean insertCourseGpxFile(GpxFilesDto gpx) {
		int n = dao.insertCourseGpxFile(gpx);
		return n>0? true:false;
	}
	
	// user gpx 파일 입력 후 fileSeq 넘겨줌
	public boolean insertUserGpxFile(GpxFilesDto gpx) {
		int n = dao.insertUserGpxFile(gpx);
		return n>0? true:false;
	}
	
	// courseSeq 관련 gpxfile 목록 넘겨줌
	public List<GpxFilesDto> selectCourseFiles(int courseSeq) {
		return dao.selectCourseFiles(courseSeq);
	}
	
	// course gpx 파일 db 삭제 여부
	public boolean deleteCourseFiles(int courseSeq) {
		int n = dao.deleteCourseFiles(courseSeq);
		return n>0? true:false;
	}

}
