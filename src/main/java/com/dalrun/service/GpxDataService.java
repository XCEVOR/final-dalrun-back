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

	public List<GpxDataDto> gpxDataList() {
		return dao.gpxDataList();
	}

}
