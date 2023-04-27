package com.dalrun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.DiaryDto;
import com.dalrun.dto.DiaryReplyDto;
import com.dalrun.service.DiaryReplyService;
import com.dalrun.service.DiaryService;

@RestController
public class DiaryController {

	@Autowired
	DiaryService dService;

	@Autowired
	DiaryReplyService drService;

	@GetMapping("getAllDiary")
	public List<DiaryDto> getAllDiary(){
		return dService.getAllDiary();
	}

	@GetMapping("diaryReplyList")
	public List<DiaryReplyDto> diaryReplyList(){
		return drService.diaryReplyList();
	}

} // <Diary Controller/>
