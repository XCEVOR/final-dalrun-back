package com.dalrun.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.CompCommentDto;
import com.dalrun.dto.CompetitionDto;
import com.dalrun.dto.MemberDto;
import com.dalrun.dto.SearchParam;
import com.dalrun.service.CompetitionService;

@RestController
public class CompetitionController {

	
	@Autowired
	CompetitionService service;
	private void pageNumber(SearchParam params) {
	    // 글의 시작과 끝
	    int pn = params.getPageNumber();  // 0 1 2 3 4
	    int start = 1 + (pn * 5);    // 1  6
	    int end = (pn + 1) * 5;    // 5 10

	    params.setStart(start);
	    params.setEnd(end);
	}
	
	private Map<String, Object> getList(List<?> list, int cnt) {
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", cnt);
		
		return map;
	}
	
	// 각 테이블의 리스트, 글의 총 수 불러오기
		// 회원 관리
		@GetMapping(value = "getAllList")
		public Map<String, Object> getAllList(SearchParam params) {
			System.out.println("CompetitionController getAllList "+new Date());
		    
		    pageNumber(params);	    
		    List<CompetitionDto> competitionList = service.getAllList(params);
			int len = service.getAllListCount(params);
		    
			return getList(competitionList, len);
		}

	@GetMapping(value="getAllListThisMonth")
	public List<CompetitionDto> getAllListThisMonth(){
		System.out.println("CompetitionController getAllListThisMonth "+new Date());
		return service.getAllListThisMonth();
	}
	@GetMapping(value="getPopularList")
	public List<CompetitionDto> getPopularList(){
		System.out.println("CompetitionController getPopularList "+new Date());
		return service.getPopularList();
	}
	
	@GetMapping(value="getCompBbs")
	public CompetitionDto getCompBbs(int compSeq){
	   System.out.println("CompetitionController getCompBbs "+new Date());
	   service.compReadcount(compSeq);
		return service.getCompBbs(compSeq);
	}
	
	@GetMapping(value="getCompCommentList")
	public List<CompCommentDto> getCompCommentList(int compSeq){
	   System.out.println("CompetitionController getCompCommentList "+new Date());
	   
		return service.getCompCommentList(compSeq);
	}
	@GetMapping(value="sendComment")
	public String sendComment (CompCommentDto dto){
		System.out.println("CompetitionController sendComment "+new Date());
		String str= "NO";
		
		if(service.sendComment(dto)) {
			str="YES";
		}
		
		return str;
	}
	
	
	
	
	
	
}
