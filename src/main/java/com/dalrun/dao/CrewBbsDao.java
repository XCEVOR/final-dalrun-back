package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.CrewBbsDto;
import com.dalrun.dto.CrewBbsParam;

@Mapper
@Repository
public interface CrewBbsDao {
	
	//게시글 조회
	CrewBbsDto getCrewBbs(int cBbsSeq);
	
	int writeCrewBbs(CrewBbsDto crewBbs);
	
	List<CrewBbsDto> crewBbsList(CrewBbsParam param);
	
	int getAllCrewBbs(CrewBbsParam param);

	//게시글 조회수 증가
	int increaseReadCount(int cBbsSeq);
	
	//수정
	int updateCrewBbs(CrewBbsDto crewBbs);
	
	//삭제
	int deleteCrewBbs(CrewBbsDto crewBbs);
	
//	String getImgByCbbsseq(String cBbsSeq);
	String getImgByCbbsseq(int cBbsSeq);
	
	List<CrewBbsDto> selectBbsType(String type);
}
