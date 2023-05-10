package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalrun.dao.MypageDao;
import com.dalrun.dto.CrewBbsDto;
import com.dalrun.dto.CrewDto;
import com.dalrun.dto.CrewMemberDto;
import com.dalrun.dto.MemberDto;
import com.dalrun.dto.OrderDto;
import com.dalrun.dto.QnaDto;
import com.dalrun.dto.SearchParam;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MypageService {

	@Autowired
	MypageDao dao;

	public MypageDao getDao() {
		return dao;
	}

	public void setDao(MypageDao dao) {
		this.dao = dao;
	}
	
	public List<QnaDto> myqnalist(SearchParam params) {
		return dao.myqnalist(params);
	}	
	
	public int myAllqnalist(SearchParam params) {
		return dao.myAllqnalist(params);
	}
	
	public List<CrewBbsDto> myCbslist(SearchParam params) {
		return dao.myCbslist(params);
	}	
	
	public int myAllCbslist(SearchParam params) {
		return dao.myAllCbslist(params);
	}
	
	public boolean updatemember(MemberDto memDto) {
		int n = dao.updatemember(memDto); 
		return n>0?true:false;
	}	
	
	public boolean updatememberpass(MemberDto memDto) {
		int n = dao.updatememberpass(memDto); 
		return n>0?true:false;
	}
	
	public List<MemberDto> memberlist(SearchParam params) {
		return dao.memberlist(params);
	}	
	
    public MemberDto myinform(String memId) {
        return dao.myinform(memId);
    }
	
	public int getmyMember(SearchParam params) {
		return dao.getmyMember(params);
	}	
	public CrewDto getCrew(int crewSeq) {
		return dao.getCrew(crewSeq);
	}
	public List<CrewMemberDto> getCrewMember(int crewSeq) {
		return dao.getCrewMember(crewSeq);
	}	
	
    public List<OrderDto> orderlist () {
        return dao.orderlist();
    }	
    
}
