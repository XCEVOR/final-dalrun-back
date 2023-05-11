package com.dalrun.dto;

public class ShoeReviewDetailDto {
	
	private int srdSeq;
	private int srSeq;
	private String srcomment;
	private String srimage;	// 서버
	private String  oriSrImage;	// 원본
	
	public ShoeReviewDetailDto() {
		// TODO Auto-generated constructor stub
	}

	public ShoeReviewDetailDto(int srSeq, String srcomment) {
		super();
		this.srdSeq = srdSeq;
		this.srcomment = srcomment;
	}

	public ShoeReviewDetailDto(int srSeq, String srcomment, String srimage, String oriSrImage) {
		super();
		this.srSeq = srSeq;
		this.srcomment = srcomment;
		this.srimage = srimage;
		this.oriSrImage = oriSrImage;
	}

	public int getSrdSeq() {
		return srdSeq;
	}

	public void setSrdSeq(int srdSeq) {
		this.srdSeq = srdSeq;
	}

	public int getSrSeq() {
		return srSeq;
	}

	public void setSrSeq(int srSeq) {
		this.srSeq = srSeq;
	}

	public String getSrcomment() {
		return srcomment;
	}

	public void setSrcomment(String srcomment) {
		this.srcomment = srcomment;
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

	public void setOrSrImage(String oriSrImage) {
		this.oriSrImage = oriSrImage;
	}

	@Override
	public String toString() {
		return "ShoeReviewDetailDto [srdSeq=" + srdSeq + ", srSeq=" + srSeq + ", srcomment=" + srcomment + ", srimage="
				+ srimage + ", oriSrImage=" + oriSrImage + "]";
	}
}
