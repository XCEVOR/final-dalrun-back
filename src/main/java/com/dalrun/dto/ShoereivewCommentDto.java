package com.dalrun.dto;

import java.io.Serializable;

public class ShoereivewCommentDto implements Serializable {

	private String scmemId;
	private String sccontent;
	private String scwdate;
	private int scSeq;
	private int srSeq;
	private int scdel;
	
	
	public ShoereivewCommentDto() {
		// TODO Auto-generated constructor stub
	}


	public ShoereivewCommentDto(String scmemId, String sccontent, String scwdate, int scSeq, int srSeq, int scdel) {
		super();
		this.scmemId = scmemId;
		this.sccontent = sccontent;
		this.scwdate = scwdate;
		this.scSeq = scSeq;
		this.srSeq = srSeq;
		this.scdel = scdel;
	}


	public String getScmemId() {
		return scmemId;
	}


	public void setScmemId(String scmemId) {
		this.scmemId = scmemId;
	}


	public String getSccontent() {
		return sccontent;
	}


	public void setSccontent(String sccontent) {
		this.sccontent = sccontent;
	}


	public String getScwdate() {
		return scwdate;
	}


	public void setScwdate(String scwdate) {
		this.scwdate = scwdate;
	}


	public int getScSeq() {
		return scSeq;
	}


	public void setScSeq(int scSeq) {
		this.scSeq = scSeq;
	}


	public int getSrSeq() {
		return srSeq;
	}


	public void setSrSeq(int srSeq) {
		this.srSeq = srSeq;
	}


	public int getScdel() {
		return scdel;
	}


	public void setScdel(int scdel) {
		this.scdel = scdel;
	}
	
	
	
	
    
}