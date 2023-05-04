package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalrun.dao.CrewBbsDao;
import com.dalrun.dto.CrewBbsDto;
import com.dalrun.dto.CrewBbsParam;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CrewBbsService {
	@Autowired
	CrewBbsDao dao;
	
	public CrewBbsDto getCrewBbs(int cBbsSeq) {
//		dao.increaseReadCount(cBbsSeq); //조회수 증가
		return dao.getCrewBbs(cBbsSeq); //게시글 정보 반환
	}
	
	public int increaseReadCount(int cBbsSeq) {
		return dao.increaseReadCount(cBbsSeq);
	}
	
	public boolean writeCrewBbs(CrewBbsDto crewBbs) {
		int n=dao.writeCrewBbs(crewBbs);
		return n>0?true:false;
	}
	
	public List<CrewBbsDto> crewBbsList(CrewBbsParam param){
		return dao.crewBbsList(param);
	}
	
	public int getAllCrewBbs(CrewBbsParam param) {
		return dao.getAllCrewBbs(param);
	}
	
	//수정
	public boolean updateCrewBbs(CrewBbsDto crewBbs) {
		int n = dao.updateCrewBbs(crewBbs);
		return n>0?true:false;
	}
	
	//삭제
	public boolean deleteCrewBbs(CrewBbsDto crewBbs) {
		int n = dao.deleteCrewBbs(crewBbs);
		return n>0?true:false;
	}
	
//	 public String getImgByCbbsseq(String cBbsSeq){ 
//		 return dao.getImgByCbbsseq(cBbsSeq);
//		 }
	public String getImgByCbbsseq(int cBbsSeq){ 
		 return dao.getImgByCbbsseq(cBbsSeq);
		 }
	
	public List<CrewBbsDto> selectBbsType(String type){
		return dao.selectBbsType(type);
	}
}
