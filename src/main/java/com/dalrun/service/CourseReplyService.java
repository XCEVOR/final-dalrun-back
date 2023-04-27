package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.CourseReplyDao;
import com.dalrun.dto.CourseReplyDto;

@Service
@Transactional
public class CourseReplyService {

	@Autowired
	CourseReplyDao dao;

	public List<CourseReplyDto> courseReplyList() {
		return dao.courseReplyList();
	}
}
