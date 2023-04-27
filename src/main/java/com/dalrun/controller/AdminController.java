package com.dalrun.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.CompetitionDto;
import com.dalrun.dto.CrewDto;
import com.dalrun.dto.MemberDto;
import com.dalrun.dto.OrderDto;
import com.dalrun.dto.ProductDto;
import com.dalrun.dto.ProductInquiryDto;
import com.dalrun.dto.QnaDto;
import com.dalrun.dto.SearchParam;
import com.dalrun.dto.ShoeDto;
import com.dalrun.service.AdminService;
import com.dalrun.service.ProductService;

@RestController
public class AdminController {
	@Autowired
	AdminService service;
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
	
	private Map<String, Object> getList(List<?> list, int cnt) {
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", cnt);
		
		return map;
	}
	
	// 각 테이블의 리스트, 글의 총 수 불러오기
	// 회원 관리
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
	
	// 게시물 관리
	@GetMapping(value = "admin_productinquirylist")
	public Map<String, Object> productinquirylist(SearchParam params) {
	    System.out.println("AdminController productinquirylist " + new Date());
	    
	    pageNumber(params);
	    List<ProductInquiryDto> productinquirylist = service.productinquirylist(params);
	    int len = service.getAllProductinquiry(params);
	    
	    return getList(productinquirylist, len);
	}
	
	/*
	@GetMapping(value = "admin_qnalist")
	public Map<String, Object> qnalist(SearchParam params) {
	    System.out.println("AdminController qnalist " + new Date());
	    
	    pageNumber(params);	    
	    List<QnaDto> qnalist = service.qnalist(params);
		int len = service.getAllQna(params);
	    
	    return getList(qnalist, len);
	}
	*/
	@GetMapping(value = "admin_shoereviewlist")
	public Map<String, Object> shoereviewlist(SearchParam params) {
	    System.out.println("AdminController shoereviewlist " + new Date());
	    
	    pageNumber(params);
	    List<ShoeDto> shoereviewlist = service.shoereviewlist(params);
	    int len = service.getAllShoereview(params);
	    
	    return getList(shoereviewlist, len);
	}
	
	@GetMapping(value = "admin_competitionlist")
	public Map<String, Object> competitionlist(SearchParam params) {
	    System.out.println("AdminController competitionlist " + new Date());
	    
	    pageNumber(params);	    
	    List<CompetitionDto> competitionlist = service.competitionlist(params);
		int len = service.getAllCompetition(params);
	    
	    return getList(competitionlist, len);
	}
	
	// 상품 관리
	@GetMapping(value = "admin_productlist")
	public Map<String, Object> productlist(SearchParam params) {
	    System.out.println("AdminController productlist " + new Date());
	    
	    pageNumber(params);
	    List<ProductDto> productlist = service.productlist(params);
	    int len = service.getAllProduct(params);
	    
	    return getList(productlist, len);
	}
	
	@GetMapping(value = "admin_orderlist")
	public Map<String, Object> orderlist(SearchParam params) {
	    System.out.println("AdminController orderlist " + new Date());
	    
	    pageNumber(params);
	    List<OrderDto> orderlist = service.orderlist(params);
	    int len = service.getAllOrder(params);
	    
	    return getList(orderlist, len);
	}
	
	// 수정/삭제
	private String str(boolean b) {
		if(!b) return "NO";
		return "YES";
	}
	
	// 회원 관리
	@PostMapping(value = "admin_updatemember")
	public String updatemember(MemberDto memDto) {
		System.out.println("AdminController updatemember " + new Date());
		System.out.println(memDto);
		
		boolean b = service.updatemember(memDto);
		return str(b);
	}
	
	@PostMapping(value = "admin_delmember")
	public String delmember(@RequestParam("checkedList") String[] checkedList) {
		System.out.println("AdminController delmember " + new Date());
		System.out.println("checkedList = " + Arrays.toString(checkedList));
		
		boolean b = service.delmember(checkedList);
		return str(b);
	}
	
	// 쇼핑몰 관리
	@PostMapping(value = "getproduct")
	public Map<String, Object> getProduct(@RequestParam("target") String productId) {
		System.out.println("AdminController getProduct " + new Date());
		
		Map<String, Object> map = new HashMap<>();
		
		int orderCnt = service.getProductOrder(productId);
		ProductDto product = productService.getCartProductInfo(productId);
		
		map.put("getProduct", product);
		map.put("orderCnt", orderCnt);
		
		return map; 
	}
}
