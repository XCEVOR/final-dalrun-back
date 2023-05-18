package com.dalrun.dto;

import java.time.LocalDateTime;

public class VisitorsDto {
	private String user;
	private LocalDateTime fistVisitTime;
	private LocalDateTime lastVisitTime;
	
	private int dailyVisitorsCnt;
	private String weekDate;
	
	public VisitorsDto() {
	}

	public VisitorsDto(String user, LocalDateTime fistVisitTime, LocalDateTime lastVisitTime, int dailyVisitorsCnt,
			String weekDate) {
		super();
		this.user = user;
		this.fistVisitTime = fistVisitTime;
		this.lastVisitTime = lastVisitTime;
		this.dailyVisitorsCnt = dailyVisitorsCnt;
		this.weekDate = weekDate;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public LocalDateTime getFistVisitTime() {
		return fistVisitTime;
	}

	public void setFistVisitTime(LocalDateTime fistVisitTime) {
		this.fistVisitTime = fistVisitTime;
	}

	public LocalDateTime getLastVisitTime() {
		return lastVisitTime;
	}

	public void setLastVisitTime(LocalDateTime lastVisitTime) {
		this.lastVisitTime = lastVisitTime;
	}

	public int getDailyVisitorsCnt() {
		return dailyVisitorsCnt;
	}

	public void setDailyVisitorsCnt(int dailyVisitorsCnt) {
		this.dailyVisitorsCnt = dailyVisitorsCnt;
	}

	public String getWeekDate() {
		return weekDate;
	}

	public void setWeekDate(String weekDate) {
		this.weekDate = weekDate;
	}

	@Override
	public String toString() {
		return "VisitorsDto [user=" + user + ", fistVisitTime=" + fistVisitTime + ", lastVisitTime=" + lastVisitTime
				+ ", dailyVisitorsCnt=" + dailyVisitorsCnt + ", weekDate=" + weekDate + "]";
	}
}
