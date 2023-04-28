package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.CourseReplyDto;

@Mapper
@Repository
public interface CourseReplyDao {

	List<CourseReplyDto> courseReplyList();

}
