package com.dalrun.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalrun.dto.QnaDto;
import com.dalrun.service.QnaService;

@RestController
public class QnaController {

	@Autowired
	QnaService service;

    @GetMapping(value = "qnaList")
    public List<QnaDto> qnaList () {
        System.out.println("QnaController qnaList" + new Date());
        return service.qnaList();
    }

}	// <Qna Controller/>
