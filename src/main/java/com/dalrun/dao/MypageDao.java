package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.CrewBbsDto;
import com.dalrun.dto.CrewDto;
import com.dalrun.dto.CrewMemberDto;
import com.dalrun.dto.DiaryDto;
import com.dalrun.dto.MemberDto;
import com.dalrun.dto.OrderDto;
import com.dalrun.dto.ProductDto;
import com.dalrun.dto.QnaDto;
import com.dalrun.dto.SearchParam;
import com.dalrun.dto.ShoeReviewDto;

@Repository
@Mapper
public interface MypageDao {

	List<MemberDto> memberlist(SearchParam params);
	
	//회원조회
	MemberDto getmember(String target);
	
	int getmyMember(SearchParam params);
	
	List<CrewDto> crewlist(SearchParam params);
	
	List<ProductDto> getProductData (String productCode);
	
	int getAllCrew(SearchParam params);	
	
	int updatemember(MemberDto memDto);

	int updatememberpass(MemberDto memDto);	
	
	int delmember(String[] checkedList);
	
	int updatecrew(CrewDto crewdto);
	
	int delcrew(String[] checkedList);

	List<QnaDto> myqnalist(SearchParam params);
	
	int myAllqnalist(SearchParam params);

	List<CrewBbsDto> myCbslist(SearchParam params);
	
	int myAllCbslist(SearchParam params);

	CrewDto getCrew(int crewSeq);

	List<CrewMemberDto> getCrewMember(int crewSeq);	

    List<OrderDto> orderlist (String memId);

	MemberDto myinform(String memId);

	// 다이어리 리스트 조회
	List<DiaryDto> diaryList(SearchParam param, String memId);
	
	// 다이어리 총 수
	int getAllDiary(SearchParam param);

	List<DiaryDto> getDiaryday(SearchParam param, String memId, String fromwdate, String towdate);
	
	int crewLeave(String memId);
	
    int crewmemberLeave (String memId);

	int crewUpdate(CrewDto crdto);
}
