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

	// 다이어리 리스트 조회
	public List<DiaryDto> getAllDiary() {
		return dao.getAllDiary();
	}
	
	// 다이어리 글 작성 후 키 값 넘겨주기
	public boolean insertDiary(DiaryDto diary) {
		int n = dao.insertDiary(diary);
		return n>0? true:false;
	}

}
