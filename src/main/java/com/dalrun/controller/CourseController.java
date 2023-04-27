package com.dalrun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.CourseDto;
import com.dalrun.dto.CourseReplyDto;
import com.dalrun.service.CourseReplyService;
import com.dalrun.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	CourseService cService;
	
	@Autowired
	CourseReplyService crService;
	
	@GetMapping("courseList")
	public List<CourseDto> courseList(){
		return cService.courseList();
	}
	
	@GetMapping("courseReplyList")
	public List<CourseReplyDto> courseReplyList(){
		return crService.courseReplyList();
	}

}	// <Course Controller/>
