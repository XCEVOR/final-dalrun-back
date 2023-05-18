package com.dalrun.dto;

public class LikeDto {
    private String memId;
    private int crewSeq;

    public LikeDto(){

    }

    public LikeDto(String memId, int crewSeq){
        this.memId = memId;
        this.crewSeq = crewSeq;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public int getCrewSeq() {
        return crewSeq;
    }

    public void setCrewSeq(int cBbsSeq) {
        this.crewSeq = crewSeq;
    }
}