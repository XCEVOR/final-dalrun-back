package com.dalrun.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CourseDto implements Serializable{

	private int courseSeq; 		// 코스 번호
	private String areaName; 	// 지역 이름
	private String level; 		// 난이도
	private String courseTitle; // 코스 이름
	private String thumbnail; 	// 코스 썸네일
	private String content;		// 코스 소개 내용
	private int star; 			// 평점
	private double aCourseTotalDist;	// 추천 코스 거리
	private double aCourseMaxSlope;		// 추천 코스 최고 경사도
	private LocalDateTime wdate;
	private double kcal;
	private String postId;

	public CourseDto() {
	}

	public CourseDto(int courseSeq, String areaName, String level, String courseTitle, String thumbnail, String content,
			int star, double aCourseTotalDist, double aCourseMaxSlope, LocalDateTime wdate, double kcal,
			String postId) {
		super();
		this.courseSeq = courseSeq;
		this.areaName = areaName;
		this.level = level;
		this.courseTitle = courseTitle;
		this.thumbnail = thumbnail;
		this.content = content;
		this.star = star;
		this.aCourseTotalDist = aCourseTotalDist;
		this.aCourseMaxSlope = aCourseMaxSlope;
		this.wdate = wdate;
		this.kcal = kcal;
		this.postId = postId;
	}


	public int getCourseSeq() {
		return courseSeq;
	}

	public void setCourseSeq(int courseSeq) {
		this.courseSeq = courseSeq;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
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


	public double getaCourseTotalDist() {
		return aCourseTotalDist;
	}


	public void setaCourseTotalDist(double aCourseTotalDist) {
		this.aCourseTotalDist = aCourseTotalDist;
	}


	public double getaCourseMaxSlope() {
		return aCourseMaxSlope;
	}


	public void setaCourseMaxSlope(double aCourseMaxSlope) {
		this.aCourseMaxSlope = aCourseMaxSlope;
	}

	public LocalDateTime getWdate() {
		return wdate;
	}

	public void setWdate(LocalDateTime wdate) {
		this.wdate = wdate;
	}

	public double getKcal() {
		return kcal;
	}

	public void setKcal(double kcal) {
		this.kcal = kcal;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	@Override
	public String toString() {
		return "CourseDto [courseSeq=" + courseSeq + ", areaName=" + areaName + ", level=" + level + ", courseTitle="
				+ courseTitle + ", thumbnail=" + thumbnail + ", content=" + content + ", star=" + star
				+ ", aCourseTotalDist=" + aCourseTotalDist + ", aCourseMaxSlope=" + aCourseMaxSlope + ", wdate=" + wdate
				+ ", kcal=" + kcal + ", postId=" + postId + "]";
	}

}
