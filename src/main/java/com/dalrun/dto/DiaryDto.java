package com.dalrun.dto;

import java.io.Serializable;

public class DiaryDto implements Serializable {

	private String title;
	private String content;
	private String gpx; // 파일 내용
	private String record; // 기록
	private String time; // 측정 시간
	private String wdate;
	
	public DiaryDto() {
		// TODO Auto-generated constructor stub
	}

	public DiaryDto(String title, String content, String gpx, String record, String time, String wdate) {
		super();
		this.title = title;
		this.content = content;
		this.gpx = gpx;
		this.record = record;
		this.time = time;
		this.wdate = wdate;
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

	public String getGpx() {
		return gpx;
	}

	public void setGpx(String gpx) {
		this.gpx = gpx;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "DiaryDto [title=" + title + ", content=" + content + ", gpx=" + gpx + ", record=" + record + ", time="
				+ time + ", wdate=" + wdate + "]";
	}
	
	
	
}
