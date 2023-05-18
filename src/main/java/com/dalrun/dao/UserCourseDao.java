package com.dalrun.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.CourseDto;
import com.dalrun.dto.UserCourseDto;

@Mapper
@Repository
public interface UserCourseDao {

	// 추천 코스 정보 삽입
	int insertUserCourse(UserCourseDto course);
	
	// 몇몇 기록들 추가
	int insertUserInfo(UserCourseDto course);
	
	// courseSeq - 유저 코스 기록 삭제
	int deleteUserCourse(int courseSeq);
	
	// userCSeq - 유저 코스 기록 삭제
	int userDeleteCourse(int userCSeq);
}
