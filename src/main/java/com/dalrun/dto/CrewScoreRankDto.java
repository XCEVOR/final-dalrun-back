package com.dalrun.dto;

public class CrewScoreRankDto {
	private int month;
	private int year;
	private int crewSeq;
	private String crewName;
	private int crewLevel;
	private int monthlyScore;
	private int ranking;
	
	public CrewScoreRankDto() {
	}

	public CrewScoreRankDto(int month, int year, int crewSeq, String crewName, int crewLevel, int monthlyScore,
			int ranking) {
		super();
		this.month = month;
		this.year = year;
		this.crewSeq = crewSeq;
		this.crewName = crewName;
		this.crewLevel = crewLevel;
		this.monthlyScore = monthlyScore;
		this.ranking = ranking;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCrewSeq() {
		return crewSeq;
	}

	public void setCrewSeq(int crewSeq) {
		this.crewSeq = crewSeq;
	}

	public String getCrewName() {
		return crewName;
	}

	public void setCrewName(String crewName) {
		this.crewName = crewName;
	}

	public int getCrewLevel() {
		return crewLevel;
	}

	public void setCrewLevel(int crewLevel) {
		this.crewLevel = crewLevel;
	}

	public int getMonthlyScore() {
		return monthlyScore;
	}

	public void setMonthlyScore(int monthlyScore) {
		this.monthlyScore = monthlyScore;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	@Override
	public String toString() {
		return "CrewScoreRankDto [month=" + month + ", year=" + year + ", crewSeq=" + crewSeq + ", crewName=" + crewName
				+ ", crewLevel=" + crewLevel + ", monthlyScore=" + monthlyScore + ", ranking=" + ranking + "]";
	}
}
