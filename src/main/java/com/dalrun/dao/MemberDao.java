package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.DiaryDto;
import com.dalrun.dto.MemberDto;
import com.dalrun.dto.SearchParam;

@Mapper
@Repository
public interface MemberDao{
	
	//아이디 중복체크
	int idcheck(String memId);
	
	//회원가입
	int addmember(MemberDto dto);
	
	//로그인
	MemberDto login(MemberDto dto);

	//회원조회
	MemberDto getmember(String target);
	  
	// 다이어리 리스트 조회
	List<DiaryDto> diaryList(SearchParam param);
	
	MemberDto getmemberbyemail(String email);
	
	//user memId 가져옴
	String getMemId(String memId);
  
  
  
    int MemberMinusPoint(MemberDto dto);
	
	List<MemberDto>mycrewMemberList(int crewSeq);

	
	int crewLeave(String memId);
	
	//아이디 찾기
	String findId(MemberDto dto);

   String findPw(MemberDto dto);

   int setNewPw(@Param("newPw") String newPw, @Param("memId") String memId);

   
   // 글 업로드 시 포인트 plus
   int plusPostPoint(String memId);
   

}
