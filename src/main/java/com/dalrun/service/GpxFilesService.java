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
	
	// gpx 파일 입력 후 fileSeq 넘겨줌
	public boolean insertGpxFile(GpxFilesDto gpx) {
		int n = dao.insertGpxFile(gpx);
		return n>0? true:false;
	}

}
