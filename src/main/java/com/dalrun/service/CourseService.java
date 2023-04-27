package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.CourseDao;
import com.dalrun.dto.CourseDto;

@Service
@Transactional
public class CourseService {
	
	@Autowired
	CourseDao dao;
	
	public List<CourseDto> courseList() {
		return dao.courseList();
	}

}
