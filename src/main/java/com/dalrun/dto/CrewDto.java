package com.dalrun.dto;

import java.io.Serializable;

public class CrewDto implements Serializable {
	

	private String crewsetUp; // 크루 소개
	private String crewcreateDate; // 크루 생성일
	private String crewupdate; //크루 수정일
	private int maxmem; // 크루 인원 수
	private int crewdel; 
	private int crewlevel;
	private String crewimg; // 크루 이미지
	private String crewname; // 크루 이름
	private int crewscore; // 크루 점수
	private String myrank; // 나의 크루 랭킹 
	private String crewcolor; // 크루 색상
	
	public CrewDto() {
		// TODO Auto-generated constructor stub
	}

	public CrewDto(String crewsetUp, String crewcreateDate, String crewupdate, int maxmem, int crewdel, int crewlevel,
			String crewimg, String crewname, int crewscore, String myrank,String crewcolor) {
		super();
		this.crewsetUp = crewsetUp;
		this.crewcreateDate = crewcreateDate;
		this.crewupdate = crewupdate;
		this.maxmem = maxmem;
		this.crewdel = crewdel;
		this.crewlevel = crewlevel;
		this.crewimg = crewimg;
		this.crewname = crewname;
		this.crewscore = crewscore;
		this.myrank = myrank;
		this.crewcolor = crewcolor;
	}

	public String getCrewcolor() {
		return crewcolor;
	}

	public void setCrewcolor(String crewcolor) {
		this.crewcolor = crewcolor;
	}

	public String getMyrank() {
		return myrank;
	}

	public void setMyrank(String myrank) {
		this.myrank = myrank;
	}

	public String getCrewsetUp() {
		return crewsetUp;
	}

	public void setCrewsetUp(String crewsetUp) {
		this.crewsetUp = crewsetUp;
	}

	public String getCrewcreateDate() {
		return crewcreateDate;
	}

	public void setCrewcreateDate(String crewcreateDate) {
		this.crewcreateDate = crewcreateDate;
	}

	public String getCrewupdate() {
		return crewupdate;
	}

	public void setCrewupdate(String crewupdate) {
		this.crewupdate = crewupdate;
	}

	public int getMaxmem() {
		return maxmem;
	}

	public void setMaxmem(int maxmem) {
		this.maxmem = maxmem;
	}

	public int getCrewdel() {
		return crewdel;
	}

	public void setCrewdel(int crewdel) {
		this.crewdel = crewdel;
	}

	public int getCrewlevel() {
		return crewlevel;
	}

	public void setCrewlevel(int crewlevel) {
		this.crewlevel = crewlevel;
	}

	public String getCrewimg() {
		return crewimg;
	}

	public void setCrewimg(String crewimg) {
		this.crewimg = crewimg;
	}

	public String getCrewname() {
		return crewname;
	}

	public void setCrewname(String crewname) {
		this.crewname = crewname;
	}

	public int getCrewscore() {
		return crewscore;
	}

	public void setCrewscore(int crewscore) {
		this.crewscore = crewscore;
	}

	
	
}