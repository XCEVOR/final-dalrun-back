package com.dalrun.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class DiaryDto implements Serializable {

	private int diarySeq;	// 다이어리 번호 pk
	private String memId;	// 유저 ID
	private int crewSeq;	// 크루 번호 FK
	private String title;	// 다이어리 글 제목
	private String content; // 다이어리 글 내용
	private LocalDateTime wdate;	// 다이어리 작성일
	private double totalDist;	// 총 이동 거리
	private double totalTime;	// 총 이동 시간
	private double meanPace;	// 평균 페이스(분/km)
	private double maxSlope;	// 평균 경사도
	private double kcal; // 총 소요 칼로리
	private String postId; // 글 고유 아이디
	private int score;	// 점수
	private double diaryDel;	// 삭제 여부
	private String profile;

	public DiaryDto() {
	}
	
	

	public DiaryDto(int diarySeq, String memId, int crewSeq, String title, String content, LocalDateTime wdate,
			double totalDist, double totalTime, double meanPace, double maxSlope, double kcal, String postId, int score,
			double diaryDel, String profile) {
		super();
		this.diarySeq = diarySeq;
		this.memId = memId;
		this.crewSeq = crewSeq;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.totalDist = totalDist;
		this.totalTime = totalTime;
		this.meanPace = meanPace;
		this.maxSlope = maxSlope;
		this.kcal = kcal;
		this.postId = postId;
		this.score = score;
		this.diaryDel = diaryDel;
		this.profile = profile;
	}

	public int getDiarySeq() {
		return diarySeq;
	}

	public void setDiarySeq(int diarySeq) {
		this.diarySeq = diarySeq;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getCrewSeq() {
		return crewSeq;
	}

	public void setCrewSeq(int crewSeq) {
		this.crewSeq = crewSeq;
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

	public LocalDateTime getWdate() {
		return wdate;
	}

	public void setWdate(LocalDateTime wdate) {
		this.wdate = wdate;
	}

	public double getTotalDist() {
		return totalDist;
	}

	public void setTotalDist(double totalDist) {
		this.totalDist = totalDist;
	}

	public double getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(double totalTime) {
		this.totalTime = totalTime;
	}

	public double getMeanPace() {
		return meanPace;
	}

	public void setMeanPace(double meanPace) {
		this.meanPace = meanPace;
	}

	public double getMaxSlope() {
		return maxSlope;
	}

	public void setMaxSlope(double maxSlope) {
		this.maxSlope = maxSlope;
	}

	public double getKcal() {
		return kcal;
	}

	public void setKcal(double kcal) {
		this.kcal = kcal;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public double getDiaryDel() {
		return diaryDel;
	}

	public void setDiaryDel(double diaryDel) {
		this.diaryDel = diaryDel;
	}
	
	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "DiaryDto [diarySeq=" + diarySeq + ", memId=" + memId + ", crewSeq=" + crewSeq + ", title=" + title
				+ ", content=" + content + ", wdate=" + wdate + ", totalDist=" + totalDist + ", totalTime=" + totalTime
				+ ", meanPace=" + meanPace + ", meanSlope=" + maxSlope + ", kcal=" + kcal + ", postId=" + postId
				+ ", score=" + score + ", diaryDel=" + diaryDel + "]";
	}

}
