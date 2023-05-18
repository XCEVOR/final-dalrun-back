package com.dalrun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.UserCourseDao;
import com.dalrun.dto.CourseDto;
import com.dalrun.dto.UserCourseDto;

@Service
@Transactional
public class UserCourseService {

	@Autowired
	UserCourseDao dao;
	
	// 유저 코스 데이터 삽입
	public boolean insertUserCourse(UserCourseDto course ) {
		int n = dao.insertUserCourse(course);
		return n>0? true:false;
	}
	
	// 몇몇 기록들 추가
	public boolean insertUserInfo(UserCourseDto course) {
		int n = dao.insertUserInfo(course);
		return n>0? true:false;
	}
	
	// courseSeq - 유저 코스 데이터 삭제
	public boolean deleteUserCoure(int courseSeq) {
		int n = dao.deleteUserCourse(courseSeq);
		return n>0? true:false;
	}
	
	// userCSeq - 유저 코스 데이터 삭제
	public boolean userDeleteCourse(int userCSeq) {
		int n = dao.userDeleteCourse(userCSeq);
		return n>0? true:false;
	}
	
}
