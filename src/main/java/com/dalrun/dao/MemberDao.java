package com.dalrun.dao;

import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

import com.dalrun.dto.MemberDto;

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
	
	int MinusPoint(MemberDto dto);
	
	MemberDto getmemberbyemail(String email);
	
	//user memId 가져옴
	String getMemId(String memId);
}
