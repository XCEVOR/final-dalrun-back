package com.dalrun.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dalrun.dto.CrewBbsDto;
import com.dalrun.dto.CrewDto;
import com.dalrun.dto.CrewMemberDto;
import com.dalrun.dto.DiaryDto;
import com.dalrun.dto.DotMapDto;
import com.dalrun.dto.MemberDto;
import com.dalrun.dto.OrderDto;
import com.dalrun.dto.QnaDto;
import com.dalrun.dto.SearchParam;
import com.dalrun.dto.ShoeReviewDto;
import com.dalrun.service.AdminService;
import com.dalrun.service.DotMapService;
import com.dalrun.service.MypageService;
import com.dalrun.service.ProductService;
import com.dalrun.util.FileNameListUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class MypageController {

	@Autowired
	MypageService service;
	@Autowired
	AdminService adminservice;
	@Autowired
	ProductService productService;
	@Autowired
	DotMapService dservice;	
	 
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
    public List<OrderDto> orderlist (String memId) {
        System.out.println("MypageControllerr my_orderlist  " + new Date());
        
        List<OrderDto> list = service.orderlist(memId);
        
        for(OrderDto d:list) {
        	System.out.println(d);
        }
        
        return service.orderlist(memId);
    }	
    
	// 다이어리 리스트
	@GetMapping("my_diaryList")
	public Map<String, Object> DiaryList(SearchParam param, String memId){// List -> Map, ajax는 한번에 데이터를 옮기면 안되고 각각 데이터를 따로따로 보내줘야 한다.
													   // 여러 개의 데이터를 한꺼번에 json 형태로 보내는 법 -> HashMap
		System.out.println("MypageController diaryList " + new Date());
//		
//		// 글의 시작과 끝
//		int pn = param.getPageNumber();  // 0 1 2 3 4
//		int start = 1 + (pn * 10);	// 1  11 21 
//		int end = (pn + 1) * 10;	// 10 20 30
//		
//		param.setStart(start);
//		param.setEnd(end);
		
		List<DiaryDto> list = service.diaryList(param, memId);
		int cnt = service.getAllDiary(param);
		
        for(DiaryDto d:list) {
        	System.out.println(d);
        	System.out.println(memId);
        }	
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", cnt);	// wrapper 형태로 들어 감
		
		return map;
	}  
	
	// 다이어리
	@GetMapping("my_diaryday")
	public Map<String, Object> getDiaryday(SearchParam param, String memId, String fromwdate, String towdate){
													   
		System.out.println("MypageController getDiaryday" + new Date());

		
		List<DiaryDto> list = service.getDiaryday(param, memId, fromwdate, towdate);
		
        for(DiaryDto d:list) {
        	System.out.println(d);
        	System.out.println(fromwdate);
        	System.out.println(towdate);
        }		
        
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		
		return map;
	}
	
	@GetMapping(value = "crewLeave")
	public boolean crewLeave(String memId,int crewSeq){
		
		System.out.println("MypageController crewLeave " + new Date());
        System.out.println("System.out.println(memId); " + memId);
        
		DotMapDto ddto=new DotMapDto();
		ddto.setMemId(memId);
		ddto.setCrewSeq(crewSeq);
		
		dservice.crewOutChangeDotmap(ddto);
		return service.crewLeave(memId);
	}
	
    @GetMapping(value = "crewmemberLeave")
    public String deleteCartItem (String memId) {
        System.out.println("MypageController crewmemberLeave (String " + memId +" ) { " + new Date());
        System.out.println("System.out.println(memId); " + memId);
        boolean isSucc = service.crewmemberLeave(memId);
        if (isSucc == false) {
            return "FAIL";
        }
        return "SUCCESS";
    }
    
    @PostMapping(value = "my_crewUpdate")
	public String crewUpdate(CrewDto crdto){
    	System.out.println("MypageController crewUpdate " + new Date());
		System.out.println(crdto); 	
		
        boolean b = service.crewUpdate(crdto);
        
		return str(b);
	}
}
