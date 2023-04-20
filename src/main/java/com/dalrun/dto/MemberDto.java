package com.dalrun.dto;

import java.io.Serializable;

public class MemberDto  implements Serializable{

	private String id;
	private String password;
	private String name;
	private String phone;
	private String birth;
	private String foot;
	private String profile;
	private String regdate;
	private String update;
	private int auth;
	private int del;
	private int point;
	private String grade;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberDto(String id, String password, String name, String phone, String birth, String foot, String profile,
			String regdate, String update, int auth, int del, int point, String grade) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.birth = birth;
		this.foot = foot;
		this.profile = profile;
		this.regdate = regdate;
		this.update = update;
		this.auth = auth;
		this.del = del;
		this.point = point;
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getFoot() {
		return foot;
	}

	public void setFoot(String foot) {
		this.foot = foot;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + ", birth="
				+ birth + ", foot=" + foot + ", profile=" + profile + ", regdate=" + regdate + ", update=" + update
				+ ", auth=" + auth + ", del=" + del + ", point=" + point + ", grade=" + grade + "]";
	}
	
	
	
	
}
