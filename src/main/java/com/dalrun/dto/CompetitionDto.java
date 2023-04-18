package com.dalrun.dto;

import java.io.Serializable;

public class CompetitionDto implements Serializable{

	private String title;
	private String content;
	private String location; // 대회 지역
	private String date;
	private String orginalfile;// 대회 원본 사진
	private String newfile; // 대회 변경 사진 
	private int price; 
	private String map;// 대회 상세 지도
	private String link; // 대회 상세 링크
	
	public CompetitionDto() {
		// TODO Auto-generated constructor stub
	}

	public CompetitionDto(String title, String content, String location, String date, String orginalfile,
			String newfile) {
		super();
		this.title = title;
		this.content = content;
		this.location = location;
		this.date = date;
		this.orginalfile = orginalfile;
		this.newfile = newfile;
	}

	public CompetitionDto(String title, String content, String location, String date, String orginalfile,
			String newfile, int price, String map, String link) {
		super();
		this.title = title;
		this.content = content;
		this.location = location;
		this.date = date;
		this.orginalfile = orginalfile;
		this.newfile = newfile;
		this.price = price;
		this.map = map;
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOrginalfile() {
		return orginalfile;
	}

	public void setOrginalfile(String orginalfile) {
		this.orginalfile = orginalfile;
	}

	public String getNewfile() {
		return newfile;
	}

	public void setNewfile(String newfile) {
		this.newfile = newfile;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "CompetitionDto [title=" + title + ", content=" + content + ", location=" + location + ", date=" + date
				+ ", orginalfile=" + orginalfile + ", newfile=" + newfile + ", price=" + price + ", map=" + map
				+ ", link=" + link + "]";
	}
	
	
	
}
