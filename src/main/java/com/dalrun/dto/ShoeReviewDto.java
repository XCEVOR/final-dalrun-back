package com.dalrun.dto;

import java.io.Serializable;

public class ShoeReviewDto implements Serializable{

	private int srSeq;
	private int readcount;
	private int srDel;
	private String srTitle ;
	private String  srCotent;	// 운동화 설명
	private String  srBrand;
	private String  srimage;	// 서버
	private String  oriSrImage;	// 원본
	private String  srLink;
	private String  srwdate;
	private int commentcount; // 댓글 개수
	private String srPrice; // 댓글 개수
	
	
	private String srdSeq; //detail seq
	private String srcomment; // detail 상세 내용

	
	public ShoeReviewDto() {
		// TODO Auto-generated constructor stub
	}
	

	public ShoeReviewDto(String srdSeq, String srcomment) {
		super();
		this.srdSeq = srdSeq;
		this.srcomment = srcomment;
	}



	public ShoeReviewDto(int srSeq, int readcount, int srDel, String srTitle, String srCotent, String srBrand, String srimage,
			String srLink, String srwdate,int commentcount,String srPrice) {
		super();
		this.srSeq = srSeq;
		this.readcount = readcount;
		this.srDel = srDel;
		this.srTitle = srTitle;
		this.srCotent = srCotent;
		this.srBrand = srBrand;
		this.srimage = srimage;
		this.srLink = srLink;
		this.srwdate = srwdate;
		this.commentcount = commentcount;
		this.srPrice = srPrice;
	}
	
	

	public ShoeReviewDto(int srSeq, int readcount, int srDel, String srTitle, String srCotent, String srBrand,
			String srimage, String srLink, String srwdate, String srdSeq, String srcomment) {
		super();
		this.srSeq = srSeq;
		this.readcount = readcount;
		this.srDel = srDel;
		this.srTitle = srTitle;
		this.srCotent = srCotent;
		this.srBrand = srBrand;
		this.srimage = srimage;
		this.srLink = srLink;
		this.srwdate = srwdate;
		this.srdSeq = srdSeq;
		this.srcomment = srcomment;
	}

   

	public String getSrPrice() {
		return srPrice;
	}



	public void setSrPrice(String srPrice) {
		this.srPrice = srPrice;
	}



	public String getSrdSeq() {
		return srdSeq;
	}



	public void setSrdSeq(String srdSeq) {
		this.srdSeq = srdSeq;
	}



	public String getSrcomment() {
		return srcomment;
	}



	public void setSrcomment(String srcomment) {
		this.srcomment = srcomment;
	}



	public int getSrSeq() {
		return srSeq;
	}

	public void setSrSeq(int srSeq) {
		this.srSeq = srSeq;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getSrDel() {
		return srDel;
	}

	public void setSrDel(int srDel) {
		this.srDel = srDel;
	}

	public String getSrTitle() {
		return srTitle;
	}

	public void setSrTitle(String srTitle) {
		this.srTitle = srTitle;
	}

	public String getSrCotent() {
		return srCotent;
	}

	public void setSrCotent(String srCotent) {
		this.srCotent = srCotent;
	}

	public String getSrBrand() {
		return srBrand;
	}

	public void setSrBrand(String srBrand) {
		this.srBrand = srBrand;
	}

	public String getSrimage() {
		return srimage;
	}

	public void setSrimage(String srimage) {
		this.srimage = srimage;
	}

	public String getOriSrImage() {
		return oriSrImage;
	}



	public void setOriSrImage(String oriSrImage) {
		this.oriSrImage = oriSrImage;
	}



	public String getSrLink() {
		return srLink;
	}

	public void setSrLink(String srLink) {
		this.srLink = srLink;
	}

	public String getSrwdate() {
		return srwdate;
	}

	public void setSrwdate(String srwdate) {
		this.srwdate = srwdate;
	}



	public int getCommentcount() {
		return commentcount;
	}



	public void setCommentcount(int commentcount) {
		this.commentcount = commentcount;
	}
	
	
	
	
    
	
}