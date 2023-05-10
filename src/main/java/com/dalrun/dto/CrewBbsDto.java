package com.dalrun.dto;

import java.io.Serializable;

//크루모집 게시판 - db(crewRecuritBbs)
public class CrewBbsDto implements Serializable{
	
	private int cBbsSeq;
	private String memId;
	private String crewName; //크루명
	private String title;
	private String content;
	private String category; //table에는 없는데 나중에 쓸 수도 있을 것 같아서 남겨뒀습니다.
	private String img;
	private int del; //0 : 삭제되지 않은 글, 1 : 삭제된 글
	private String type; //모집중, 모집완료 
	private String wdate;
	private int likecount; // 좋아요 수
	private int readcount; // 조회수 수
	private String crewSetUp; //크루 소개글
	
	private String cbMemId; //댓글 작성자
	private String cbContent; //댓글 내용
	
	
	public CrewBbsDto() {
		// TODO Auto-generated constructor stub
	}


	public CrewBbsDto(String memId, String title, String content, String category, String img, int del, int readcount) {
		super();
		this.memId = memId;
		this.title = title;
		this.content = content;
		this.category = category;
		this.img = img;
		this.del = del;
		this.readcount = readcount;
	}


	public CrewBbsDto(String memId,String tilte, String content, String category, String img, int del, String type, String wdate,
			int likecount, int readcount) {
		this.memId = memId;
		this.title = title;
		this.content = content;
		this.category = category;
		this.img = img;
		this.del = del;
		this.type = type;
		this.wdate = wdate;
		this.likecount = likecount;
		this.readcount = readcount;
	}
	
	
	public CrewBbsDto(int cBbsSeq, String memId, String crewName, String title, String content, String category,
			String img, int del, String type, String wdate, int likecount, int readcount) {
		this.cBbsSeq = cBbsSeq;
		this.memId = memId;
		this.crewName = crewName;
		this.title = title;
		this.content = content;
		this.category = category;
		this.img = img;
		this.del = del;
		this.type = type;
		this.wdate = wdate;
		this.likecount = likecount;
		this.readcount = readcount;
	}

	public CrewBbsDto(int cBbsSeq, String memId, String crewName, String title, String content, String category,
			String img, int del, String type, String wdate, int likecount, int readcount, String crewSetUp,
			String cbMemId, String cbContent) {
		this.cBbsSeq = cBbsSeq;
		this.memId = memId;
		this.crewName = crewName;
		this.title = title;
		this.content = content;
		this.category = category;
		this.img = img;
		this.del = del;
		this.type = type;
		this.wdate = wdate;
		this.likecount = likecount;
		this.readcount = readcount;
		this.crewSetUp = crewSetUp;
		this.cbMemId = cbMemId;
		this.cbContent = cbContent;
	}

	public int getcBbsSeq() {
		return cBbsSeq;
	}


	public void setcBbsSeq(int cBbsSeq) {
		this.cBbsSeq = cBbsSeq;
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


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public int getDel() {
		return del;
	}


	public void setDel(int del) {
		this.del = del;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getWdate() {
		return wdate;
	}


	public void setWdate(String wdate) {
		this.wdate = wdate;
	}


	public int getLikecount() {
		return likecount;
	}


	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}


	public int getReadcount() {
		return readcount;
	}


	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	
	
	public String getCbMemId() {
		return cbMemId;
	}


	public void setCbMemId(String cbMemId) {
		this.cbMemId = cbMemId;
	}
	

	public String getCbContent() {
		return cbContent;
	}
	
	
	public String getCrewSetUp() {
		return crewSetUp;
	}


	public void setCrewSetUp(String crewSetUp) {
		this.crewSetUp = crewSetUp;
	}


	public void setCbContent(String cbContent) {
		this.cbContent = cbContent;
	}


	@Override
	public String toString() {
		return "CrewBbsDto [cBbsSeq=" + cBbsSeq + ", memId=" + memId + ", crewName=" + crewName + ", title=" + title
				+ ", content=" + content + ", category=" + category + ", img=" + img + ", del=" + del + ", type=" + type
				+ ", wdate=" + wdate + ", likecount=" + likecount + ", readcount=" + readcount + "]";
	}


}

	
