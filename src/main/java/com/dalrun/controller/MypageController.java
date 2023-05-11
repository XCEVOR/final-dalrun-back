package com.dalrun.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.CrewBbsDto;
import com.dalrun.dto.CrewDto;
import com.dalrun.dto.CrewMemberDto;
import com.dalrun.dto.MemberDto;
import com.dalrun.dto.OrderDto;
import com.dalrun.dto.QnaDto;
import com.dalrun.dto.SearchParam;
import com.dalrun.service.AdminService;
import com.dalrun.service.MypageService;
import com.dalrun.service.ProductService;

@RestController
public class MypageController {

	@Autowired
	MypageService service;
	@Autowired
	AdminService adminservice;
	@Autowired
	ProductService productService;
	 
	private void pageNumber(SearchParam params) {
	    // 글의 시작과 끝
	    int pn = params.getPageNumber();  // 0 1 2 3 4
	    int start = 1 + (pn * 10);    // 1  11
	    int end = (pn + 1) * 10;    // 10 20

	    params.setStart(start);
	    params.setEnd(end);
	}
	
    @GetMapping("myinform")
    public MemberDto myinform(@RequestParam String memId) {
        return service.myinform(memId);
    }
	
	private Map<String, Object> getList(List<?> list, int cnt) {
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", cnt);
		
		return map;
	}	

	@GetMapping(value = "mycbslist")
	public Map<String, Object> mycbslist(SearchParam params) {
	    System.out.println("MypageController mycbslist " + new Date());
	    
		int pn = params.getPageNumber();  // 0 1 2 3 4
		int start = 1 + (pn * 10);	// 1  11
		int end = (pn + 1) * 10;	// 10 20 		
		
		params.setStart(start);
		params.setEnd(end);
		
	    List<CrewBbsDto> mycbslist = service.myCbslist(params);
		int len = service.myAllCbslist(params);
		
		System.out.println(params.toString());
	    return getList(mycbslist, len);

	}	
	
	@GetMapping(value = "myAllcbslist")
	public int myAllCbslist(SearchParam params) {
		
		return service.myAllCbslist(params);
	}	

	
	@GetMapping(value = "myqnalist")
	public Map<String, Object> myqnalist(SearchParam params) {
	    System.out.println("MypageController myqnalist " + new Date());
	    
		int pn = params.getPageNumber();  // 0 1 2 3 4
		int start = 1 + (pn * 10);	// 1  11
		int end = (pn + 1) * 10;	// 10 20 		
		
		params.setStart(start);
		params.setEnd(end);
		
	    List<QnaDto> myqnalist = service.myqnalist(params);
		int len = service.myAllqnalist(params);
		
		System.out.println(params.toString());
	    return getList(myqnalist, len);

	}	
	
	@GetMapping(value = "myAllqnalist")
	public int myAllqnalist(SearchParam params) {
		
		return service.myAllqnalist(params);
	}
	// 수정/삭제
	
	private String str(boolean b) {
		if(!b) return "NO";
		return "YES";
	}	
	
	@GetMapping(value = "my_memberlist")
	public Map<String, Object> memberlist(SearchParam params) {
	    System.out.println("MypageController memberlist " + new Date());
	    
	    pageNumber(params);	    
	    List<MemberDto> memberlist = service.memberlist(params);
		int len = service.getmyMember(params);
	    
	    return getList(memberlist, len);
	}
	
	@PostMapping(value = "my_updatemember")
	public String updatemember(MemberDto memDto) {
		System.out.println("MypageController updatemember " + new Date());
		System.out.println(memDto);
		
		boolean b = service.updatemember(memDto);
		return str(b);
	}	
	
	@PostMapping(value = "my_updatememberpass")
	public String updatememberpass(MemberDto memDto) {
		System.out.println("MypageController updatememberpass " + new Date());
		System.out.println(memDto);
		
		boolean b = service.updatememberpass(memDto);
		return str(b);
	}	
	
	@PostMapping(value = "my_getcrew")
	public CrewDto getCrew(@RequestParam("target") int crewSeq) {
		System.out.println("MypageController getCrew " + new Date());
		return service.getCrew(crewSeq);
	}
	
	@PostMapping(value = "my_getCrewMember")
	public List<CrewMemberDto> getCrewMember(int crewSeq) {
		System.out.println("MypageController getCrewMember " + new Date());
		return service.getCrewMember(crewSeq);
	}	
	
    
    @GetMapping(value = "my_orderlist")
    public List<OrderDto> orderlist () {
        System.out.println("MypageControllerr my_orderlist  " + new Date());
        return service.orderlist();
    }	
}
