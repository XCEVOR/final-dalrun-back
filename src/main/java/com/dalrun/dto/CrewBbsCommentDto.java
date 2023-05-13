package com.dalrun.dto;

import java.io.Serializable;

//create table `crewRecruitComment`(
//		`cbSeq` int auto_increment	primary key,
//		`cbMemId` varchar(60) not null,
//		`cbContent` varchar(300) not null,
//		`cbWdate` date not null,
//		`cbDel` decimal(1) not null,
//		`cBbsSeq` int not null,
//		foreign key (cBbsSeq) references crewRecruitBbs (cBbsSeq)
//		);

public class CrewBbsCommentDto implements Serializable{
	
	private String cbMemId; //작성자 아이디
	private String cbContent; //댓글 내용
	private String cbWdate; //작성일
	private int cbSeq; //고유값
	private int crewSeq; //크루모집 게시판 고유값
	private int cbDel; //댓글 삭제여부
	
	public CrewBbsCommentDto() {
	}

	public CrewBbsCommentDto(String cbMemId, String cbContent, String cbWdate, int cbSeq, int crewSeq, int cbDel) {
		super();
		this.cbMemId = cbMemId;
		this.cbContent = cbContent;
		this.cbWdate = cbWdate;
		this.cbSeq = cbSeq;
		this.crewSeq = crewSeq;
		this.cbDel = cbDel;
	}

	public String getCbMemId() {
		return cbMemId;
	}

	public void setCbMemId(String cbMemId) {
		this.cbMemId = cbMemId;
	}

	public String getCbContent() {
		return cbContent;
	}

	public void setCbContent(String cbContent) {
		this.cbContent = cbContent;
	}

	public String getCbWdate() {
		return cbWdate;
	}

	public void setCbWdate(String cbWdate) {
		this.cbWdate = cbWdate;
	}

	public int getCbSeq() {
		return cbSeq;
	}

	public void setCbSeq(int cbSeq) {
		this.cbSeq = cbSeq;
	}

	public int getCrewSeq() {
		return crewSeq;
	}

	public void setCrewSeq(int crewSeq) {
		this.crewSeq = crewSeq;
	}

	public int getCbDel() {
		return cbDel;
	}

	public void setCbDel(int cbDel) {
		this.cbDel = cbDel;
	}

	@Override
	public String toString() {
		return "CrewBbsComment [cbMemId=" + cbMemId + ", cbContent=" + cbContent + ", cbWdate=" + cbWdate + ", cbSeq="
				+ cbSeq + ", crewSeq=" + crewSeq + ", cbDel=" + cbDel + "]";
	}

}
