package com.dalrun.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DotMapDto implements Serializable {

		private int location;
        private String crewName;
        private String id;
        private String regdate;
        private String message;
        private String groundcolor;
        private String image;
        private String sale;
        private int price;
        
       public DotMapDto() {
		// TODO Auto-generated constructor stub
	}
       
       
       
     
	public DotMapDto(int location, String crewName, String id, String regdate, String message, String groundcolor,
			String image, String sale, int price) {
		super();
		this.location = location;
		this.crewName = crewName;
		this.id = id;
		this.regdate = regdate;
		this.message = message;
		this.groundcolor = groundcolor;
		this.image = image;
		this.sale = sale;
		this.price = price;
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
		return groundcolor;
	}

	public void setGroundcolor(String groundcolor) {
		this.groundcolor = groundcolor;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}

        
        
        
        
        
      
        

        
    
}
