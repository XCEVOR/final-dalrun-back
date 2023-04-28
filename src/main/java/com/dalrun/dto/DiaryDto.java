package com.dalrun.dto;

import java.io.Serializable;
import java.sql.Date;

public class DiaryDto implements Serializable {

	private int diarySeq;	// 다이어리 번호 pk
	private String memId;	// 유저 ID
	private int crewSeq;	// 크루 번호 FK
	private String title;	// 다이어리 글 제목
	private String content; // 다이어리 글 내용
	private Date wdate;	// 다이어리 작성일

	public DiaryDto() {
	}

	public DiaryDto(int diarySeq, String memId, int crewSeq, String title, String content, Date wdate) {
		super();
		this.diarySeq = diarySeq;
		this.memId = memId;
		this.crewSeq = crewSeq;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
	}

	public int getDiarySeq() {
		return diarySeq;
	}

	public void setDiarySeq(int diarySeq) {
		this.diarySeq = diarySeq;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getCrewSeq() {
		return crewSeq;
	}

	public void setCrewSeq(int crewSeq) {
		this.crewSeq = crewSeq;
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

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

}
