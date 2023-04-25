package com.dalrun.dto;

import java.io.Serializable;

public class ShoecommentDto implements Serializable {

    private int shoereviewcommentSeq;
    private int shoereviewdetailSeq;
    private String shoereviewcommentTitle;
    private String shoereviewcommentContent;
    private String memId;
    private int shoereviewcommentDel;
    
    public ShoecommentDto() {
        // TODO Auto-generated constructor stub
    }

    public ShoecommentDto(int shoereviewcommentSeq, int shoereviewdetailSeq, String shoereviewcommentTitle,
            String shoereviewcommentContent, String memId, int shoereviewcommentDel) {
        super();
        this.shoereviewcommentSeq = shoereviewcommentSeq;
        this.shoereviewdetailSeq = shoereviewdetailSeq;
        this.shoereviewcommentTitle = shoereviewcommentTitle;
        this.shoereviewcommentContent = shoereviewcommentContent;
        this.memId = memId;
        this.shoereviewcommentDel = shoereviewcommentDel;
    }

    public int getShoereviewcommentSeq() {
        return shoereviewcommentSeq;
    }

    public void setShoereviewcommentSeq(int shoereviewcommentSeq) {
        this.shoereviewcommentSeq = shoereviewcommentSeq;
    }

    public int getShoereviewdetailSeq() {
        return shoereviewdetailSeq;
    }

    public void setShoereviewdetailSeq(int shoereviewdetailSeq) {
        this.shoereviewdetailSeq = shoereviewdetailSeq;
    }

    public String getShoereviewcommentTitle() {
        return shoereviewcommentTitle;
    }

    public void setShoereviewcommentTitle(String shoereviewcommentTitle) {
        this.shoereviewcommentTitle = shoereviewcommentTitle;
    }

    public String getShoereviewcommentContent() {
        return shoereviewcommentContent;
    }

    public void setShoereviewcommentContent(String shoereviewcommentContent) {
        this.shoereviewcommentContent = shoereviewcommentContent;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public int getShoereviewcommentDel() {
        return shoereviewcommentDel;
    }

    public void setShoereviewcommentDel(int shoereviewcommentDel) {
        this.shoereviewcommentDel = shoereviewcommentDel;
    }

    @Override
    public String toString() {
        return "ShoecommentDto [shoereviewcommentSeq=" + shoereviewcommentSeq + ", shoereviewdetailSeq="
                + shoereviewdetailSeq + ", shoereviewcommentTitle=" + shoereviewcommentTitle
                + ", shoereviewcommentContent=" + shoereviewcommentContent + ", memId=" + memId
                + ", shoereviewcommentDel=" + shoereviewcommentDel + "]";
    }
    
    
}
