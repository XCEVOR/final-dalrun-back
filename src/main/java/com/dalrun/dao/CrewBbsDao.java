package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.CrewBbsCommentDto;
import com.dalrun.dto.CrewBbsDto;
import com.dalrun.dto.CrewBbsParam;
import com.dalrun.dto.CrewDto;
import com.dalrun.dto.SearchParam;

@Mapper
@Repository
public interface CrewBbsDao {
	
	//게시글 조회
	CrewDto getCrewBbs(int crewSeq);
	
	int writeCrewBbs(CrewDto crewSeq);
	
	List<CrewDto> crewBbsList(SearchParam param);
	
	int getAllCrewBbs(SearchParam param);

	//게시글 조회수 증가
	int increaseReadCount(int crewSeq);
	
	//수정
	int updateCrewBbs(CrewDto crewBbs);
	
	//삭제
	int deleteCrewBbs(int crewSeq);
	
//	String getImgByCbbsseq(String cBbsSeq);
	String getImgByCbbsseq(int crewSeq);
	
	//전체, 모집중, 모집완료 분류
	List<CrewDto> selectBbsAll();
	List<CrewDto> selectBbsType(String type);
	
	int writeCrewBbsComment(CrewBbsCommentDto dto);
	List<CrewBbsCommentDto> getCrewBbsCommentList(int crewSeq);
    
    List<CrewDto> selectByReadCount(SearchParam param);
    List<CrewDto> selectByLikeCount(SearchParam param);
	
}
