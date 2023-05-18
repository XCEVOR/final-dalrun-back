package com.dalrun.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class GpxDataDto {

	private int dataSeq;	// gpx data 번호
	private int fileSeq;	// gpx data 초단위 번호(하나의 기록에 대한 초 당 번호)
	private int diarySeq;	// 다이어리 데이터인지 구분
	private int courseSeq;	// 추천 코스 데이터인지 구분
	private int userCSeq;	// 유저 코스 데이터인지 구분
	private String memId;	// 유저 ID
	private double latitude;// 초 당 위도
	private double longitude;// 초 당 경도
	private double altitude;// 초 당 고도
	private double distance;// 초 당 이동 거리
	private double slope;	// 초 당 경사도(소수) * 100 = 경사도(%)
	private String mTime;	// 측정 시간(파싱을 위해)
	private int timeDiff; // 초당 시간(초 단위)
	
	
	public GpxDataDto() {
	}

	

	public GpxDataDto(int dataSeq, int fileSeq, int diarySeq, int courseSeq, int userCSeq, String memId,
			double latitude, double longitude, double altitude, double distance, double slope, String mTime,
			int timeDiff) {
		super();
		this.dataSeq = dataSeq;
		this.fileSeq = fileSeq;
		this.diarySeq = diarySeq;
		this.courseSeq = courseSeq;
		this.userCSeq = userCSeq;
		this.memId = memId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.distance = distance;
		this.slope = slope;
		this.mTime = mTime;
		this.timeDiff = timeDiff;
	}
	

	public int getDataSeq() {
		return dataSeq;
	}


	public void setDataSeq(int dataSeq) {
		this.dataSeq = dataSeq;
	}


	public int getFileSeq() {
		return fileSeq;
	}


	public void setFileSeq(int fileSeq) {
		this.fileSeq = fileSeq;
	}


	public int getDiarySeq() {
		return diarySeq;
	}


	public void setDiarySeq(int diarySeq) {
		this.diarySeq = diarySeq;
	}


	public int getCourseSeq() {
		return courseSeq;
	}


	public void setCourseSeq(int courseSeq) {
		this.courseSeq = courseSeq;
	}
	
	public int getUserCSeq() {
		return userCSeq;
	}

	public void setUserCSeq(int userCSeq) {
		this.userCSeq = userCSeq;
	}

	
	public String getMemId() {
		return memId;
	}

	
	public void setMemId(String memId) {
		this.memId = memId;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public double getAltitude() {
		return altitude;
	}


	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}


	public double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}


	public double getSlope() {
		return slope;
	}


	public void setSlope(double slope) {
		this.slope = slope;
	}


	public String getmTime() {
		return mTime;
	}


	public void setmTime(String mTime) {
		this.mTime = mTime;
	}


	public int getTimeDiff() {
		return timeDiff;
	}


	public void setTimeDiff(int timeDiff) {
		this.timeDiff = timeDiff;
	}

	
	@Override
	public String toString() {
		return "GpxDataDto [dataSeq=" + dataSeq + ", fileSeq=" + fileSeq + ", diarySeq=" + diarySeq + ", courseSeq="
				+ courseSeq + ", userCSeq=" + userCSeq + ", memId=" + memId + ", latitude=" + latitude + ", longitude="
				+ longitude + ", altitude=" + altitude + ", distance=" + distance + ", slope=" + slope + ", mTime="
				+ mTime + ", timeDiff=" + timeDiff + "]";
	}

}
