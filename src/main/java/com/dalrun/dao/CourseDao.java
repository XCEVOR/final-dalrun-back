package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.CourseDto;
import com.dalrun.dto.SearchParam;

@Mapper
@Repository
public interface CourseDao {

	// 코스 전체 리스트 조회
	List<CourseDto> courseList(String search);
	
	// 추천 코스 정보 삽입
	int insertCourse(CourseDto course);
	
	// 몇몇 기록들 추가
	int insertInfo(CourseDto course);
	
	// 추천 코스 수정
	int updateCourse(CourseDto course);
	
	// 추천 코스 삭제
	int deleteCourse(int courseSeq);
}
