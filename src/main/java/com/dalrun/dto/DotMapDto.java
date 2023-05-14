package com.dalrun.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DotMapDto implements Serializable {

		private int location;
        private String crewName;
        private String memId;
        private String regdate;
        private String message;
        private String groundColor;
    	private String dotOrigFile;// 도트맵 원본 사진
    	private String dotNewFile; // 도트맵 변경 사진
        private String sale;
        private int price;
        private int crewSeq;
        private String myFile; // 나의 정보 사진 
        
       public DotMapDto() {
		// TODO Auto-generated constructor stub
	}

	public DotMapDto(int location, String crewName, String memId, String regdate, String message, String groundColor,
			String dotOrigFile, String dotNewFile, String sale, int price, int crewSeq, String myFile) {
		super();
		this.location = location;
		this.crewName = crewName;
		this.memId = memId;
		this.regdate = regdate;
		this.message = message;
		this.groundColor = groundColor;
		this.dotOrigFile = dotOrigFile;
		this.dotNewFile = dotNewFile;
		this.sale = sale;
		this.price = price;
		this.crewSeq = crewSeq;
		this.myFile = myFile;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getGroundColor() {
		return groundColor;
	}

	public void setGroundColor(String groundColor) {
		this.groundColor = groundColor;
	}

	public String getDotOrigFile() {
		return dotOrigFile;
	}

	public void setDotOrigFile(String dotOrigFile) {
		this.dotOrigFile = dotOrigFile;
	}

	public String getDotNewFile() {
		return dotNewFile;
	}

	public void setDotNewFile(String dotNewFile) {
		this.dotNewFile = dotNewFile;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCrewSeq() {
		return crewSeq;
	}

	public void setCrewSeq(int crewSeq) {
		this.crewSeq = crewSeq;
	}

	public String getMyFile() {
		return myFile;
	}

	public void setMyFile(String myFile) {
		this.myFile = myFile;
	}

	@Override
	public String toString() {
		return "DotMapDto [location=" + location + ", crewName=" + crewName + ", memId=" + memId + ", regdate="
				+ regdate + ", message=" + message + ", groundColor=" + groundColor + ", dotOrigFile=" + dotOrigFile
				+ ", dotNewFile=" + dotNewFile + ", sale=" + sale + ", price=" + price + ", crewSeq=" + crewSeq
				+ ", myFile=" + myFile + "]";
	}

       
       
}