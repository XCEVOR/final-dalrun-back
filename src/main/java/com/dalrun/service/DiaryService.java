package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.DiaryDao;
import com.dalrun.dto.DiaryDto;

@Service
@Transactional
public class DiaryService {
	
	@Autowired
	DiaryDao dao;
	
	public List<DiaryDto> getAllDiary() {
		return dao.getAllDiary(); 
	}

}
