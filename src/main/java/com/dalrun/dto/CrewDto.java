package com.dalrun.dto;

import java.io.Serializable;

public class CrewDto implements Serializable {
	

	private String setup; // 크루 소개
	private String date; // 크루 생성일
	private String update; //크루 수정일
	private int maxmem; // 크루 인원 수
	private int del; 
	private int level;
	private String img; // 크루 이미지
	private String name; // 크루 이름
	
	public CrewDto() {
		// TODO Auto-generated constructor stub
	}

	public CrewDto(String setup, String date, String update, int maxmem, int del, int level, String img,
			String name) {
		super();
		this.setup = setup;
		this.date = date;
		this.update = update;
		this.maxmem = maxmem;
		this.del = del;
		this.level = level;
		this.img = img;
		this.name = name;
	}

	public String getSetup() {
		return setup;
	}

	public void setSetup(String setup) {
		this.setup = setup;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public int getMaxmem() {
		return maxmem;
	}

	public void setMaxmem(int maxmem) {
		this.maxmem = maxmem;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CrewBbsDto [setup=" + setup + ", date=" + date + ", update=" + update + ", maxmem=" + maxmem + ", del="
				+ del + ", level=" + level + ", img=" + img + ", name=" + name + "]";
	}
	
	 
	

}
