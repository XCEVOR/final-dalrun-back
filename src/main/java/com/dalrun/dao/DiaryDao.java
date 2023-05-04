package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.DiaryDto;

@Mapper
@Repository
public interface DiaryDao {

	// 다이어리 리스트 조회
	List<DiaryDto> getAllDiary();
	
	// 다이어리 작성
	int insertDiary(DiaryDto diary); // 성공 시 row 개수 넘어옴 = 1
}
