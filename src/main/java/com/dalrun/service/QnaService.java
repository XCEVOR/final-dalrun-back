package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.QnaDao;
import com.dalrun.dto.QnaDto;

@Service
@Transactional
public class QnaService {

	@Autowired
	QnaDao dao;

	public List<QnaDto> qnaList() {
		return dao.qnaList();
	}

}
