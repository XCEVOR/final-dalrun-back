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
	private String myrank; // 나의 크루 랭킹 
	private String crewcolor; // 크루 색상
	
	public CrewDto() {
		// TODO Auto-generated constructor stub
	}

	public CrewDto(int crewSeq, String memId, String crewSetUp, String crewCreateDate, String crewUpdate, int maxMem,
			int crewDel, int crewLevel, String crewImg, String crewName, int crewScore, String myrank,
			String crewcolor) {
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

	public String getMyrank() {
		return myrank;
	}

	public void setMyrank(String myrank) {
		this.myrank = myrank;
	}

	public String getCrewcolor() {
		return crewcolor;
	}

	public void setCrewcolor(String crewcolor) {
		this.crewcolor = crewcolor;
	}

	@Override
	public String toString() {
		return "CrewDto [crewSeq=" + crewSeq + ", memId=" + memId + ", crewSetUp=" + crewSetUp + ", crewCreateDate="
				+ crewCreateDate + ", crewUpdate=" + crewUpdate + ", maxMem=" + maxMem + ", crewDel=" + crewDel
				+ ", crewLevel=" + crewLevel + ", crewImg=" + crewImg + ", crewName=" + crewName + ", crewScore="
				+ crewScore + ", myrank=" + myrank + ", crewcolor=" + crewcolor + "]";
	}
	
}