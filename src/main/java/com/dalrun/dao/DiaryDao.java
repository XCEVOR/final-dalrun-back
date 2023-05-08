package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.DiaryDto;
import com.dalrun.dto.GpxParam;

@Mapper
@Repository
public interface DiaryDao {

	// 다이어리 리스트 조회
	List<DiaryDto> DiaryList();
	
	// 다이어리 총 수
	int getAllDiary(GpxParam param);
	
	// 다이어리 작성
	int insertDiary(DiaryDto diary); // 성공 시 row 개수 넘어옴 = 1
	
	// 총 이동거리, 이동시간, 칼로리 추가
	int updateRecord(DiaryDto diary);
}
