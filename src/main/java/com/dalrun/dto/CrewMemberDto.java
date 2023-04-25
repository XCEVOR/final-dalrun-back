package com.dalrun.dto;

import java.io.Serializable;
import java.sql.Date;

//크루에 속한 멤버들
public class CrewMemberDto implements Serializable{
	private int cMemberSeq;
	private int crewSeq;
	private int memId;
	private int crewConfirm;
	private Date crewRegDate;
	private Date crewMemUpdate;
	private int crewMemDel;
	private int crewAuth;
	
	public CrewMemberDto() {
	}
	
	public CrewMemberDto(int crewSeq, int memId, int crewConfirm, Date crewRegDate, int crewMemDel, int crewAuth) {
		super();
		this.crewSeq = crewSeq;
		this.memId = memId;
		this.crewConfirm = crewConfirm;
		this.crewRegDate = crewRegDate;
		this.crewMemDel = crewMemDel;
		this.crewAuth = crewAuth;
	}


	public CrewMemberDto(int cMemberSeq, int crewSeq, int memId, int crewConfirm, Date crewRegDate, Date crewMemUpdate,
			int crewMemDel, int crewAuth) {
		super();
		this.cMemberSeq = cMemberSeq;
		this.crewSeq = crewSeq;
		this.memId = memId;
		this.crewConfirm = crewConfirm;
		this.crewRegDate = crewRegDate;
		this.crewMemUpdate = crewMemUpdate;
		this.crewMemDel = crewMemDel;
		this.crewAuth = crewAuth;
	}

	public int getcMemberSeq() {
		return cMemberSeq;
	}

	public void setcMemberSeq(int cMemberSeq) {
		this.cMemberSeq = cMemberSeq;
	}

	public int getCrewSeq() {
		return crewSeq;
	}

	public void setCrewSeq(int crewSeq) {
		this.crewSeq = crewSeq;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}

	public int getCrewConfirm() {
		return crewConfirm;
	}

	public void setCrewConfirm(int crewConfirm) {
		this.crewConfirm = crewConfirm;
	}

	public Date getCrewRegDate() {
		return crewRegDate;
	}

	public void setCrewRegDate(Date crewRegDate) {
		this.crewRegDate = crewRegDate;
	}

	public Date getCrewMemUpdate() {
		return crewMemUpdate;
	}

	public void setCrewMemUpdate(Date crewMemUpdate) {
		this.crewMemUpdate = crewMemUpdate;
	}

	public int getCrewMemDel() {
		return crewMemDel;
	}

	public void setCrewMemDel(int crewMemDel) {
		this.crewMemDel = crewMemDel;
	}

	public int getCrewAuth() {
		return crewAuth;
	}

	public void setCrewAuth(int crewAuth) {
		this.crewAuth = crewAuth;
	}

	@Override
	public String toString() {
		return "CrewMemberDto [cMemberSeq=" + cMemberSeq + ", crewSeq=" + crewSeq + ", memId=" + memId
				+ ", crewConfirm=" + crewConfirm + ", crewRegDate=" + crewRegDate + ", crewMemUpdate=" + crewMemUpdate
				+ ", crewMemDel=" + crewMemDel + ", crewAuth=" + crewAuth + "]";
	}
	
}
