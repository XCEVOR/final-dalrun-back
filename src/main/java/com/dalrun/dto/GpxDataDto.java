package com.dalrun.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class GpxDataDto {

	private int dataSeq;	// gpx data 번호
	private int fileSeq;	// gpx data 초단위 번호(하나의 기록에 대한 초 당 번호)
	private int diarySeq;	// 다이어리 데이터인지 구분
	private int courseSeq;	// 코스 데이터인지 구분
	private String memId;	// 유저 ID
	private double latitude;// 초 당 위도
	private double longitude;// 초 당 경도
	private double altitude;// 초 당 고도
	private LocalTime mTime;	// 초 당 시간

	public GpxDataDto() {
	}

	public GpxDataDto(int dataSeq, int fileSeq, int diarySeq, int courseSeq, String memId, double latitude,
			double longitude, double altitude, LocalTime mTime) {
		super();
		this.dataSeq = dataSeq;
		this.fileSeq = fileSeq;
		this.diarySeq = diarySeq;
		this.courseSeq = courseSeq;
		this.memId = memId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.mTime = mTime;
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

	public LocalTime getmTime() {
		return mTime;
	}

	public void setmTime(LocalTime time) {
		this.mTime = time;
	}

}
