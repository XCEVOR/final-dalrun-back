package com.dalrun.dto;

import java.io.Serializable;

public class CrewPointDto  implements Serializable{
	
	private String id;
	private int pointSeq;
	private String crewname;
	private String regdate;
	private int score;
	private int crewSeq;
	
	public CrewPointDto() {
		// TODO Auto-generated constructor stub
	}

	public CrewPointDto(String id, int pointSeq, String crewname, String regdate, int score, int crewSeq) {
		super();
		this.id = id;
		this.pointSeq = pointSeq;
		this.crewname = crewname;
		this.regdate = regdate;
		this.score = score;
		this.crewSeq = crewSeq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPointSeq() {
		return pointSeq;
	}

	public void setPointSeq(int pointSeq) {
		this.pointSeq = pointSeq;
	}

	public String getCrewname() {
		return crewname;
	}

	public void setCrewname(String crewname) {
		this.crewname = crewname;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getCrewSeq() {
		return crewSeq;
	}

	public void setCrewSeq(int crewSeq) {
		this.crewSeq = crewSeq;
	}

	@Override
	public String toString() {
		return "CrewPointDto [id=" + id + ", pointSeq=" + pointSeq + ", crewname=" + crewname + ", regdate=" + regdate
				+ ", score=" + score + ", crewSeq=" + crewSeq + "]";
	}

	
	
	

}
