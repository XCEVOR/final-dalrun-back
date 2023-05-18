package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalrun.dao.CrewBbsDao;
import com.dalrun.dto.CrewBbsCommentDto;
import com.dalrun.dto.CrewBbsDto;
import com.dalrun.dto.CrewBbsParam;
import com.dalrun.dto.CrewDto;
import com.dalrun.dto.SearchParam;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CrewBbsService {
	@Autowired
	CrewBbsDao dao;
	
	public CrewDto getCrewBbs(int crewSeq) {
//		dao.increaseReadCount(cBbsSeq); //조회수 증가
		return dao.getCrewBbs(crewSeq); //게시글 정보 반환
	}
	
	public int increaseReadCount(int crewSeq) {
		return dao.increaseReadCount(crewSeq);
	}
	
	public boolean writeCrewBbs(CrewDto crewBbs) {
		int n=dao.writeCrewBbs(crewBbs);
		return n>0?true:false;
	}
	
	public List<CrewDto> crewBbsList(SearchParam param){
		return dao.crewBbsList(param);
	}
	
	public int getAllCrewBbs(SearchParam param) {
		return dao.getAllCrewBbs(param);
	}
	
	//수정
	public boolean updateCrewBbs(CrewDto crewBbs) {
		int n = dao.updateCrewBbs(crewBbs);
		return n>0?true:false;
	}
	
	//삭제
	public boolean deleteCrewBbs(int crewSeq) {
		int n = dao.deleteCrewBbs(crewSeq);
		return n>0?true:false;
	}
	
	public String getImgByCbbsseq(int crewSeq){ 
		 return dao.getImgByCbbsseq(crewSeq);
		 }
	
	public List<CrewDto> selectBbsAll(){
		return dao.selectBbsAll();
	}
	
	public List<CrewDto> selectBbsType(String type){
		return dao.selectBbsType(type);
	}
	
	public boolean writeCrewBbsComment(CrewBbsCommentDto dto) {
		int n= dao.writeCrewBbsComment(dto);
		return n>0?true:false;
	}
	
	public List<CrewBbsCommentDto> getCrewBbsCommentList(int crewSeq){
		return dao.getCrewBbsCommentList(crewSeq);
	}
	
	public List<CrewDto> getBbsListByReadCount(SearchParam param){
		return dao.selectByReadCount(param);
	}
	
	public List<CrewDto> getBbsListByLikeCount(SearchParam param){
		return dao.selectByLikeCount(param);
	}
}
