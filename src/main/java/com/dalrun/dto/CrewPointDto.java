package com.dalrun.dto;

import java.io.Serializable;

public class CrewPointDto  implements Serializable{
	
	private String id;
	private int pointseq;
	private String crewname;
	private String regdate;
	private int score;
	
	public CrewPointDto() {
		// TODO Auto-generated constructor stub
	}

	public CrewPointDto(String id, int pointseq, String regdate, int score, String crewname) {
		super();
		this.id = id;
		this.pointseq = pointseq;
		this.regdate = regdate;
		this.score = score;
		this.crewname = crewname;
	}
	

	public String getCrewname() {
		return crewname;
	}

	public void setCrewname(String crewname) {
		this.crewname = crewname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPointseq() {
		return pointseq;
	}

	public void setPointseq(int pointseq) {
		this.pointseq = pointseq;
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
	
	
	

}
