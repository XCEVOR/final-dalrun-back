package com.dalrun.dto;

import java.time.LocalDateTime;

public class VisitorsDto {
	private String user;
	private LocalDateTime fistVisitTime;
	private LocalDateTime lastVisitTime;
	
	public VisitorsDto() {
	}

	public VisitorsDto(String user, LocalDateTime fistVisitTime, LocalDateTime lastVisitTime) {
		super();
		this.user = user;
		this.fistVisitTime = fistVisitTime;
		this.lastVisitTime = lastVisitTime;
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

	@Override
	public String toString() {
		return "VisitorsDto [user=" + user + ", fistVisitTime=" + fistVisitTime + ", lastVisitTime=" + lastVisitTime
				+ "]";
	}
}
