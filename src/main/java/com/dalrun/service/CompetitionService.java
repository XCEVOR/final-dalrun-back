package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalrun.dao.CompetitionDao;
import com.dalrun.dto.CompCommentDto;
import com.dalrun.dto.CompetitionDto;
import com.dalrun.dto.SearchParam;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CompetitionService {
	
	
	@Autowired
	CompetitionDao dao;
	
	public List<CompetitionDto> getAllList(SearchParam params) {
		return dao.getAllList(params);
	}
	public List<CompetitionDto> getAllListThisMonth() {
		return dao.getAllListThisMonth();
	}
	public List<CompetitionDto> getPopularList() {
		return dao.getPopularList();
	}
	public int getAllListCount(SearchParam params) {
		return dao.getAllListCount(params);
	}
	

	
	public CompetitionDto getCompBbs(int comeSeq) {
		return dao.getCompBbs(comeSeq);
	}
	
	public List<CompCommentDto>  getCompCommentList(int comeSeq) {
		return dao.getCompCommentList(comeSeq);
	}
	
	public void compReadcount(int comeSeq) {
		dao.compReadcount(comeSeq);
		
	}
	
	public boolean sendComment(CompCommentDto dto) {
		return dao.sendComment(dto)>0;
	}
	
	public boolean insertcompetition(CompetitionDto compdto) {
		int n = dao.insertcompetition(compdto);
		return n>0?true:false;
	}
	
	

}
