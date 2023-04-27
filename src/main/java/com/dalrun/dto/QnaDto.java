package com.dalrun.dto;

import java.io.Serializable;

public class QnaDto implements Serializable{
	
	private String id;
	private String category;
	private String title;
	private String wdate;
	private int readcount;
	private String quest;
	private String answer;
	private int auth;
	private int del;
	
	public QnaDto() {
		// TODO Auto-generated constructor stub
	}
  
	

	public QnaDto(String id, String category, String title, String wdate, int readcount, String quest, String answer,
			int auth, int del) {
		super();
		this.id = id;
		this.category = category;
		this.title = title;
		this.wdate = wdate;
		this.readcount = readcount;
		this.quest = quest;
		this.answer = answer;
		this.auth = auth;
		this.del = del;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getQuest() {
		return quest;
	}

	public void setQuest(String quest) {
		this.quest = quest;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}
	@Override
	public String toString() {
		return "QnaDto [id=" + id + ", category=" + category + ", title=" + title + ", wdate=" + wdate + ", readcount="
				+ readcount + ", quest=" + quest + ", answer=" + answer + ", auth=" + auth + ", del=" + del + "]";
	}

}
