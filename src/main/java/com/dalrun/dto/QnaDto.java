package com.dalrun.dto;

import java.io.Serializable;

public class QnaDto implements Serializable{
	
	private int qnaSeq;			// QnA 번호 
	private int category;		// 질문 카테고리
	private String title;		// 질문 제목
	private String wdate;		// 작성 일
	private int readcount;		// 조회 수
	private String question;	// 질문 글 내용 
	private String answer;		// 답변 글 내용
	private int auth;			// 운영자, 작성자 구분
	private int del;			// 삭제x
	
	public QnaDto() {
	}

	public QnaDto(int qnaSeq, int category, String title, String wdate, int readcount, String question, String answer,
			int auth, int del) {
		super();
		this.qnaSeq = qnaSeq;
		this.category = category;
		this.title = title;
		this.wdate = wdate;
		this.readcount = readcount;
		this.question = question;
		this.answer = answer;
		this.auth = auth;
		this.del = del;
	}

	public int getQnaSeq() {
		return qnaSeq;
	}

	public void setQnaSeq(int qnaSeq) {
		this.qnaSeq = qnaSeq;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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

}
