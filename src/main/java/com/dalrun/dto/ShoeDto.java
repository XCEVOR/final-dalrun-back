package com.dalrun.dto;

import java.io.Serializable;

public class ShoeDto implements Serializable{
	
    private int shoereviewdetailSeq;
    private int shoereviewSeq;
	private String shoereviewdetailTitle;
	private String shoereviewdetailContent;
	private String shoereviewdetailOrigFilename; // 원본 파일
	private String shoereviewdetailNewFilename; // 변경 파일
	private String memId; 
	private String shoereviewdetailRegdate;
	
	public ShoeDto() {
		// TODO Auto-generated constructor stub
	}

    public ShoeDto(int shoereviewdetailSeq, int shoereviewSeq, String shoereviewdetailTitle,
            String shoereviewdetailContent, String shoereviewdetailOrigFilename, String shoereviewdetailNewFilename,
            String memId, String shoereviewdetailRegdate) {
        super();
        this.shoereviewdetailSeq = shoereviewdetailSeq;
        this.shoereviewSeq = shoereviewSeq;
        this.shoereviewdetailTitle = shoereviewdetailTitle;
        this.shoereviewdetailContent = shoereviewdetailContent;
        this.shoereviewdetailOrigFilename = shoereviewdetailOrigFilename;
        this.shoereviewdetailNewFilename = shoereviewdetailNewFilename;
        this.memId = memId;
        this.shoereviewdetailRegdate = shoereviewdetailRegdate;
    }

    public int getShoereviewdetailSeq() {
        return shoereviewdetailSeq;
    }

    public void setShoereviewdetailSeq(int shoereviewdetailSeq) {
        this.shoereviewdetailSeq = shoereviewdetailSeq;
    }

    public int getShoereviewSeq() {
        return shoereviewSeq;
    }

    public void setShoereviewSeq(int shoereviewSeq) {
        this.shoereviewSeq = shoereviewSeq;
    }

    public String getShoereviewdetailTitle() {
        return shoereviewdetailTitle;
    }

    public void setShoereviewdetailTitle(String shoereviewdetailTitle) {
        this.shoereviewdetailTitle = shoereviewdetailTitle;
    }

    public String getShoereviewdetailContent() {
        return shoereviewdetailContent;
    }

    public void setShoereviewdetailContent(String shoereviewdetailContent) {
        this.shoereviewdetailContent = shoereviewdetailContent;
    }

    public String getShoereviewdetailOrigFilename() {
        return shoereviewdetailOrigFilename;
    }

    public void setShoereviewdetailOrigFilename(String shoereviewdetailOrigFilename) {
        this.shoereviewdetailOrigFilename = shoereviewdetailOrigFilename;
    }

    public String getShoereviewdetailNewFilename() {
        return shoereviewdetailNewFilename;
    }

    public void setShoereviewdetailNewFilename(String shoereviewdetailNewFilename) {
        this.shoereviewdetailNewFilename = shoereviewdetailNewFilename;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getShoereviewdetailRegdate() {
        return shoereviewdetailRegdate;
    }

    public void setShoereviewdetailRegdate(String shoereviewdetailRegdate) {
        this.shoereviewdetailRegdate = shoereviewdetailRegdate;
    }

    @Override
    public String toString() {
        return "ShoeDto [shoereviewdetailSeq=" + shoereviewdetailSeq + ", shoereviewSeq=" + shoereviewSeq
                + ", shoereviewdetailTitle=" + shoereviewdetailTitle + ", shoereviewdetailContent="
                + shoereviewdetailContent + ", shoereviewdetailOrigFilename=" + shoereviewdetailOrigFilename
                + ", shoereviewdetailNewFilename=" + shoereviewdetailNewFilename + ", memId=" + memId
                + ", shoereviewdetailRegdate=" + shoereviewdetailRegdate + "]";
    }

	
	
}
