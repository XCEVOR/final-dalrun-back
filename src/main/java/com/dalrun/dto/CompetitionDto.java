package com.dalrun.dto;

import java.io.Serializable;

public class CompetitionDto implements Serializable{

    private int compdetailSeq;
    private int compSeq;
	private String compdetailTitle;
	private String conpdetailContent;
	private String compdetailLocation; // 대회 지역
	private String compdetailDate;
	private String compdetailOrigFilename;// 대회 원본 사진
	private String compdetailNewFilename; // 대회 변경 사진 
	private int compdetailPrice; 
	private String compdetailMap;// 대회 상세 지도
	private String compdetailLink; // 대회 상세 링크
	
	public CompetitionDto() {
		// TODO Auto-generated constructor stub
	}

    public CompetitionDto(int compdetailSeq, int compSeq, String compdetailTitle, String conpdetailContent,
            String compdetailLocation, String compdetailDate, String compdetailOrigFilename,
            String compdetailNewFilename, int compdetailPrice, String compdetailMap, String compdetailLink) {
        super();
        this.compdetailSeq = compdetailSeq;
        this.compSeq = compSeq;
        this.compdetailTitle = compdetailTitle;
        this.conpdetailContent = conpdetailContent;
        this.compdetailLocation = compdetailLocation;
        this.compdetailDate = compdetailDate;
        this.compdetailOrigFilename = compdetailOrigFilename;
        this.compdetailNewFilename = compdetailNewFilename;
        this.compdetailPrice = compdetailPrice;
        this.compdetailMap = compdetailMap;
        this.compdetailLink = compdetailLink;
    }

    public int getCompdetailSeq() {
        return compdetailSeq;
    }

    public void setCompdetailSeq(int compdetailSeq) {
        this.compdetailSeq = compdetailSeq;
    }

    public int getCompSeq() {
        return compSeq;
    }

    public void setCompSeq(int compSeq) {
        this.compSeq = compSeq;
    }

    public String getCompdetailTitle() {
        return compdetailTitle;
    }

    public void setCompdetailTitle(String compdetailTitle) {
        this.compdetailTitle = compdetailTitle;
    }

    public String getConpdetailContent() {
        return conpdetailContent;
    }

    public void setConpdetailContent(String conpdetailContent) {
        this.conpdetailContent = conpdetailContent;
    }

    public String getCompdetailLocation() {
        return compdetailLocation;
    }

    public void setCompdetailLocation(String compdetailLocation) {
        this.compdetailLocation = compdetailLocation;
    }

    public String getCompdetailDate() {
        return compdetailDate;
    }

    public void setCompdetailDate(String compdetailDate) {
        this.compdetailDate = compdetailDate;
    }

    public String getCompdetailOrigFilename() {
        return compdetailOrigFilename;
    }

    public void setCompdetailOrigFilename(String compdetailOrigFilename) {
        this.compdetailOrigFilename = compdetailOrigFilename;
    }

    public String getCompdetailNewFilename() {
        return compdetailNewFilename;
    }

    public void setCompdetailNewFilename(String compdetailNewFilename) {
        this.compdetailNewFilename = compdetailNewFilename;
    }

    public int getCompdetailPrice() {
        return compdetailPrice;
    }

    public void setCompdetailPrice(int compdetailPrice) {
        this.compdetailPrice = compdetailPrice;
    }

    public String getCompdetailMap() {
        return compdetailMap;
    }

    public void setCompdetailMap(String compdetailMap) {
        this.compdetailMap = compdetailMap;
    }

    public String getCompdetailLink() {
        return compdetailLink;
    }

    public void setCompdetailLink(String compdetailLink) {
        this.compdetailLink = compdetailLink;
    }

    @Override
    public String toString() {
        return "CompetitionDto [compdetailSeq=" + compdetailSeq + ", compSeq=" + compSeq + ", compdetailTitle="
                + compdetailTitle + ", conpdetailContent=" + conpdetailContent + ", compdetailLocation="
                + compdetailLocation + ", compdetailDate=" + compdetailDate + ", compdetailOrigFilename="
                + compdetailOrigFilename + ", compdetailNewFilename=" + compdetailNewFilename + ", compdetailPrice="
                + compdetailPrice + ", compdetailMap=" + compdetailMap + ", compdetailLink=" + compdetailLink + "]";
    }


	
	
	
}
