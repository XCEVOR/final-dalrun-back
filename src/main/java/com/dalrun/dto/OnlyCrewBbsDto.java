package com.dalrun.dto;

import java.io.Serializable;
import java.util.Date;

public class OnlyCrewBbsDto implements Serializable{
	
	private int onlyCrewBbsSeq;
	private String memId;
	private String onlyCrewTitle;
	private String onlyCrewContent;
	private String onlyCrewCategory;
	private String onlyCrewImg;
	private Date onlyCrewBbsRegdate;
	private int onlyCrewDel; //기본 1
	private int onlyCrewReadCount;
	
	public OnlyCrewBbsDto() {
	}
	
	public OnlyCrewBbsDto(String memId, String onlyCrewTitle, String onlyCrewContent, String onlyCrewCategory,
			String onlyCrewImg) {
		super();
		this.memId = memId;
		this.onlyCrewTitle = onlyCrewTitle;
		this.onlyCrewContent = onlyCrewContent;
		this.onlyCrewCategory = onlyCrewCategory;
		this.onlyCrewImg = onlyCrewImg;
	}

	public OnlyCrewBbsDto(int onlyCrewBbsSeq, String memId, String onlyCrewTitle, String onlyCrewContent,
			String onlyCrewCategory, String onlyCrewImg, Date onlyCrewBbsRegdate, int onlyCrewDel,
			int onlyCrewReadCount) {
		super();
		this.onlyCrewBbsSeq = onlyCrewBbsSeq;
		this.memId = memId;
		this.onlyCrewTitle = onlyCrewTitle;
		this.onlyCrewContent = onlyCrewContent;
		this.onlyCrewCategory = onlyCrewCategory;
		this.onlyCrewImg = onlyCrewImg;
		this.onlyCrewBbsRegdate = onlyCrewBbsRegdate;
		this.onlyCrewDel = onlyCrewDel;
		this.onlyCrewReadCount = onlyCrewReadCount;
	}

	@Override
	public String toString() {
		return "OnlyCrewBbsDto [onlyCrewBbsSeq=" + onlyCrewBbsSeq + ", memId=" + memId + ", onlyCrewTitle="
				+ onlyCrewTitle + ", onlyCrewContent=" + onlyCrewContent + ", onlyCrewCategory=" + onlyCrewCategory
				+ ", onlyCrewImg=" + onlyCrewImg + ", onlyCrewBbsRegdate=" + onlyCrewBbsRegdate + ", onlyCrewDel="
				+ onlyCrewDel + ", onlyCrewReadCount=" + onlyCrewReadCount + "]";
	}
	
}
