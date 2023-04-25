package com.dalrun.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.CrewDto;
import com.dalrun.dto.MemberDto;
import com.dalrun.dto.SearchParam;
import com.dalrun.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService service;
	
	private void pageNumber(SearchParam params) {
	    // 글의 시작과 끝
	    int pn = params.getPageNumber();  // 0 1 2 3 4
	    int start = 1 + (pn * 10);    // 1  11
	    int end = (pn + 1) * 10;    // 10 20

	    params.setStart(start);
	    params.setEnd(end);
	}
	
	private Map<String, Object> getList(List<?> list, int cnt) {
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", cnt);
		
		return map;
	}
	
	@GetMapping(value = "admin_memberlist")
	public Map<String, Object> memberlist(SearchParam params) {
	    System.out.println("AdminController memberlist " + new Date());
	    
	    pageNumber(params);	    
	    List<MemberDto> memberlist = service.memberlist(params);
		int len = service.getAllMember(params);
	    
	    return getList(memberlist, len);
	}

	@GetMapping(value = "admin_crewlist")
	public Map<String, Object> crewlist(SearchParam params) {
	    System.out.println("AdminController crewlist " + new Date());
	    
	    pageNumber(params);
	    List<CrewDto> crewlist = service.crewlist(params);
	    int len = service.getAllCrew(params);
	    
	    return getList(crewlist, len);
	}
	
}
