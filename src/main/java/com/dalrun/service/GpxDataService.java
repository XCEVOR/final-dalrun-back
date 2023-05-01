package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.GpxDataDao;
import com.dalrun.dto.GpxDataDto;

@Service
@Transactional
public class GpxDataService {

	@Autowired
	GpxDataDao dao;

	// 데이터 전체 조회
	public List<GpxDataDto> gpxDataList() {
		return dao.gpxDataList();
	}
	
	// 데이터 삽입
	public boolean insertGpxData(GpxDataDto point) {
		int n = dao.insertGpxData(point);
		return n==0? true:false;
	}
	

}