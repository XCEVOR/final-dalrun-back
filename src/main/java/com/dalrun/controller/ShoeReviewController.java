package com.dalrun.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.ShoeDto;
import com.dalrun.service.ShoeReviewService;

@RestController
public class ShoeReviewController {
    
    @Autowired
    ShoeReviewService service;
    
    @GetMapping(value = "getAllShoeReviewList")
    public List<ShoeDto> getAllShoeReviewList () {
        System.out.println("  @ ShoeReviewController List<ShoeReviewDto> getAllShoeReviewList () { " + new Date());
        return service.getAllShoeReviewList();
    }
    
    @PostMapping(value = "getSingleShoeReview")
    public ShoeDto getSingleShoeReview (int shoereviewdetailSeq) {
        System.out.println("  @ ShoeReviewController ShoeDto getSingleShoeReview (int shoereviewdetailSeq) { " + new Date());
        System.out.println("  @ shoereviewdetailSeq: " + shoereviewdetailSeq);
        return service.getSingleShoeReview(shoereviewdetailSeq);
    }
    


}