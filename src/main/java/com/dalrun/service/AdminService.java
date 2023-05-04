package com.dalrun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dalrun.dao.AdminDao;
import com.dalrun.dto.CompetitionDto;
import com.dalrun.dto.CrewDto;
import com.dalrun.dto.DiaryDto;
import com.dalrun.dto.MemberDto;
import com.dalrun.dto.OrderDto;
import com.dalrun.dto.ProductDto;
import com.dalrun.dto.ProductInquiryDto;
import com.dalrun.dto.QnaDto;
import com.dalrun.dto.SearchParam;
import com.dalrun.dto.ShoeDto;

@Service
@Transactional
public class AdminService {
	@Autowired
	AdminDao dao;
	
	// 각 테이블의 리스트, 글의 총 수 불러오기
	// 회원 관리
	public List<MemberDto> memberlist(SearchParam params) {
		return dao.memberlist(params);
	}
	
	public int getAllMember(SearchParam params) {
		return dao.getAllMember(params);
	}
	
	public List<CrewDto> crewlist(SearchParam params) {
		return dao.crewlist(params);
	}
	
	public int getAllCrew(SearchParam params) {
		return dao.getAllCrew(params);
	}
	
	// 게시물 관리
	public List<ProductInquiryDto> productinquirylist(SearchParam params) {
		return dao.productinquirylist(params);
	}
	
	public int getAllProductinquiry(SearchParam params) {
		return dao.getAllProductinquiry(params);
	}
	
	public List<QnaDto> qnalist(SearchParam params) {
		return dao.qnalist(params);
	}
	
	public int getAllQna(SearchParam params) {
		return dao.getAllQna(params);
	}
	
	public List<ShoeDto> shoereviewlist(SearchParam params) {
		return dao.shoereviewlist(params);
	}
	
	public int getAllShoereview(SearchParam params) {
		return dao.getAllShoereview(params);
	}
	
	public List<DiaryDto> diarylist(SearchParam params) {
		return dao.diarylist(params);
	}
	
	public int getAllDiary(SearchParam params) {
		return dao.getAllDiary(params);
	}
	
	public List<CompetitionDto> competitionlist(SearchParam params) {
		return dao.competitionlist(params);
	}
	
	public int getAllCompetition(SearchParam params) {
		return dao.getAllCompetition(params);
	}
	
	// 상품관리
	public List<ProductDto> productlist(SearchParam params) {
		return dao.productlist(params);
	}
	
	public int getAllProduct(SearchParam params) {
		return dao.getAllProduct(params);
	}
	
	public List<OrderDto> orderlist(SearchParam params) {
		return dao.orderlist(params);
	}
	
	public int getAllOrder(SearchParam params) {
		return dao.getAllOrder(params);
	}
	
	// 수정/삭제
	// 회원 관리
	public boolean updatereply(ProductInquiryDto inqdto) {
		int n = dao.updatereply(inqdto);
		return n>0?true:false;
	}
	
	public boolean updatemember(MemberDto memDto) {
		int n = dao.updatemember(memDto); 
		return n>0?true:false;
	}
	
	public boolean delmember(String[] checkedList) {
		int n = dao.delmember(checkedList);
		return n>0?true:false;
	}
	
	public boolean updatcrew(CrewDto crewdto) {
		int n = dao.updatecrew(crewdto); 
		return n>0?true:false;
	}
	
	public boolean delcrew(String[] checkedList) {
		int n = dao.delcrew(checkedList);
		return n>0?true:false;
	}
	
	// 게시물 관리
	public boolean delproductinquiry(int[] checkedList) {
		int n = dao.delproductinquiry(checkedList);
		return n>0?true:false;
	}
	
	public boolean delqna(int[] checkedList) {
		int n = dao.delqna(checkedList);
		return n>0?true:false;
	}
	
	public boolean delshoereview(int[] checkedList) {
		int n = dao.delshoereview(checkedList);
		return n>0?true:false;
	}
	
	public boolean deldiary(int[] checkedList) {
		int n = dao.deldiary(checkedList);
		return n>0?true:false;
	}
	
	public boolean delcompetition(int[] checkedList) {
		int n = dao.delcompetition(checkedList);
		return n>0?true:false;
	}
	
	// 쇼핑몰 관리
	public int getProductOrder(String productId) {
		return dao.getProductOrder(productId);
	}
	
	public boolean updateproduct(ProductDto productdto) {
		int n = dao.updateproduct(productdto);
		return n>0?true:false;
	}
	
	public boolean delproduct(String[] checkedList) {
		int n = dao.delproduct(checkedList);
		return n>0?true:false;
	}
	
	public boolean updateorder(OrderDto orderdto) {
		int n = dao.updateorder(orderdto);
		return n>0?true:false;
	}
	
	public boolean delorder(String[] checkedList) {
		int n = dao.delorder(checkedList);
		return n>0?true:false;
	}
}
