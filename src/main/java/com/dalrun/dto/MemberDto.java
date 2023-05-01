package com.dalrun.dto;

import java.io.Serializable;
import java.util.Date;

public class MemberDto implements Serializable {
	private String memId;
    private String password;
    private String memberName;
    private String email;
    private String phone;
    private String birth;
    private String foot;
    private String profile;
    private Date regdate;
    private Date memberupdate;
    private int auth; ///1 : 일반회원
    private int del;
    private int point;
    private String grade;
    private int crewSeq;
    
	public MemberDto() {
	}

	//로그인
	public MemberDto(String memId, String password) {
		this.memId = memId;
		this.password = password;
	}

	//회원가입
	public MemberDto(String memId, String password, String memberName, String email, String phone, String birth,
			String foot, String profile,int point) {
		this.memId = memId;
		this.password = password;
		this.memberName = memberName;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
		this.foot = foot;
		this.profile = profile;
		this.point = point;
		
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getMemberupdate() {
		return memberupdate;
	}

	public void setMemberupdate(Date memberupdate) {
		this.memberupdate = memberupdate;
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

	public int getCrewSeq() {
		return crewSeq;
	}

	public void setCrewSeq(int crewSeq) {
		this.crewSeq = crewSeq;
	}

	@Override
	public String toString() {
		return "MemberDto [memId=" + memId + ", password=" + password + ", memberName=" + memberName + ", email="
				+ email + ", phone=" + phone + ", birth=" + birth + ", foot=" + foot + ", profile=" + profile
				+ ", regdate=" + regdate + ", memberupdate=" + memberupdate + ", auth=" + auth + ", del=" + del
				+ ", point=" + point + ", grade=" + grade + ", crewSeq=" + crewSeq + "]";
	}
}
