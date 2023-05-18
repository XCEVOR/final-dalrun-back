package com.dalrun.dto;

public class ScoreRankDto {
	private int month;
	private int year;
	private int crewSeq;
	private String crewName;
	private String memId;
	private double monthlyTotalDist;
	private int crewLevel;
	private long monthlyScore;
	private int ranking;
	
	public ScoreRankDto() {
	}

	public ScoreRankDto(int month, int year, int crewSeq, String crewName, String memId, double monthlyTotalDist, int crewLevel, long monthlyScore,
			int ranking) {
		super();
		this.month = month;
		this.year = year;
		this.crewSeq = crewSeq;
		this.crewName = crewName;
		this.memId = memId;
		this.monthlyTotalDist = monthlyTotalDist;
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

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public double getMonthlyTotalDist() {
		return monthlyTotalDist;
	}

	public void setMonthlyTotalDist(double monthlyTotalDist) {
		this.monthlyTotalDist = monthlyTotalDist;
	}

	public int getCrewLevel() {
		return crewLevel;
	}

	public void setCrewLevel(int crewLevel) {
		this.crewLevel = crewLevel;
	}

	public long getMonthlyScore() {
		return monthlyScore;
	}

	public void setMonthlyScore(long monthlyScore) {
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
		return "ScoreRankDto [month=" + month + ", year=" + year + ", crewSeq=" + crewSeq + ", crewName=" + crewName
				+ ", memId=" + memId + ", monthlyTotalDist=" + monthlyTotalDist + ", crewLevel=" + crewLevel
				+ ", monthlyScore=" + monthlyScore + ", ranking=" + ranking + "]";
	}
}
