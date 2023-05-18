package com.dalrun.controller;

import com.dalrun.dto.LikeDto;
import com.dalrun.service.LikeService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikeController {
    @Autowired
    LikeService service;

    @PostMapping(value="/like")
    public String like(@RequestBody LikeDto param){
    	System.out.println("LikeController like : " + new Date());
		String memId = param.getMemId();
		int crewSeq = param.getCrewSeq();
		System.out.println("memId" + memId);
		        if(service.like(memId, crewSeq)){
		        	service.likeUpcount(crewSeq);
		            return "정상적으로 추천되었습니다.";
		        }else{
		            return "추천에 실패하였습니다.";    
		        }
		    }

    @PostMapping(value="/getllike")
    public String getllike(@RequestBody LikeDto param){
    	System.out.println("LikeController getllike : " + new Date());
    	String memId = param.getMemId();
    	int crewSeq = param.getCrewSeq();
    	System.out.println("memId" + memId);
        if (service.getlike(memId, crewSeq)){
            return "이미 추천했습니다.";
        }else{
            return "추천하지 않았습니다.";
        }
    }

    @PostMapping(value="/cancellike")
    public String cancelllike(@RequestBody LikeDto param){
    	System.out.println("LikeController cancelllike : " + new Date());
    	String memId = param.getMemId();
    	int crewSeq = param.getCrewSeq();
    	System.out.println("memId" + memId);
        if (service.cancellike(memId, crewSeq)){
        	service.likeDowncount(crewSeq);
            return "정상적으로 취소되었습니다.";
        }else{
            return "취소에 실패하였습니다.";
        }
    }
}