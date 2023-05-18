package com.dalrun.dto;

import java.time.LocalDateTime;

public class UserCourseDto {

	private int userCSeq;	// 유저의 코스 기록 번호
	private int courseSeq;	// 외래키 관리자 추천 코스 번호
	private String memId;	// 유저 ID
	private int crewSeq;	// 유저의 크루 ID
	private double uCourseTotalDist;	// 총 이동 거리
	private double uCouresTotalTime;	// 총 이동 시간
	private double uCourseMeanPace;	// 평균 페이스
	private double uCourseMaxSlope;	// 최고 경사도
	private double uCourseKcal;
	private LocalDateTime uCourseWdate;
	
	public UserCourseDto() {
	}

	public UserCourseDto(int userCSeq, int courseSeq, String memId, int crewSeq, double uCourseTotalDist,
			double uCouresTotalTime, double uCourseMeanPace, double uCourseMaxSlope, double uCourseKcal,
			LocalDateTime uCourseWdate) {
		super();
		this.userCSeq = userCSeq;
		this.courseSeq = courseSeq;
		this.memId = memId;
		this.crewSeq = crewSeq;
		this.uCourseTotalDist = uCourseTotalDist;
		this.uCouresTotalTime = uCouresTotalTime;
		this.uCourseMeanPace = uCourseMeanPace;
		this.uCourseMaxSlope = uCourseMaxSlope;
		this.uCourseKcal = uCourseKcal;
		this.uCourseWdate = uCourseWdate;
	}

	public int getUserCSeq() {
		return userCSeq;
	}

	public void setUserCSeq(int userCSeq) {
		this.userCSeq = userCSeq;
	}

	public int getCourseSeq() {
		return courseSeq;
	}

	public void setCourseSeq(int courseSeq) {
		this.courseSeq = courseSeq;
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

	public double getuCourseTotalDist() {
		return uCourseTotalDist;
	}

	public void setuCourseTotalDist(double uCourseTotalDist) {
		this.uCourseTotalDist = uCourseTotalDist;
	}

	public double getuCouresTotalTime() {
		return uCouresTotalTime;
	}

	public void setuCouresTotalTime(double uCouresTotalTime) {
		this.uCouresTotalTime = uCouresTotalTime;
	}

	public double getuCourseMeanPace() {
		return uCourseMeanPace;
	}

	public void setuCourseMeanPace(double uCourseMeanPace) {
		this.uCourseMeanPace = uCourseMeanPace;
	}

	public double getuCourseMaxSlope() {
		return uCourseMaxSlope;
	}

	public void setuCourseMaxSlope(double uCourseMaxSlope) {
		this.uCourseMaxSlope = uCourseMaxSlope;
	}

	public double getuCourseKcal() {
		return uCourseKcal;
	}

	public void setuCourseKcal(double uCourseKcal) {
		this.uCourseKcal = uCourseKcal;
	}

	public LocalDateTime getuCourseWdate() {
		return uCourseWdate;
	}

	public void setuCourseWdate(LocalDateTime uCourseWdate) {
		this.uCourseWdate = uCourseWdate;
	}

	@Override
	public String toString() {
		return "UserCourseDto [userCSeq=" + userCSeq + ", courseSeq=" + courseSeq + ", memId=" + memId + ", crewSeq="
				+ crewSeq + ", uCourseTotalDist=" + uCourseTotalDist + ", uCouresTotalTime=" + uCouresTotalTime
				+ ", uCourseMeanPace=" + uCourseMeanPace + ", uCourseMaxSlope=" + uCourseMaxSlope + ", uCourseKcal="
				+ uCourseKcal + ", uCourseWdate=" + uCourseWdate + "]";
	}
	
}
