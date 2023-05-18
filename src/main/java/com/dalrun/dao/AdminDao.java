package com.dalrun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dalrun.dto.CompetitionDto;
import com.dalrun.dto.CrewDto;
import com.dalrun.dto.ScoreRankDto;
import com.dalrun.dto.DashboardData;
import com.dalrun.dto.DiaryDto;
import com.dalrun.dto.MemberDto;
import com.dalrun.dto.OrderDto;
import com.dalrun.dto.ProductDto;
import com.dalrun.dto.ProductInquiryDto;
import com.dalrun.dto.QnaDto;
import com.dalrun.dto.SearchParam;
import com.dalrun.dto.ShoeReviewDetailDto;
import com.dalrun.dto.ShoeReviewDto;
import com.dalrun.dto.VisitorsDto;

@Repository
@Mapper
public interface AdminDao {
	
	// 각 테이블의 리스트, 글의 총 수 불러오기
	// 회원 관리
	List<MemberDto> memberlist(SearchParam params);
	
	int getAllMember(SearchParam params);
	
	List<CrewDto> crewlist(SearchParam params);
	
	int getAllCrew(SearchParam params);
	
	// 게시물 관리
	List<ProductInquiryDto> productinquirylist(SearchParam params);
	
	int getAllProductinquiry(SearchParam params);
	
	List<QnaDto> qnalist(SearchParam params);
	
	int getAllQna(SearchParam params);
	
	List<ShoeReviewDto> shoereviewlist(SearchParam params);
	
	int getAllShoereview(SearchParam params);
	
	List<DiaryDto> diarylist(SearchParam params);
	
	int getAllDiary(SearchParam params);
	
	List<CompetitionDto> competitionlist(SearchParam params);
	
	int getAllCompetition(SearchParam params);
	
	// 상품 관리
	List<ProductDto> productlist(SearchParam params);
	
	int getAllProduct(SearchParam params);
	
	List<OrderDto> orderlist(SearchParam params);
	
	int getAllOrder(SearchParam params);
	
	// 수정/삭제
	// 회원 관리
	int updatemember(MemberDto memDto);
	
	int delmember(String[] checkedList);
	
	int updatecrew(CrewDto crewdto);
	
	int delcrew(String[] checkedList);
	
	// 게시물 관리
	int updatereply(ProductInquiryDto inqdto);
	
	int delreply(int inqSeq);
	
	int delproductinquiry(int[] checkedList);
	
	int delqna(int[] checkedList);
	
	List<Integer> getSrdSeq(int srSeq);
	
	int updateshoereview(ShoeReviewDto srdto);
	
	int updateshoereviewdetail(List<ShoeReviewDetailDto> srdList);
	
	int delshoereview(int[] checkedList);
	
	int delshoereviewdetail(int srdSeq);
	
	int updatediary(DiaryDto diarydto);
	
	int deldiary(int[] checkedList);
	
	int updatecomperition(CompetitionDto compdto);
	
	int delcompetition(int[] checkedList);
	
	// 쇼핑몰 관리
	int getProductOrder(String productId);
	
	int updateproduct(ProductDto productdto);
	
	int delproduct(String[] checkedList);
	
	int updateorder(OrderDto orderdto);
	
	int delorder(String[] checkedList);
	
	// 대시보드
	DashboardData getDashboardData();
	
	List<DashboardData> getWeekSummaryData();
	
	// 차트
	List<ScoreRankDto> getMemberScoreRank();
	
	List<Integer> getCrweSeqList();
	List<ScoreRankDto> getCrewScoreRank();
	
	// 방문자
	int saveCookieData(String user);
	
	int updateCookie(String user);
	
	List<VisitorsDto> getDailyVisitorsCnt();
}
