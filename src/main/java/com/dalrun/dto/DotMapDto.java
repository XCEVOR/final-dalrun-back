package com.dalrun.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DotMapDto implements Serializable {

		private int location;
        private String crewName;
        private String id;
        private String regdate;
        private String message;
        private String groundColor;
    	private String dotOrigFile;// 도트맵 원본 사진
    	private String dotNewFile; // 도트맵 변경 사진
        private String sale;
        private int price;
        
       public DotMapDto() {
		// TODO Auto-generated constructor stub
	}
   
	public DotMapDto(int location, String crewName, String id, String regdate, String message, String groundColor,
			String dotOrigFile, String dotNewFile, String sale, int price) {
		super();
		this.location = location;
		this.crewName = crewName;
		this.id = id;
		this.regdate = regdate;
		this.message = message;
		this.groundColor = groundColor;
		this.dotOrigFile = dotOrigFile;
		this.dotNewFile = dotNewFile;
		this.sale = sale;
		this.price = price;
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


	public int getLocation() {
		return location;
	}


	public void setLocation(int location) {
		this.location = location;
	}



	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCrewName() {
		return crewName;
	}

	public void setCrewName(String crewName) {
		this.crewName = crewName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getGroundcolor() {
		return groundColor;
	}

	public void setGroundcolor(String groundColor) {
		this.groundColor = groundColor;
	}


	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

        
        
        
        
        
      
        

        
    
}
