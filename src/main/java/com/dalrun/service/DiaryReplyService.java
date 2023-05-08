package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.DiaryReplyDao;
import com.dalrun.dto.DiaryReplyDto;

@Service
@Transactional
public class DiaryReplyService {

	@Autowired
	DiaryReplyDao dao;

	public List<DiaryReplyDto> diaryReplyList() {
		return dao.diaryReplyList();
	}

}
