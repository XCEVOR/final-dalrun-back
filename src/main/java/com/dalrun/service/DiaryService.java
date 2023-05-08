package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.DiaryDao;
import com.dalrun.dto.DiaryDto;
import com.dalrun.dto.GpxParam;

@Service
@Transactional
public class DiaryService {

	@Autowired
	DiaryDao dao;

	// 다이어리 리스트 조회
	public List<DiaryDto> DiaryList() {
		return dao.DiaryList();
	}
	
	// 다이어리 총 수
	public int getAllDiary(GpxParam param) {
		return dao.getAllDiary(param);
	}
	
	// 다이어리 글 작성 후 키 값 넘겨주기
	public boolean insertDiary(DiaryDto diary) {
		int n = dao.insertDiary(diary);
		return n>0? true:false;
	}
	
	// 총 이동거리, 이동시간, 칼로리 추가
	public boolean updateRecord(DiaryDto diary) {
		int n = dao.updateRecord(diary);
		return n>0? true:false;
	}

}
