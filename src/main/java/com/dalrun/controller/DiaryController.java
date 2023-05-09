package com.dalrun.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.DiaryDto;
import com.dalrun.dto.DiaryReplyDto;
import com.dalrun.dto.SearchParam;
import com.dalrun.service.DiaryReplyService;
import com.dalrun.service.DiaryService;

@RestController
public class DiaryController {

	@Autowired
	DiaryService dService;
	
	@Autowired
	DiaryReplyService drService;

	// 다이어리 리스트
	@GetMapping("diaryList")
	public Map<String, Object> DiaryList(SearchParam param){// List -> Map, ajax는 한번에 데이터를 옮기면 안되고 각각 데이터를 따로따로 보내줘야 한다.
													   // 여러 개의 데이터를 한꺼번에 json 형태로 보내는 법 -> HashMap
		System.out.println("DiaryController diaryList" + new Date());
		
		// 글의 시작과 끝
		int pn = param.getPageNumber();  // 0 1 2 3 4
		int start = 1 + (pn * 10);	// 1  11 21
		int end = (pn + 1) * 10;	// 10 20 30
		
		param.setStart(start);
		param.setEnd(end);
		
		List<DiaryDto> list = dService.diaryList(param);
		int len = dService.getAllDiary(param);
		
		int cnt = len / 10;
		if((len % 10) > 0) {	// 총 글 수가 페이지 한도를 넘을 시 페이지 추가
			cnt = cnt + 1;
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", cnt);	// wrapper 형태로 들어 감
		
		return map;
	}

	// 다이어리 댓글 리스트
	@GetMapping("diaryReplyList")
	public List<DiaryReplyDto> diaryReplyList(){
		System.out.println("DiaryController diaryReplyList" + new Date());
		return drService.diaryReplyList();
	}

} // <Diary Controller/>
