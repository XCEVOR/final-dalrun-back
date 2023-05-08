package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.CompCommentDto;
import com.dalrun.dto.CompetitionDto;
import com.dalrun.dto.SearchParam;

@Mapper
@Repository
public interface CompetitionDao {

	List<CompetitionDto> getAllList(SearchParam params);
	List<CompetitionDto> getAllListThisMonth();
	List<CompetitionDto> getPopularList();
	int getAllListCount(SearchParam params);
	void compReadcount(int comeSeq);
	CompetitionDto getCompBbs(int comeSeq);
	List<CompCommentDto> getCompCommentList(int comeSeq);
	int sendComment(CompCommentDto dto);
	
	int insertcompetition(CompetitionDto compdto);
}
