package com.dalrun.dto;

import java.io.Serializable;

public class CompCommentDto implements Serializable {

	  
	private int CCseq;
	private int compSeq;
	private int CCdel; // 삭제 여부
	private String CCmemId; // 아이디
	private String CCcontent; // 내용
	private String CCwdate; // 작성일
	
	public CompCommentDto() {
		// TODO Auto-generated constructor stub
	}

	public CompCommentDto(int cCseq, int compSeq, int cCdel, String cCmemId, String cCcontent, String cCwdate) {
		super();
		CCseq = cCseq;
		this.compSeq = compSeq;
		CCdel = cCdel;
		CCmemId = cCmemId;
		CCcontent = cCcontent;
		CCwdate = cCwdate;
	}

	public int getCCseq() {
		return CCseq;
	}

	public void setCCseq(int cCseq) {
		CCseq = cCseq;
	}

	public int getCompSeq() {
		return compSeq;
	}

	public void setCompSeq(int compSeq) {
		this.compSeq = compSeq;
	}

	public int getCCdel() {
		return CCdel;
	}

	public void setCCdel(int cCdel) {
		CCdel = cCdel;
	}

	public String getCCmemId() {
		return CCmemId;
	}

	public void setCCmemId(String cCmemId) {
		CCmemId = cCmemId;
	}

	public String getCCcontent() {
		return CCcontent;
	}

	public void setCCcontent(String cCcontent) {
		CCcontent = cCcontent;
	}

	public String getCCwdate() {
		return CCwdate;
	}

	public void setCCwdate(String cCwdate) {
		CCwdate = cCwdate;
	}

	
	
}