package com.dalrun.dto;

import java.io.Serializable;
import java.sql.Date;

//크루에 속한 멤버들
public class CrewMemberDto implements Serializable{
	private int crewSeq;
   private String memId;
   private String reqMemId;
   
   public CrewMemberDto() {
   }

   public CrewMemberDto(int crewSeq, String memId){
      this.crewSeq = crewSeq;
      this.memId = memId;
   }

   public int getCrewSeq() {
      return crewSeq;
   }

   public void setCrewSeq(int crewSeq) {
      this.crewSeq = crewSeq;
   }

   public String getMemId() {
      return memId;
   }

   public void setMemId(String memId) {
      this.memId = memId;
   }
   public String getReqMemId(){
	   return reqMemId;
   }
   public void setReqMemId(String reqMemId) {
	   this.reqMemId = reqMemId;
   }

@Override
public String toString() {
	return "CrewMemberDto [crewSeq=" + crewSeq + ", memId=" + memId + ", reqMemId=" + reqMemId + "]";
}
   

}