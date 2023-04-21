package com.dalrun.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.MemberDto;
import com.dalrun.dto.SearchParam;
import com.dalrun.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService service;
	
	// 각 데이터 리스트 가져오기
	@GetMapping(value = "memberlist")
	public Map<String, Object> memberlist(SearchParam params,String grade) {
		System.out.println("AdminController memberlist " + new Date());
		
		// 글의 시작과 끝
		int pn = params.getPageNumber();  // 0 1 2 3 4
		int start = 1 + (pn * 10);	// 1  11
		int end = (pn + 1) * 10;	// 10 20
		
		params.setStart(start);
		params.setEnd(end);
		
		List<MemberDto> memlist = service.memberlist(params, grade);
		int len = service.getAllMember(params, grade);
		
		Map<String, Object> m_map = new HashMap<>();
		m_map.put("memlist", memlist);
		m_map.put("cnt", len);
		
		return m_map;
	}
	
	
}
