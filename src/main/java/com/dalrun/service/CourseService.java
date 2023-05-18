package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.CourseDao;
import com.dalrun.dto.CourseDto;
import com.dalrun.dto.SearchParam;

@Service
@Transactional
public class CourseService {

	@Autowired
	CourseDao dao;

	// 코스 리스트 전체 조회
	public List<CourseDto> courseList(String search) {
		return dao.courseList(search);
	}
	
	// 추천 코스 데이터 삽입
	public boolean insertCourse(CourseDto course ) {
		int n = dao.insertCourse(course);
		return n>0? true:false;
	}
	
	// 몇몇 기록들 추가
	public boolean insertInfo(CourseDto course) {
		int n = dao.insertInfo(course);
		return n>0? true:false;
	}
	
	// 추천 코스 수정
	public boolean updateCourse(CourseDto course) {
		int n = dao.updateCourse(course);
		return n>0? true:false;
	}
	
	// 추천 코스 삭제
	public boolean deleteCourse(int courseSeq) {
		int n = dao.deleteCourse(courseSeq);
		return n>0? true:false;
	}

}
