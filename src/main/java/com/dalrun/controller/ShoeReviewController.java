package com.dalrun.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.SearchParam;
import com.dalrun.dto.ShoeReviewDto;
import com.dalrun.dto.ShoereivewCommentDto;
import com.dalrun.service.ShoeReviewService;

@RestController
public class ShoeReviewController {

	
	@Autowired
	ShoeReviewService service;
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
	
	
	@GetMapping(value = "getAllShoeList")
	public Map<String, Object> getAllShoeList(SearchParam param){
		System.out.println("ShoeReviewController getAllShoeList "+new Date());
		pageNumber(param);
		
		List<ShoeReviewDto> list=service.getAllShoeList(param);
		int len= service.getAllShoeListCount(param);
	 
	
		return getList(list, len);
	}
	
	@GetMapping(value="getAllShoeListThisMonth")
	public List<ShoeReviewDto> getAllListThisMonth(){
		System.out.println("ShoeReviewController getAllShoeListThisMonth "+new Date());
		return service.getAllShoeListThisMonth();
	}
	@GetMapping(value="getPopularShoeList")
	public List<ShoeReviewDto> getPopularShoeList(){
		System.out.println("ShoeReviewController getPopularShoeList "+new Date());
		return service.getPopularShoeList();
	}
	
	@GetMapping(value="getReviewBbs")
	public ShoeReviewDto getReviewBbs(int srSeq){
	   System.out.println("ShoeReviewController getReviewBbs "+new Date());
	   service.ShoeReviewReadcount(srSeq);
		return service.getReviewBbs(srSeq);
	}
	@GetMapping(value="getReviewdetailBbs")
	public ShoeReviewDto getReviewdetailBbs(int srSeq){
		System.out.println("ShoeReviewController getReviewdetailBbs "+new Date());
	
		return service.getReviewdetailBbs(srSeq);
	}
	
	@GetMapping(value="getReviewCommentList")
	public List<ShoereivewCommentDto> getReviewCommentList(int srSeq){
	   System.out.println("ShoeReviewController getReviewCommentList "+new Date());
	   
		return service.getReviewCommentList(srSeq);
	}
	@GetMapping(value="ReviewsendComment")
	public String ReviewsendComment (ShoereivewCommentDto dto){
		System.out.println("ShoeReviewController ReviewsendComment "+new Date());
		String str= "NO";
		
		if(service.ReviewsendComment(dto)) {
			str="YES";
		}
		
		return str;
	}
	@GetMapping(value="getAllShoedetailList")
	public List<ShoeReviewDto> getAllShoedetailList(int srSeq){
	   System.out.println("ShoeReviewController getAllShoedetailList "+new Date());
	   
		return service.getAllShoedetailList(srSeq);
	}
	
	
}
