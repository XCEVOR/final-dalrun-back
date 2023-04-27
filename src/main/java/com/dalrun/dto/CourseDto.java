package com.dalrun.dto;

import java.io.Serializable;

public class CourseDto implements Serializable{
	
	private int courseSeq; 		// 코스 번호
	private int areaCode; 		// 지역 번호
	private String level; 		// 난이도
	private String courseTitle; // 코스 이름
	private String thumbnail; 	// 코스 썸네일
	private String gpx; 		// gpx
	private String content;		// 코스 소개 내용
	private int star; 			// 평점
	
	public CourseDto() {
	}

	public CourseDto(int courseSeq, int areaCode, String level, String courseTitle, String thumbnail, String gpx,
			String content, int star) {
		super();
		this.courseSeq = courseSeq;
		this.areaCode = areaCode;
		this.level = level;
		this.courseTitle = courseTitle;
		this.thumbnail = thumbnail;
		this.gpx = gpx;
		this.content = content;
		this.star = star;
	}

	public int getCourseSeq() {
		return courseSeq;
	}

	public void setCourseSeq(int courseSeq) {
		this.courseSeq = courseSeq;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getGpx() {
		return gpx;
	}

	public void setGpx(String gpx) {
		this.gpx = gpx;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

}
