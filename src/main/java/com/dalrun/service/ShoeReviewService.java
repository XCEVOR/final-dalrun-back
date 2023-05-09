package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.ShoeReviewDao;
import com.dalrun.dto.CompCommentDto;
import com.dalrun.dto.CompetitionDto;
import com.dalrun.dto.SearchParam;
import com.dalrun.dto.ShoeReviewDto;
import com.dalrun.dto.ShoereivewCommentDto;

@Service
@Transactional
public class ShoeReviewService {

	
	
	@Autowired
	ShoeReviewDao dao;
	
	public List<ShoeReviewDto> getAllShoeList(SearchParam param) {
		return dao.getAllShoeList(param);
	}
	public int getAllShoeListCount(SearchParam param) {
		return dao.getAllShoeListCount(param);
	}
	
	
	public List<ShoeReviewDto> getAllShoeListThisMonth() {
		return dao.getAllShoeListThisMonth();
	}
	public List<ShoeReviewDto> getPopularShoeList() {
		return dao.getPopularShoeList();
	}

	
	public ShoeReviewDto getReviewBbs(int srSeq) {
		return dao.getReviewBbs(srSeq);
	}
	public ShoeReviewDto getReviewdetailBbs(int srSeq) {
		return dao.getReviewdetailBbs(srSeq);
	}
	
	public List<ShoereivewCommentDto>  getReviewCommentList(int srSeq) {
		return dao.getReviewCommentList(srSeq);
	}
	
	public void ShoeReviewReadcount(int srSeq) {
		dao.ShoeReviewReadcount(srSeq);
		
	}
	
	public boolean ReviewsendComment(ShoereivewCommentDto dto) {
		return dao.ReviewsendComment(dto)>0;
	}
	public List<ShoeReviewDto>  getAllShoedetailList(int srSeq) {
		return dao.getAllShoedetailList(srSeq);
	}
	
	
}
