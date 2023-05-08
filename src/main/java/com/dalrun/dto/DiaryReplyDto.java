package com.dalrun.dto;

import java.util.Date;

public class DiaryReplyDto {

	private int dReplySeq;	// 댓글 번호
	private String memId;	// 유저 ID
	private int crewSeq;	// 크루 번호
	private String content;	// 댓글 내용
	private int diarySeq;	// 다이어리 번호
	private Date wdate;// 작성 일

	public DiaryReplyDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DiaryReplyDto(int dReplySeq, int crewSeq, String content, int diarySeq, String memId, Date wdate) {
		super();
		this.dReplySeq = dReplySeq;
		this.crewSeq = crewSeq;
		this.content = content;
		this.diarySeq = diarySeq;
		this.memId = memId;
		this.wdate = wdate;
	}

	public int getdReplySeq() {
		return dReplySeq;
	}

	public void setdReplySeq(int dReplySeq) {
		this.dReplySeq = dReplySeq;
	}

	public int getCrewSeq() {
		return crewSeq;
	}

	public void setCrewSeq(int crewSeq) {
		this.crewSeq = crewSeq;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}



}
