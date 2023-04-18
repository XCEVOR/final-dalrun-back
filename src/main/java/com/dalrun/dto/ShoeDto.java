package com.dalrun.dto;

import java.io.Serializable;

public class ShoeDto implements Serializable{
	
	
	private String content;
	private int del; // 삭제 여부
	private String title;
	private String originalfile; // 원본 파일
	private String newfile; // 변경 파일
	private String date; 
	private String id;
	
	public ShoeDto() {
		// TODO Auto-generated constructor stub
	}

	public ShoeDto(String content, int del, String title, String originalfile, String newfile, String date, String id) {
		super();
		this.content = content;
		this.del = del;
		this.title = title;
		this.originalfile = originalfile;
		this.newfile = newfile;
		this.date = date;
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOriginalfile() {
		return originalfile;
	}

	public void setOriginalfile(String originalfile) {
		this.originalfile = originalfile;
	}

	public String getNewfile() {
		return newfile;
	}

	public void setNewfile(String newfile) {
		this.newfile = newfile;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ShoeDto [content=" + content + ", del=" + del + ", title=" + title + ", originalfile=" + originalfile
				+ ", newfile=" + newfile + ", date=" + date + ", id=" + id + "]";
	}
	
}
