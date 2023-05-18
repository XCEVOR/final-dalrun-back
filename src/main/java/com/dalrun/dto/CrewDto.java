package com.dalrun.dto;

import java.io.Serializable;

//크루
public class CrewDto implements Serializable {
	
	private int crewSeq;
	private String memId;
	private String crewSetUp; // 크루 소개
	private String crewCreateDate; // 크루 생성일
	private String crewUpdate; //크루 수정일
	private int maxMem; // 크루 인원 수
	private int crewDel; 
	private int crewLevel;
	private String crewImg; // 크루 이미지
	private String crewName; // 크루 이름
	private int crewScore; // 크루 점수
	private int myrank; // 나의 크루 랭킹 
	private String crewcolor; // 크루 색상
	private int crewMemberCnt;	// 크루 멤버 수
	private long crewTotalScore; // 크루 총 점수
	private String title;
	private String content;
	private String type;
	private int readCount;
	private int likeCount;
	private int groundCount;
	private String leader;
	
//	private String cbMemId; //댓글 작성자
//	private String cbContent;
//	private String cbWdate; //작성일
	
	public CrewDto() {
		// TODO Auto-generated constructor stub
	}

public CrewDto(int crewSeq, String memId, String crewSetUp, String crewCreateDate, String crewUpdate, int maxMem,
		int crewDel, int crewLevel, String crewImg, String crewName, int crewScore, int myrank, String crewcolor,
		int crewMemberCnt, long crewTotalScore, String title, String content, String type, int readCount, int likeCount,
		int groundCount, String leader) {
	super();
	this.crewSeq = crewSeq;
	this.memId = memId;
	this.crewSetUp = crewSetUp;
	this.crewCreateDate = crewCreateDate;
	this.crewUpdate = crewUpdate;
	this.maxMem = maxMem;
	this.crewDel = crewDel;
	this.crewLevel = crewLevel;
	this.crewImg = crewImg;
	this.crewName = crewName;
	this.crewScore = crewScore;
	this.myrank = myrank;
	this.crewcolor = crewcolor;
	this.crewMemberCnt = crewMemberCnt;
	this.crewTotalScore = crewTotalScore;
	this.title = title;
	this.content = content;
	this.type = type;
	this.readCount = readCount;
	this.likeCount = likeCount;
	this.groundCount = groundCount;
	this.leader = leader;
}

public CrewDto(int crewSeq, String crewName, long crewTotalScore) {
	this.crewSeq = crewSeq;
	this.crewName = crewName;
	this.crewTotalScore = crewTotalScore;
}

public int getCrewSeq() {
	return crewSeq;
}

public void setCrewSeq(int crewSeq) {
	this.crewSeq = crewSeq;
}

public String getMemId() {
	return memId;
}

public void setMemId(String memId) {
	this.memId = memId;
}

public String getCrewSetUp() {
	return crewSetUp;
}

public void setCrewSetUp(String crewSetUp) {
	this.crewSetUp = crewSetUp;
}

public String getCrewCreateDate() {
	return crewCreateDate;
}

public void setCrewCreateDate(String crewCreateDate) {
	this.crewCreateDate = crewCreateDate;
}

public String getCrewUpdate() {
	return crewUpdate;
}

public void setCrewUpdate(String crewUpdate) {
	this.crewUpdate = crewUpdate;
}

public int getMaxMem() {
	return maxMem;
}

public void setMaxMem(int maxMem) {
	this.maxMem = maxMem;
}

public int getCrewDel() {
	return crewDel;
}

public void setCrewDel(int crewDel) {
	this.crewDel = crewDel;
}

public int getCrewLevel() {
	return crewLevel;
}

public void setCrewLevel(int crewLevel) {
	this.crewLevel = crewLevel;
}

public String getCrewImg() {
	return crewImg;
}

public void setCrewImg(String crewImg) {
	this.crewImg = crewImg;
}

public String getCrewName() {
	return crewName;
}

public void setCrewName(String crewName) {
	this.crewName = crewName;
}

public int getCrewScore() {
	return crewScore;
}

public void setCrewScore(int crewScore) {
	this.crewScore = crewScore;
}

public int getMyrank() {
	return myrank;
}

public void setMyrank(int myrank) {
	this.myrank = myrank;
}

public String getCrewcolor() {
	return crewcolor;
}

public void setCrewcolor(String crewcolor) {
	this.crewcolor = crewcolor;
}

public int getCrewMemberCnt() {
	return crewMemberCnt;
}

public void setCrewMemberCnt(int crewMemberCnt) {
	this.crewMemberCnt = crewMemberCnt;
}

public long getCrewTotalScore() {
	return crewTotalScore;
}

public void setCrewTotalScore(long crewTotalScore) {
	this.crewTotalScore = crewTotalScore;
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

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getLeader() {
	return leader;
}

public void setLeader(String leader) {
	this.leader = leader;
}

public int getReadCount() {
	return readCount;
}

public void setReadCount(int readCount) {
	this.readCount = readCount;
}

public int getLikeCount() {
	return likeCount;
}

public void setLikeCount(int likeCount) {
	this.likeCount = likeCount;
}

public int getGroundCount() {
	return groundCount;
}

public void setGroundCount(int groundCount) {
	this.groundCount = groundCount;
}

@Override
public String toString() {
	return "CrewDto [crewSeq=" + crewSeq + ", memId=" + memId + ", crewSetUp=" + crewSetUp + ", crewCreateDate="
			+ crewCreateDate + ", crewUpdate=" + crewUpdate + ", maxMem=" + maxMem + ", crewDel=" + crewDel
			+ ", crewLevel=" + crewLevel + ", crewImg=" + crewImg + ", crewName=" + crewName + ", crewScore="
			+ crewScore + ", myrank=" + myrank + ", crewcolor=" + crewcolor + ", crewMemberCnt=" + crewMemberCnt
			+ ", crewTotalScore=" + crewTotalScore + ", title=" + title + ", content=" + content + ", type=" + type
			+ ", readCount=" + readCount + ", likeCount=" + likeCount + ", groundCount=" + groundCount + ", leader="
			+ leader + "]";
}

	
}