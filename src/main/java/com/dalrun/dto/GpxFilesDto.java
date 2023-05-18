package com.dalrun.dto;

import java.util.Date;

public class GpxFilesDto {

	private int fileSeq; 		// gpx 파일 번호 pk
	private int diarySeq;		// 다이어리 번호
	private int courseSeq;		// 추천 코스 번호
	private int userCSeq;		// 유저 코스 번소
	private String fileName;	// gpx 파일 이름
	private String filePath;	// gpx 파일 경로
	private String memId;		// 유저 ID 	   fk
	private double distance;	// 이동 거리 값
	private double maxAltitude;	// 최고 고도 값
	private Date uploadDate;	// 업로드 시간

	public GpxFilesDto() {
	}
	
	

	public GpxFilesDto(int fileSeq, int diarySeq, int courseSeq, int userCSeq, String fileName, String filePath,
			String memId, double distance, double maxAltitude, Date uploadDate) {
		super();
		this.fileSeq = fileSeq;
		this.diarySeq = diarySeq;
		this.courseSeq = courseSeq;
		this.userCSeq = userCSeq;
		this.fileName = fileName;
		this.filePath = filePath;
		this.memId = memId;
		this.distance = distance;
		this.maxAltitude = maxAltitude;
		this.uploadDate = uploadDate;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getMaxAltitude() {
		return maxAltitude;
	}

	public void setMaxAltitude(double maxAltitude) {
		this.maxAltitude = maxAltitude;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Override
	public String toString() {
		return "GpxFilesDto [fileSeq=" + fileSeq + ", diarySeq=" + diarySeq + ", courseSeq=" + courseSeq + ", userCSeq="
				+ userCSeq + ", fileName=" + fileName + ", filePath=" + filePath + ", memId=" + memId + ", distance="
				+ distance + ", maxAltitude=" + maxAltitude + ", uploadDate=" + uploadDate + "]";
	}

}
