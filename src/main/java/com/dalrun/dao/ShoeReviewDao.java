package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.CompCommentDto;
import com.dalrun.dto.CompetitionDto;
import com.dalrun.dto.SearchParam;
import com.dalrun.dto.ShoeReviewDto;
import com.dalrun.dto.ShoereivewCommentDto;

@Mapper
@Repository
public interface ShoeReviewDao {

	
	List<ShoeReviewDto> getAllShoeList(SearchParam param);
	int getAllShoeListCount(SearchParam param);
	List<ShoeReviewDto> getAllShoeListThisMonth();
	List<ShoeReviewDto> getPopularShoeList();
	void ShoeReviewReadcount(int srSeq);
	ShoeReviewDto getReviewBbs(int srSeq);
	ShoeReviewDto getReviewdetailBbs(int srSeq);
	List<ShoereivewCommentDto> getReviewCommentList(int srSeq);
	
	int ReviewsendComment(ShoereivewCommentDto dto);
	List<ShoeReviewDto>getAllShoedetailList(int srSeq);
}
