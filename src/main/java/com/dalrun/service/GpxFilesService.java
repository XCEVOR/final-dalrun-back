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

	public List<GpxFilesDto> gpxFilesList() {
		return dao.gpxFilesList();
	}

}
