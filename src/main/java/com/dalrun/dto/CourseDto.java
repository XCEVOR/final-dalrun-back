package com.dalrun.dto;

import java.io.Serializable;

public class CourseDto implements Serializable{
	
	private String area; // 지역 번호
	private int level; // 난이도
	private String title; // 코스 이름
	private String thumbnail; // 코스 썸네일
	private String route; // 코스
	private String content; 
	private int star; // 평점
	
	public CourseDto() {
		// TODO Auto-generated constructor stub
	}

	public CourseDto(String area, int level, String title, String thumbnail, String route, String content, int star) {
		super();
		this.area = area;
		this.level = level;
		this.title = title;
		this.thumbnail = thumbnail;
		this.route = route;
		this.content = content;
		this.star = star;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
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

	@Override
	public String toString() {
		return "CourseDto [area=" + area + ", level=" + level + ", title=" + title + ", thumbnail=" + thumbnail
				+ ", route=" + route + ", content=" + content + ", star=" + star + "]";
	}
	

}
