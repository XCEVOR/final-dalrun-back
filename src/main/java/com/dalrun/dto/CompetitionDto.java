package com.dalrun.dto;

import java.io.Serializable;

public class CompetitionDto implements Serializable{

    private int compSeq;
	private String compTitle;
	private String compContent;
	private String compLocation; // 대회 상세 지역
	private String compDateStart; // 대회 일정 시작
	private String compDateEnd; // 대회 일정 시작
	
	private String compLocal; // 대회 지역
	private float locationLat; //위치 x 좌표
	private float locationLng; //위치 y 좌표
	private String receiptStart; //대회 시작일
	private String receiptEnd; // 대회 마감일
	private String compimage; // 대회 사진 이름(서버)
	private String oriCompimage; // 대회 사진 이름(원본)
	private String compLink; // 대회 링크
	private String compSponsor; // 스폰서 이름 
	private int readcount; // 조회수
	private int commentcount; // 댓글 개수
	private String comRegdate;	// 대회 일정 작성일
	
	public CompetitionDto() {
		// TODO Auto-generated constructor stub
	}



	public CompetitionDto(int compSeq, String compTitle, String compContent, String compLocation, String compDateStart,
			String compDateEnd, String compLocal, float locationLat, float locationLng, String receiptStart,
			String receiptEnd, String compimage, String oriCompimage, String compLink, String compSponsor,
			int readcount, int commentcount, String comRegdate) {
		super();
		this.compSeq = compSeq;
		this.compTitle = compTitle;
		this.compContent = compContent;
		this.compLocation = compLocation;
		this.compDateStart = compDateStart;
		this.compDateEnd = compDateEnd;
		this.compLocal = compLocal;
		this.locationLat = locationLat;
		this.locationLng = locationLng;
		this.receiptStart = receiptStart;
		this.receiptEnd = receiptEnd;
		this.compimage = compimage;
		this.oriCompimage = oriCompimage;
		this.compLink = compLink;
		this.compSponsor = compSponsor;
		this.readcount = readcount;
		this.commentcount = commentcount;
		this.comRegdate = comRegdate;
	}


	public int getCommentcount() {
		return commentcount;
	}



	public void setCommentcount(int commentcount) {
		this.commentcount = commentcount;
	}



	public int getReadcount() {
		return readcount;
	}



	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}



	public int getCompSeq() {
		return compSeq;
	}



	public void setCompSeq(int compSeq) {
		this.compSeq = compSeq;
	}



	public String getCompTitle() {
		return compTitle;
	}



	public void setCompTitle(String compTitle) {
		this.compTitle = compTitle;
	}



	public String getCompContent() {
		return compContent;
	}



	public void setCompContent(String compContent) {
		this.compContent = compContent;
	}



	public String getCompLocation() {
		return compLocation;
	}



	public void setCompLocation(String compLocation) {
		this.compLocation = compLocation;
	}



	public String getCompDateStart() {
		return compDateStart;
	}



	public void setCompDateStart(String compDateStart) {
		this.compDateStart = compDateStart;
	}



	public String getCompDateEnd() {
		return compDateEnd;
	}



	public void setCompDateEnd(String compDateEnd) {
		this.compDateEnd = compDateEnd;
	}



	public String getCompLocal() {
		return compLocal;
	}



	public void setCompLocal(String compLocal) {
		this.compLocal = compLocal;
	}



	public float getLocationLat() {
		return locationLat;
	}



	public void setLocationLat(float locationLat) {
		this.locationLat = locationLat;
	}



	public float getLocationLng() {
		return locationLng;
	}



	public void setLocationLng(float locationLng) {
		this.locationLng = locationLng;
	}



	public String getReceiptStart() {
		return receiptStart;
	}



	public void setReceiptStart(String receiptStart) {
		this.receiptStart = receiptStart;
	}



	public String getReceiptEnd() {
		return receiptEnd;
	}



	public void setReceiptEnd(String receiptEnd) {
		this.receiptEnd = receiptEnd;
	}



	public String getCompimage() {
		return compimage;
	}



	public void setCompimage(String compimage) {
		this.compimage = compimage;
	}



	public String getOriCompimage() {
		return oriCompimage;
	}



	public void setOriCompimage(String oriCompimage) {
		this.oriCompimage = oriCompimage;
	}



	public String getCompLink() {
		return compLink;
	}



	public void setCompLink(String compLink) {
		this.compLink = compLink;
	}



	public String getCompSponsor() {
		return compSponsor;
	}



	public void setCompSponsor(String compSponsor) {
		this.compSponsor = compSponsor;
	}



	public String getComRegdate() {
		return comRegdate;
	}



	public void setComRegdate(String comRegdate) {
		this.comRegdate = comRegdate;
	}



	@Override
	public String toString() {
		return "CompetitionDto [compSeq=" + compSeq + ", compTitle=" + compTitle + ", compContent=" + compContent
				+ ", compLocation=" + compLocation + ", compDateStart=" + compDateStart + ", compDateEnd=" + compDateEnd
				+ ", compLocal=" + compLocal + ", locationLat=" + locationLat + ", locationLng=" + locationLng
				+ ", receiptStart=" + receiptStart + ", receiptEnd=" + receiptEnd + ", compimage=" + compimage
				+ ", oriCompimage=" + oriCompimage + ", compLink=" + compLink + ", compSponsor=" + compSponsor
				+ ", readcount=" + readcount + ", commentcount=" + commentcount + ", comRegdate=" + comRegdate + "]";
	}
	
}